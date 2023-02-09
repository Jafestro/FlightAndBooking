package az.iktlab.flights_and_bookings.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    private long passengerId;
    private String name;
    private String surname;
    private Booking booking;
    private String passportNumber;

}
