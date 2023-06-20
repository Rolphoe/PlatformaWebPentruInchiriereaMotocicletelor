package inchhiriazaOMotocicleta.model.vehicle;

import lombok.Data;

@Data
public class VehicleDetails {

    private Integer id;
    private String imagePath;
    private String vehicleModel;
    private String colour;
    private int year;
    private int mileage;
    private String status;
    private int price;
}
