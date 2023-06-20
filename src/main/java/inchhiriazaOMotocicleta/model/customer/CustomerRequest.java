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
public class CustomerRequest {

    private Integer id;

    @NotBlank(message = "First name cannot be empty!")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty!")
    private String lastName;

    @NotBlank(message = "Email cannot be empty!")
    private String email;

    @NotBlank(message = "Address cannot be empty!")
    private String address;
}
