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
public class RequestUpdateEmailUser {

    private Integer id;

    @NotBlank(message = "Email cannot be empty!")
    private String email;
}
