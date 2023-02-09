package az.iktlab.flights_and_bookings.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @DeleteMapping("/id/{id}")
    public void deleteBookingById(@PathVariable("id") long id){

    }


    @PostMapping("/passportNumber")
    public void bookFlight(@RequestParam("id") long id,
                           @RequestParam("passportNumber") String passportNumber,
                           @RequestParam("name") String name,
                           @RequestParam("surname") String surname){

    }
}
