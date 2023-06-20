package inchhiriazaOMotocicleta.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import inchhiriazaOMotocicleta.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyRepository {
    private final EntityManager entityManager;

    public List<Customer> findByFirstName(String firstName){
        return entityManager.createQuery( "select t from Customer t where t.firstName=:name", Customer.class).setParameter("name", firstName).getResultList();
    }
}
