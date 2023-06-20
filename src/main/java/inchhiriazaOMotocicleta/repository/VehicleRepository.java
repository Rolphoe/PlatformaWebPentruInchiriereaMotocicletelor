package inchhiriazaOMotocicleta.repository;

import inchhiriazaOMotocicleta.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByVehicleModel(@Param("model") String model);
}
