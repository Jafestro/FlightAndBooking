package az.iktlab.flights_and_bookings.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    private long flightId;
    private LocalDate date;
    private LocalTime time;
    private String departure;
    private String arrival;
    private int availableSeats;
}
