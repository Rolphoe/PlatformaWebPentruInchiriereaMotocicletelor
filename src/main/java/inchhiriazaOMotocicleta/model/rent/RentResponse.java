package inchhiriazaOMotocicleta.model.rent;

import inchhiriazaOMotocicleta.model.branch.BranchRentResponse;
import inchhiriazaOMotocicleta.model.user.UserRentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import inchhiriazaOMotocicleta.model.customer.CustomerRentResponse;
import inchhiriazaOMotocicleta.model.vehicle.VehicleRentResponse;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentResponse {
    private Integer id;
    private LocalDateTime rentStartDateTime;
    private LocalDateTime rentEndDateTime;
    private UserRentResponse user;
    private VehicleRentResponse vehicle;
    private BranchRentResponse branchTake;
    private BranchRentResponse branchLeave;
}
