package az.iktlab.flights_and_bookings.controller;

import az.iktlab.flights_and_bookings.model.BookingDto;
import az.iktlab.flights_and_bookings.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @DeleteMapping("/id/{id}")
    public void deleteBookingById(@PathVariable("id") Long id){
        bookingService.deleteBookingById(id);
    }


    @PostMapping("/id")
    public BookingDto bookFlight(@RequestParam("id") Long flight_Id){
            return bookingService.bookFlight(flight_Id);
    }
}
