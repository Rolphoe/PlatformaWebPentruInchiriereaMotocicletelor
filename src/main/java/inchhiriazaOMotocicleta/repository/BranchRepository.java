package inchhiriazaOMotocicleta.repository;

import inchhiriazaOMotocicleta.entity.Branch;
import inchhiriazaOMotocicleta.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
