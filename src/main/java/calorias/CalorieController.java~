package calorias;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalorieController {
    private ListaEnlazada<Comidas> lista = new ListaEnlazada<>();

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalCalorias", lista.getTotalCalorias());
        model.addAttribute("totalProteinas", lista.getTotalProteinas());
        model.addAttribute("totalCarbohidratos", lista.getTotalCarbohidratos());
        model.addAttribute("totalGrasas", lista.getTotalGrasas());
        return "dashboard";
    }

    @PostMapping("/agregar")
    public String agregarComida(@RequestParam String nombre, @RequestParam double cal, 
                                @RequestParam double prot, @RequestParam double carb, 
                                @RequestParam double gras) {
        Comidas nuevaComida = new Comidas(nombre, cal, prot, carb, gras);
        lista.insertar(nuevaComida);
        return "redirect:/dashboard";
    }

    @PostMapping("/cambiarDia")
    public String cambiarDia() {
        lista.reiniciar();
        return "redirect:/dashboard";
    }
}
