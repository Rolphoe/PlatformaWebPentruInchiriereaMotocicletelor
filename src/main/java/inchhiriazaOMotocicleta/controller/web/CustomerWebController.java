package inchhiriazaOMotocicleta.controller.web;

import inchhiriazaOMotocicleta.entity.User;
import inchhiriazaOMotocicleta.model.IdRequest;
import inchhiriazaOMotocicleta.model.customer.*;
import inchhiriazaOMotocicleta.model.user.*;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdateColorVehicle;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdateMileageVehicle;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdatePriceVehicle;
import inchhiriazaOMotocicleta.model.vehicle.RequestUpdateStatusVehicle;
import inchhiriazaOMotocicleta.service.CustomerService;
import inchhiriazaOMotocicleta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class CustomerWebController {

    private final UserService userService;

    @GetMapping("/customer")
    public String goToCustomerPage(){
        return "customerPage";
    }

    @GetMapping("/allCustomers")
    public String getAllUsers(Model model) {
        List<UserDetails> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "allCustomersPage";
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestParam("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "userEdit";
    }
    @PostMapping("/save")
    public String saveUser(User user) {
        System.out.println("Entered saveUser method.");
        userService.save(user);
        return "/admin/allCustomersPage";
    }

    @PostMapping("user/update-username")
    public String updateUsername(@ModelAttribute(value = "updateUsername") RequestUpdateUsernameUser request,
                               Model model) {
        userService.updateUsername(request.getId(), request);
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

    @PostMapping("user/update-firstName")
    public String updateFirstName(@ModelAttribute(value = "updateFirstName") RequestUpdateFirstNameUser request,
                                Model model) {
        userService.updateFirstName(request.getId(), request);
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

    @PostMapping("user/update-role")
    public String updateRole(@ModelAttribute(value = "updateRole") RequestUpdateRoleUser request,
                                  Model model) {
        userService.updateRole(request.getId(), request);
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

    @PostMapping("user/update-lastName")
    public String updateLastName(@ModelAttribute(value = "updateLastName") RequestUpdateLastNameUser request,
                               Model model) {
        userService.updateLastName(request.getId(), request);
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

    @PostMapping("user/update-email")
    public String updateEmail(@ModelAttribute(value = "updateEmail") RequestUpdateEmailUser request,
                              Model model) {
        userService.updateEmail(request.getId(), request);
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

    @PostMapping("user/update-address")
    public String updateAddress(@ModelAttribute(value = "updateAddress") RequestUpdateAddressUser request,
                              Model model) {
        userService.updateAddress(request.getId(), request);
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

    @PostMapping("user/deleteById")
    public String deleteById(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        userService.deleteById(request.getId());
        model.addAttribute("users", userService.getAllUsers());
        return "/allCustomersPage";
    }

}
