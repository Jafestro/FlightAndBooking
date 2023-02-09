package az.iktlab.flights_and_bookings.controller;

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


    @PostMapping("/passportNumber")
    public void bookFlight(@RequestParam("id") Long id,
                           @RequestParam("passportNumber") String passportNumber,
                           @RequestParam("name") String name,
                           @RequestParam("surname") String surname){
            bookingService.bookFlight(id,passportNumber,name,surname);
    }
}
