package inchhiriazaOMotocicleta.repository;

import inchhiriazaOMotocicleta.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
