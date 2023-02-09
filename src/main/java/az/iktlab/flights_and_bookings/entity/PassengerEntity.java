package az.iktlab.flights_and_bookings.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(targetEntity = BookingEntity.class)
    @JoinTable(name = "passenger_bookings",
    joinColumns = @JoinColumn(name = "passenger_id"),
    inverseJoinColumns = @JoinColumn(name = "booking_id"))
    private List<BookingEntity> bookings;
    @Column(unique = true,nullable = false, name = "passport_number")
    private String passportNumber;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
