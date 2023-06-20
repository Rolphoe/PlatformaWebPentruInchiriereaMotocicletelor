package inchhiriazaOMotocicleta.model.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private Integer id;

    @NotBlank(message = "Invalid first name!")
    private String firstName;

    @NotBlank(message = "Invalid last name!")
    private String lastName;

    @NotBlank(message = "Invalid position!")
    private String position;

    @NotBlank
    private String branch;
}
