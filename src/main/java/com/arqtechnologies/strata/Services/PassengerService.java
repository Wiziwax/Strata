package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerResponseDTO;

import java.util.List;

public interface PassengerService {

    String createPassenger(PassengerRequestDTO passengerRequestDTO);

    //TODO LOGIN
    PassengerResponseDTO updatePassenger(PassengerRequestDTO passengerRequestDTO);
    //PassengerResponseDTO passwordReset
    //TODO PASSWORD RESET

    List<DriverResponseDTO> getDriversInPath(Integer passengerId, RideRequestDTO rideRequestDTO);
}
