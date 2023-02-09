package az.iktlab.flights_and_bookings.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @Column(name = "flight_id")
    private Long flightId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "departure")
    private String departure;
    @Column(name = "arrival")
    private String arrival;
    @Column(name = "available_seats")
    private int availableSeats;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
