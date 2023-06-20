package inchhiriazaOMotocicleta.model.rent;

import inchhiriazaOMotocicleta.entity.Branch;
import inchhiriazaOMotocicleta.entity.User;
import lombok.Data;
import inchhiriazaOMotocicleta.entity.Customer;
import inchhiriazaOMotocicleta.entity.Vehicle;

import java.time.LocalDateTime;

@Data
public class RentDetails {

    private Integer id;
    private LocalDateTime rentStartDateTime;
    private LocalDateTime rentEndDateTime;
    private User user;
    private Vehicle vehicle;
    private Branch branchTake;
    private Branch branchLeave;
    private float amount;
}
