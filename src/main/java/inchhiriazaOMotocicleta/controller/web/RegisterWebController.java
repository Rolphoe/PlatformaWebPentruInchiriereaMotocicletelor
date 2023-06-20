package inchhiriazaOMotocicleta.controller.web;

import inchhiriazaOMotocicleta.entity.User;
import inchhiriazaOMotocicleta.model.IdRequest;
import inchhiriazaOMotocicleta.model.customer.*;
import inchhiriazaOMotocicleta.repository.UserRepository;
import inchhiriazaOMotocicleta.service.CustomerService;
import inchhiriazaOMotocicleta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class RegisterWebController {

    private final UserService userService;

    @Controller
    @RequestMapping("/admin/user")
    public class UserWebController {

        @GetMapping("/goToCreateUserPage")
        public String goToCreateUserPage(Model model) {
            model.addAttribute("user", new User());
            return "createUser";
        }

        @PostMapping("/createUser")
        public String createUser(User user) {
            userService.save(user);
            return "redirect:/admin/allCustomers";
        }
    }
    @PostMapping("/admin/user/create")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/admin/allCustomers";
    }

}
