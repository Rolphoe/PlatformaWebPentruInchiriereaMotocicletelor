package inchhiriazaOMotocicleta.mapper;


import inchhiriazaOMotocicleta.model.rent.CreateRentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.ComponentScan;
import inchhiriazaOMotocicleta.entity.Rent;
import inchhiriazaOMotocicleta.model.rent.RentRequest;
import inchhiriazaOMotocicleta.model.rent.RentResponse;

import java.util.List;
@ComponentScan
@Mapper(componentModel = "spring")
public interface RentMapper {

    Rent map(RentRequest rentRequest);

    @Mapping(target = "rentStartDateTime", dateFormat = "yyyy-MM-dd   HH:ss")
    @Mapping(source = "branchTake.id", target = "branchTake.id")
    @Mapping(source = "branchTake.name", target = "branchTake.name")
    @Mapping(source = "branchTake.address", target = "branchTake.address")
    @Mapping(source = "branchLeave.id", target = "branchLeave.id")
    @Mapping(source = "branchLeave.name", target = "branchLeave.name")
    @Mapping(source = "branchLeave.address", target = "branchLeave.address")
    RentResponse map(Rent rent);

    List<RentResponse> map(List<Rent> all);

    RentRequest map(CreateRentRequest createRentRequest);
}
