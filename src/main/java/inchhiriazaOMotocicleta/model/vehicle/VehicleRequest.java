package inchhiriazaOMotocicleta.model.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {

    private Integer id;

    private String imagePath;

    @NotBlank(message = "model cannot be empty!")
    private String vehicleModel;
    @NotBlank(message = "color cannot be empty!")
    private String colour;
    @NotNull(message = "year cannot be empty!")
    private int year;
    @NotNull(message = "mileage cannot be empty!")
    private int mileage;
    @NotBlank(message = "status cannot be empty!")
    private String status;
    @NotNull(message = "price cannot be empty!")
    private int price;
}