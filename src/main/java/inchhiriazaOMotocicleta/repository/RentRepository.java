package inchhiriazaOMotocicleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import inchhiriazaOMotocicleta.entity.Rent;

import java.time.LocalDateTime;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Integer> {

    List<Rent> findAllByOrderByRentStartDateTimeDesc();


    @Query("select t from Rent t where t.rentStartDateTime BETWEEN :startDate AND :endDate")
    List<Rent> findByRentDateBetween(
            @Param("startDate") LocalDateTime dateFrom,
            @Param("endDate") LocalDateTime dateTo);
}
