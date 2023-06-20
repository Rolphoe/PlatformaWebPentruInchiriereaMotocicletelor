package inchhiriazaOMotocicleta.model.employee;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String position;
    private String branch;

}