package inchhiriazaOMotocicleta.controller;

import inchhiriazaOMotocicleta.entity.User;
import inchhiriazaOMotocicleta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            bindingResult.rejectValue("username", "error.user", "Utilizatorul este deja luat");
            return "register";
        }
        user.setRole("ROLE_USER");

        userService.createUser(user.getUsername(), user.getPassword(), user.getRole(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress());
        return "redirect:/login";
    }
}
