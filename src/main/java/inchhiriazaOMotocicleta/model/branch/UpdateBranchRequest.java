package inchhiriazaOMotocicleta.model.branch;

import lombok.Data;

@Data
public class UpdateBranchRequest {
    private Integer id;
    private String name;
    private String address;
}
