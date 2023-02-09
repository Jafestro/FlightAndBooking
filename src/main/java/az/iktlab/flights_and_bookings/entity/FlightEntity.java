package az.iktlab.flights_and_bookings.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "flights")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;
    private LocalDate date;
    private LocalTime time;
    private String departure;
    private String arrival;
    private int availableSeats;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
