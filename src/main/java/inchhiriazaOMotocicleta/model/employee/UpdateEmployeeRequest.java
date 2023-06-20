package inchhiriazaOMotocicleta.model.employee;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private String branch;
}