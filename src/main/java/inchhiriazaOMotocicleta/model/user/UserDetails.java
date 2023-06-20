package inchhiriazaOMotocicleta.model.user;

import lombok.Data;

@Data
public class UserDetails {

    private Integer id;
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
