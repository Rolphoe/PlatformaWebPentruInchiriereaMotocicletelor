package inchhiriazaOMotocicleta.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeWebController {

    @GetMapping("/welcome")
    public String gotoWelcomePage() {
        return "welcomePage";
    }
}
