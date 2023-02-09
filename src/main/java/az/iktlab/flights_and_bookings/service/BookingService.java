package az.iktlab.flights_and_bookings.service;

import az.iktlab.flights_and_bookings.model.BookingDto;
import az.iktlab.flights_and_bookings.repository.BookingRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class BookingService {
    private final BookingRepo bookingRepo;

    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public void deleteBookingById(Long bookingId){
        bookingRepo.deleteByBookingId(bookingId);
    }



    public void bookFlight(Long id,String passportNumber,String name,String surname){

    }
}
