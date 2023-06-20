package inchhiriazaOMotocicleta.controller;

import inchhiriazaOMotocicleta.model.customer.CustomerDetails;
import inchhiriazaOMotocicleta.model.customer.CustomerRequest;
import inchhiriazaOMotocicleta.model.user.UserDetails;
import inchhiriazaOMotocicleta.model.user.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import inchhiriazaOMotocicleta.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}