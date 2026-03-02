package calorias;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalorieController {
    
    // Tus listas genéricas que manejan la lógica de datos
    private ListaEnlazada<Dias> historial = new ListaEnlazada<>();
    private ListaEnlazada<Comidas> listaHoy = new ListaEnlazada<>();
    
    // Variables para los totales del día actual
    private double cT = 0, pT = 0, chT = 0, gT = 0;

    /**
     * Constructor del controlador.
     * Se ejecuta una sola vez cuando la App arranca en Render.
     * Llama al método de persistencia para recuperar tus datos del archivo datos.dat.
     */
    public CalorieController() {
        historial.cargarDatos();
    }

    /**
     * Ruta principal (Dashboard). 
     * Envía los totales acumulados al HTML para que se vean en tu iPhone.
     */
    @GetMapping("/dashboard")
    public String home(Model model) {
        model.addAttribute("calT", cT);
        model.addAttribute("proT", pT);
        model.addAttribute("carbT", chT);
        model.addAttribute("grasT", gT);
        return "dashboard";
    }

    /**
     * Ruta para agregar comida.
     * Recibe los datos del formulario, los mete a la lista y actualiza totales.
     * La ListaEnlazada guarda automáticamente en disco gracias al método guardarDatos().
     */
    @PostMapping("/add")
    public String add(@RequestParam String n, 
                      @RequestParam double c, 
                      @RequestParam double p, 
                      @RequestParam double ch, 
                      @RequestParam double g) {
        
        listaHoy.insertarFinal(new Comidas(n, c, p, ch, g));
        
        // Sumar a los totales del día
        cT += c; 
        pT += p; 
        chT += ch; 
        gT += g;
        
        return "redirect:/dashboard";
    }

    /**
     * Ruta para cerrar el día.
     * Crea un objeto Dias, lo mete al historial y reinicia el contador de hoy.
     */
    @PostMapping("/cambiar-dia")
    public String cambiarDia(@RequestParam String fecha) {
        Dias nuevoDia = new Dias(fecha, listaHoy, cT, pT, chT, gT);
        historial.insertarFinal(nuevoDia);
        
        // Limpiar para el día siguiente
        listaHoy = new ListaEnlazada<>();
        cT = pT = chT = gT = 0;
        
        return "redirect:/dashboard";
    }
}
