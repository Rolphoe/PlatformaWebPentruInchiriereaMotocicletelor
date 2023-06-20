package inchhiriazaOMotocicleta.controller.web;

import inchhiriazaOMotocicleta.model.IdRequest;
import inchhiriazaOMotocicleta.model.employee.CreateEmployeeRequest;
import inchhiriazaOMotocicleta.model.employee.EmployeeRequest;
import inchhiriazaOMotocicleta.model.employee.UpdateEmployeeRequest;
import inchhiriazaOMotocicleta.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class EmployeeWebController {
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public String goToEmployeePage() {
        return "employeePage";
    }

    @GetMapping("employee/allEmployees")
    public String goToAllEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.allEmployees());
        return "allEmployeesPage";
    }

    @PostMapping("employee/delete")
    public String deleteEmployee(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        employeeService.deleteEmployee(request.getId());
        model.addAttribute("employees", employeeService.allEmployees());
        return "allEmployeesPage";
    }

    @GetMapping("employee/goToUpdateEmployeePage")
    public String goToUpdateEmployeePage(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model){
        model.addAttribute("employeeId", request.getId());
        return "updateEmployeesPage";
    }

    @PostMapping("employee/update-employee")
    public String updateEmployee(@ModelAttribute(value = "updateEmployeeRequest") UpdateEmployeeRequest request,
                                   Model model) {
        EmployeeRequest employeeRequest = EmployeeRequest.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .position(request.getPosition())
                .branch(request.getBranch())
                .build();
        employeeService.updateEmployee(employeeRequest);

        model.addAttribute("employees", employeeService.allEmployees());
        return "allEmployeesPage";
    }

    @GetMapping("employee/goToCreateEmployeePage")
    public String goToCreateEmployeePage() {
        return "employeeCreatePage";
    }



    @PostMapping("/employee/createNewEmployee")
    public String createEmployee(@ModelAttribute(value = "createEmployeeRequest")
                                     CreateEmployeeRequest request,
                                   Model model) {
        EmployeeRequest employeeRequest = EmployeeRequest.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .position(request.getPosition())
                .branch(request.getBranch())
                .build();
        employeeService.createEmployee(employeeRequest);

        model.addAttribute("employees", employeeService.allEmployees());
        return "allEmployeesPage";
    }
}

