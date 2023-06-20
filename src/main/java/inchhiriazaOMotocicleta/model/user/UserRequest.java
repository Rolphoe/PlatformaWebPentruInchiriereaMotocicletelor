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
public class UserRequest {

    private Integer id;

    @NotBlank(message = "Prenumele nu poate fi gol!")
    private String username;

    @NotBlank(message = "Numele nu poate fi gol!")
    private String password;

    @NotBlank(message = "Rolul nu poate fi gol!")
    private String role;

    @NotBlank(message = "Prenumele nu poate fi gol!")
    private String firstName;

    @NotBlank(message = "Numele nu poate fi gol!")
    private String lastName;

    @NotBlank(message = "Email-ul nu poate fi gol!")
    private String email;

    @NotBlank(message = "Adresa nu poate fi goală!")
    private String address;
}