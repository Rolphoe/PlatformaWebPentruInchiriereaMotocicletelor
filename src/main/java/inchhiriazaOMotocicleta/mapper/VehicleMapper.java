package inchhiriazaOMotocicleta.mapper;

import inchhiriazaOMotocicleta.entity.Vehicle;
import inchhiriazaOMotocicleta.model.vehicle.VehicleDetails;
import inchhiriazaOMotocicleta.model.vehicle.VehicleRequest;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
@ComponentScan
@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle map(VehicleRequest vehicleRequest);

    VehicleDetails map(Vehicle vehicle);

    List<VehicleDetails> map(List<Vehicle> allVehicles);
}
