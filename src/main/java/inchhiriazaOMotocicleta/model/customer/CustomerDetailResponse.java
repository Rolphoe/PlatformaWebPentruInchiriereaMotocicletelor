package inchhiriazaOMotocicleta.model.customer;

import inchhiriazaOMotocicleta.model.rent.RentResponseForCustomerDetail;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDetailResponse {

    private String firstName;
    private String lastName;

    private List<RentResponseForCustomerDetail> rents;

}
