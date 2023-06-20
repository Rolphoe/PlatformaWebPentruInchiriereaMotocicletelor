package inchhiriazaOMotocicleta.model.branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchRequest {

    private Integer id;

    @NotBlank(message = "Name cannot be empty!")
    private String name;

    @NotBlank(message = "Address cannot be empty!")
    private String address;
}
