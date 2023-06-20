package inchhiriazaOMotocicleta.mapper;

import inchhiriazaOMotocicleta.entity.Customer;
import inchhiriazaOMotocicleta.entity.User;
import inchhiriazaOMotocicleta.model.customer.CustomerDetails;
import inchhiriazaOMotocicleta.model.customer.CustomerRequest;
import inchhiriazaOMotocicleta.model.user.UserDetails;
import inchhiriazaOMotocicleta.model.user.UserRequest;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserRequest userRequest);

    UserDetails map(User user);

    List<UserDetails> map(List<User> allUsers);
}
