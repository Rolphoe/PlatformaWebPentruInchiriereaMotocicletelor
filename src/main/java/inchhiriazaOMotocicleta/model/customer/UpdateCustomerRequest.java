package inchhiriazaOMotocicleta.model.customer;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}