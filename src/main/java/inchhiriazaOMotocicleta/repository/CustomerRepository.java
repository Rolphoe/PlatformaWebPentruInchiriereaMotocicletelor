package inchhiriazaOMotocicleta.repository;

import inchhiriazaOMotocicleta.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(@Param("firstName") String firstName);
}
