package inchhiriazaOMotocicleta.controller.web;

import inchhiriazaOMotocicleta.entity.User;
import inchhiriazaOMotocicleta.entity.Vehicle;
import inchhiriazaOMotocicleta.mapper.RentMapper;
import inchhiriazaOMotocicleta.model.IdRequest;
import inchhiriazaOMotocicleta.model.rent.CreateRentRequest;
import inchhiriazaOMotocicleta.model.rent.RentRequest;
import inchhiriazaOMotocicleta.repository.UserRepository;
import inchhiriazaOMotocicleta.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class RentWebController {

    private final RentService rentService;
    private final EmployeeService employeeService;
    private final UserService userService;
    private final VehicleService vehicleService;
    private final BranchService branchService;
    private final UserRepository userRepository;
    private final RentMapper rentMapper;

    @GetMapping("/rent")
    public String goToRentsPage() {
        return "rentPage";
    }

    @GetMapping("/rent/allRents")
    public String allRents(Model model) {
        model.addAttribute("rents", rentService.findAll());
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allvehicles", vehicleService.getAllVehicles());
        model.addAttribute("allBranches", branchService.getAllBranches());
        return "allRentsPage";
    }

    @GetMapping("/rent/goToCreateRentPage")
    public String goToCreateRentPage(Model model) {
        model.addAttribute("employees", employeeService.allEmployees());
        model.addAttribute("customers", userService.getAllUsers());
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        model.addAttribute("allBranches", branchService.getAllBranches());
        return "rentCreatePage";
    }

    @PostMapping("/rent/create-new-rent")
    public String createNewRent(@ModelAttribute(value = "createRentRequest") CreateRentRequest request,
                                       Model model) {
        RentRequest rentRequest = RentRequest.builder()
                .rentStartDateTime(request.getRentStartDateTime())
                .rentEndDateTime(request.getRentEndDateTime())
                .userId(request.getUserId())
                .vehicleId(request.getVehicleId())
                .branchTakeId(request.getBranchTakeId())
                .branchLeaveId(request.getBranchLeaveId())
                .build();
        rentService.createRent(rentRequest);

        model.addAttribute("rents", rentService.findAll());
        return "allRentsPage";
    }

    @PostMapping("/rent/create-new-rent/{vehicleId}")
    public String createNewRent(@PathVariable int vehicleId,
                                @ModelAttribute(value = "createRentRequest") CreateRentRequest request,
                                Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        int userId = user.getId();

        RentRequest rentRequest = RentRequest.builder()
                .rentStartDateTime(request.getRentStartDateTime())
                .rentEndDateTime(request.getRentEndDateTime())
                .userId(userId)
                .vehicleId(vehicleId)
                .branchTakeId(request.getBranchTakeId())
                .branchLeaveId(request.getBranchLeaveId())
                .build();

        rentService.createRent(rentRequest);

        model.addAttribute("rents", rentService.findAll());
        return "allRentsPage";
    }

    @GetMapping("/rent/delete")
    public String delete(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        rentService.delete(request.getId());
        model.addAttribute("rents", rentService.findAll());
        return "allRentsPage";
    }
}

