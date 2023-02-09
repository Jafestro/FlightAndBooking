package az.iktlab.flights_and_bookings.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDto {
    private long bookingId;
    private Long flightId;
}
