package az.iktlab.flights_and_bookings.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerDto {
    private String name;
    private String surname;
    private Long bookingId;
    private String passportNumber;
}
