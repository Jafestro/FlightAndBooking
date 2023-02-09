package az.iktlab.flights_and_bookings.repository;

import az.iktlab.flights_and_bookings.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<FlightEntity,Long> {
}
