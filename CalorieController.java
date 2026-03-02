package calorias;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalorieController {
    private ListaEnlazada<Dias> historial = new ListaEnlazada<>();
    private ListaEnlazada<Comidas> listaHoy = new ListaEnlazada<>();
    private double cT = 0, pT = 0, chT = 0, gT = 0;

    @GetMapping("/dashboard")
    public String home(Model model) {
        model.addAttribute("calT", cT);
        model.addAttribute("proT", pT);
        model.addAttribute("carbT", chT);
        model.addAttribute("grasT", gT);
        return "dashboard";
    }

    @PostMapping("/add")
    public String add(@RequestParam String n, @RequestParam double c, @RequestParam double p, @RequestParam double ch, @RequestParam double g) {
        listaHoy.insertarFinal(new Comidas(n, c, p, ch, g));
        cT += c; pT += p; chT += ch; gT += g;
        return "redirect:/dashboard";
    }
}
