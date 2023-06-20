package inchhiriazaOMotocicleta.controller;

import inchhiriazaOMotocicleta.model.customer.CustomerDetailResponse;
import inchhiriazaOMotocicleta.model.customer.CustomerDetails;
import inchhiriazaOMotocicleta.model.customer.CustomerRequest;
import inchhiriazaOMotocicleta.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("create")
    public CustomerDetails createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping("list")
    public List<CustomerDetails> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("find/{id}")
    public CustomerDetails findCustomerById(@PathVariable Integer id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("find/name/{firstName}")
    public List<CustomerDetailResponse> findByName(@PathVariable String firstName) {
        return customerService.findByFirstName(firstName);
    }

    @PatchMapping("update/{id}")
    public void updateCustomerById(@RequestBody @Valid CustomerRequest customerRequest) {
        customerService.updateCustomer(customerRequest);
    }

    @DeleteMapping("{id}")
    public void deleteCustomerById(@PathVariable Integer id){
        customerService.deleteById(id);
    }
}
