package inchhiriazaOMotocicleta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateBetweenRequestRevenue {


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "Please check the date")
    private LocalDate dateFrom;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "Please check the date")
    private LocalDate dateTo;


}