package az.iktlab.flights_and_bookings.service;

import az.iktlab.flights_and_bookings.entity.BookingEntity;
import az.iktlab.flights_and_bookings.entity.PassengerEntity;
import az.iktlab.flights_and_bookings.model.BookingDto;
import az.iktlab.flights_and_bookings.repository.BookingRepo;
import az.iktlab.flights_and_bookings.repository.FlightRepo;
import az.iktlab.flights_and_bookings.repository.PassengerRepo;
import org.springframework.stereotype.Service;


@Service
public class BookingService {
    private final BookingRepo bookingRepo;
    private final FlightRepo flightRepo;

    public BookingService(BookingRepo bookingRepo, FlightRepo flightRepo) {
        this.bookingRepo = bookingRepo;
        this.flightRepo = flightRepo;
    }

    public void deleteBookingById(Long bookingId) {
        bookingRepo.deleteByBookingId(bookingId);
    }


    public BookingDto bookFlight(Long flightId) {
        BookingEntity bookingEntity = BookingEntity.builder().flight(flightRepo.getById(flightId)).build();
        bookingRepo.save(bookingEntity);
        return BookingDto.builder().flightId(bookingEntity.getFlight().getFlightId()).bookingId(bookingEntity.getBookingId()).build();
    }
}
