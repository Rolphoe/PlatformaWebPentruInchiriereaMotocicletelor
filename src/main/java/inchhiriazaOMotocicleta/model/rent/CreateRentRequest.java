package inchhiriazaOMotocicleta.model.rent;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import java.time.LocalDateTime;

@Data
public class CreateRentRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message = "Invalid Date")
    private LocalDateTime rentStartDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message = "Invalid Date")
    private LocalDateTime rentEndDateTime;

    private Integer userId;
    private Integer vehicleId;
    private Integer branchTakeId;
    private Integer branchLeaveId;
    private float amount;
}