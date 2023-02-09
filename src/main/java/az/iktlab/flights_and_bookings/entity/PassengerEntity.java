package az.iktlab.flights_and_bookings.entity;

import az.iktlab.flights_and_bookings.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passengers")
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private Long bookingId;
    @Column(unique = true,nullable = false)
    private String passportNumber;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
