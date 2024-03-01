package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.Routes;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerResponseDTO;
import com.arqtechnologies.strata.Entities.Passenger;
import com.arqtechnologies.strata.Repositories.PassengerRepository;
import com.arqtechnologies.strata.Services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.arqtechnologies.strata.Enums.EnumRole.PASSENGER;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public String createPassenger(PassengerRequestDTO passengerRequestDTO) {

        Passenger newPassenger = new Passenger();

        newPassenger.setFirstName(passengerRequestDTO.getFirstName());
        newPassenger.setLastName(passengerRequestDTO.getLastName());
        newPassenger.setEmail(passengerRequestDTO.getEmail());
        newPassenger.setPassword(passengerRequestDTO.getPassword());
        newPassenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        newPassenger.setPhoneNumber2(passengerRequestDTO.getPhoneNumber2());
        newPassenger.setCreatedDate(new Date());
//        newPassenger.setCreatedBy();//TODO AUTHENTICATION
        newPassenger.setUserRole(PASSENGER);

        passengerRepository.save(newPassenger);

        return "Successfully Created";
    }

    @Override
    public PassengerResponseDTO updatePassenger(PassengerRequestDTO passengerRequestDTO) {

        Passenger passenger = passengerRepository.findById(passengerRequestDTO.getPassengerId())
                .orElseThrow(()-> new RuntimeException("Couldn't find passenger with ID " +
                        passengerRequestDTO.getPassengerId()));

        passenger.setFirstName(passengerRequestDTO.getFirstName());
        passenger.setLastName(passengerRequestDTO.getLastName());
        passenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        passenger.setPhoneNumber2(passengerRequestDTO.getPhoneNumber2());

        passengerRepository.save(passenger);

        return null;
    }

    @Override
    public DriverResponseDTO getDriversInPath(Integer passengerId, RideRequestDTO rideRequestDTO) {
        //TODO LET IT NOT JUST CONTAIN EVERYONE HEADING THERE, OTHERWISE EVEN PEOPLE NOT IN PATH WILL BE IDENTIFIED,
        // SO ALSO FILTER BY PATH AND DESTINATION

        //TODO USE GOOGLE API TO FIND THE PATHS AND GET THE DRIVERS ACTUALLY HEADING IN THE SAME PATH.
        return null;
    }

//    public Routes getDestinationRoutes(String Destination){
//
//    }
}
