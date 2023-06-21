package inchhiriazaOMotocicleta.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateRoleUser {

    private Integer id;

    @NotBlank(message = "Role cannot be empty!")
    private String role;
}
