package inchhiriazaOMotocicleta.model.rent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentRequest {

    private Integer id;
    @DateTimeFormat(iso  = DateTimeFormat.ISO.DATE)
    @Future(message = "Invalid date")
    private LocalDateTime rentStartDateTime;
    @DateTimeFormat(iso  = DateTimeFormat.ISO.DATE)
    @Future(message = "Invalid date")
    private LocalDateTime rentEndDateTime;
    private Integer userId;
    private Integer vehicleId;
    private Integer branchTakeId;
    private Integer branchLeaveId;
    private float amount;
}
