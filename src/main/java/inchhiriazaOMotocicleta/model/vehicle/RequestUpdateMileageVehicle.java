package inchhiriazaOMotocicleta.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateMileageVehicle {

    private Integer id;
    @NotNull(message = "Mileage cannot be empty!")
    private int mileage;
}
