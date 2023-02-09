package az.iktlab.flights_and_bookings.repository;

import az.iktlab.flights_and_bookings.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepo extends JpaRepository<PassengerEntity,Long> {
    Optional<PassengerEntity> findByPassportNumber(String passportNumber);
}
