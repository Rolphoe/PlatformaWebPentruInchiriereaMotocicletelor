package inchhiriazaOMotocicleta.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateStatusVehicle {

    private Integer id;

    @NotBlank(message = "Status cannot be empty!")
    private String status;
}
