package inchhiriazaOMotocicleta.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutWebController {
    @GetMapping("/despre")
    public String desprePage() {
        return "despre";
    }
}
