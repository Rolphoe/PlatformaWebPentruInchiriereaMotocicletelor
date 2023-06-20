package inchhiriazaOMotocicleta.mapper;

import inchhiriazaOMotocicleta.entity.Customer;
import inchhiriazaOMotocicleta.model.customer.CustomerDetails;
import inchhiriazaOMotocicleta.model.customer.CustomerRequest;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer map(CustomerRequest customerRequest);

    CustomerDetails map(Customer customer);

    List<CustomerDetails> map(List<Customer> allUsers);
}
