package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerResponseDTO;

public interface PassengerService {

    String createPassenger(PassengerRequestDTO passengerRequestDTO);

    //TODO LOGIN
    PassengerResponseDTO updatePassenger(PassengerRequestDTO passengerRequestDTO);
    //PassengerResponseDTO passwordReset
    //TODO PASSWORD RESET

    DriverResponseDTO getDriversInPath(Integer passengerId, RideRequestDTO rideRequestDTO);
}
