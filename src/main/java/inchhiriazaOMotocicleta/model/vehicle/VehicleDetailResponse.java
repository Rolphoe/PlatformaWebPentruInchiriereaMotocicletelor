package inchhiriazaOMotocicleta.model.vehicle;

import lombok.Data;

@Data
public class VehicleDetailResponse {

    private String vehicleModel;
    private int year;
    private String colour;
    private int mileage;
    private String status;
    private int price;

}
