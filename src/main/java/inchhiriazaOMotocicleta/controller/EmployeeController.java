package inchhiriazaOMotocicleta.controller;

import inchhiriazaOMotocicleta.model.employee.EmployeeRequest;
import inchhiriazaOMotocicleta.model.employee.EmployeeResponse;
import inchhiriazaOMotocicleta.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public EmployeeResponse createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

    @GetMapping("/list")
    public List<EmployeeResponse> showAllEmployees() {
        return employeeService.allEmployees();
    }

    @GetMapping("/find/{id}")
    public EmployeeResponse findEmployeeById(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    @PatchMapping("/update")
    public void updateEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        employeeService.updateEmployee(employeeRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


}
