package az.iktlab.flights_and_bookings.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class FlightDto {
    private long flightId;
    private LocalDate date;
    private LocalTime time;
    private String departure;
    private String arrival;
    private int availableSeats;
}
