package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.PassengerResponseDTO;
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
}
