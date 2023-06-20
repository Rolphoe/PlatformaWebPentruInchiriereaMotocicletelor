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
public class RequestUpdateLastNameCustomer {

    private Integer id;

    @NotBlank(message = "Last name cannot be empty!")
    private String lastName;
}
