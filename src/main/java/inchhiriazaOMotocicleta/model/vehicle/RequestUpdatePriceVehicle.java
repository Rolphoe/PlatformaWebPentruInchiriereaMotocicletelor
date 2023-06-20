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
public class RequestUpdatePriceVehicle {

    private Integer id;

    @NotNull(message = "Price cannot be empty!")
    private int price;
}