package az.iktlab.flights_and_bookings.controller;

import az.iktlab.flights_and_bookings.model.Flight;
import az.iktlab.flights_and_bookings.model.FlightDto;
import az.iktlab.flights_and_bookings.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<FlightDto> getAllFlights(){
        return flightService.getAllFlights();
    }
    @GetMapping("/arrival/{arrival}")
    public List<FlightDto> getFlightsByArrival(@PathVariable("arrival") String to){
        return flightService.getFlightsByArrival(to);
    }

    //TODO: Change RequestParam with DTOS (Flight Dto for example)
    @GetMapping("/sf")
    public List<FlightDto> showSpecialFlights(@RequestParam("date")
                                                   @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate date,
                                           @RequestParam("from") String from,
                                              @RequestParam("to") String to,
                                           @RequestParam("passCount") int passCount){

        return flightService.showSpecialFlights(date,from,to,passCount);
    }
    @GetMapping("/passportNumber/{passportNumber}")
    public List<FlightDto> showMyFlights(@PathVariable("passportNumber") String passportNumber){
        return flightService.showMyFlights(passportNumber);
    }

}
