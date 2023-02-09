package az.iktlab.flights_and_bookings.service;

import az.iktlab.flights_and_bookings.entity.FlightEntity;
import az.iktlab.flights_and_bookings.model.FlightDto;
import az.iktlab.flights_and_bookings.repository.FlightRepo;
import az.iktlab.flights_and_bookings.repository.PassengerRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

//    @PostConstruct
//    public void testFlights(){
//        List<FlightEntity> flights = new ArrayList<>();
//        flights.add(FlightEntity.builder().arrival("Berlin")
//                .availableSeats(17)
//                .date(LocalDate.of(2023,2,9))
//                .time(LocalTime.of(17,55))
//                .departure("Baku").build());
//        flightRepo.save(flights.get(0));
//    }

    private final FlightRepo flightRepo;
    private final PassengerRepo passengerRepo;

    public FlightService(FlightRepo flightRepo, PassengerRepo passengerRepo) {
        this.flightRepo = flightRepo;
        this.passengerRepo = passengerRepo;
    }


    public List<FlightDto> getAllFlights(){
        return flightRepo.findAll()
                .stream()
                .map(this::buildFlightDto)
                .collect(Collectors.toList());
    }

    public List<FlightDto> getFlightsByArrival(String arrival){
        return flightRepo.findAll()
                .stream()
                .map(this::buildFlightDto)
                .filter((it)-> it.getArrival().equals(arrival))
                .collect(Collectors.toList());
    }

    public List<FlightDto> showSpecialFlights(LocalDate date,String from, String to, int passCount){

        return flightRepo.findAll()
                .stream()
                .map(this::buildFlightDto)
                .filter(it -> it.getArrival().equals(to)
                        && it.getDate().equals(date)
                        && it.getAvailableSeats() >= passCount
                        && it.getDeparture().equals(from))
                .collect(Collectors.toList());
    }

    public List<FlightDto> showMyFlights(@PathVariable("passportNumber") String passportNumber){
       var entity = passengerRepo.findByPassportNumber(passportNumber)
                .orElseThrow(()->new RuntimeException("PASSENGER DOES NOT EXIST."))
                .getBookings().stream()
                .map(it-> flightRepo.findById(it.getFlight().getFlightId()))
                .collect(Collectors.toList());
       List<FlightEntity> flightEntities = (ArrayList) entity;

        return flightEntities.stream().map(this::buildFlightDto).collect(Collectors.toList());
    }

    private FlightDto buildFlightDto(FlightEntity entity){
        return FlightDto.builder().
        flightId(entity.getFlightId()).
        date(entity.getDate()).
                time(entity.getTime()).
        departure(entity.getDeparture()).
        arrival(entity.getArrival()).
                availableSeats(entity.getAvailableSeats()).build();
    }
}
