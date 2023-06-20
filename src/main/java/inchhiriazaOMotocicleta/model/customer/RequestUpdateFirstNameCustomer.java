package inchhiriazaOMotocicleta.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateFirstNameCustomer {

    private Integer id;

    @NotBlank(message = "First name cannot be empty!")
    private String firstName;
}
