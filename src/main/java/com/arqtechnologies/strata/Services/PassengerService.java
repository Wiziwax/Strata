package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.PassengerResponseDTO;

public interface PassengerService {

    String createPassenger(PassengerRequestDTO passengerRequestDTO);

    //TODO LOGIN
    PassengerResponseDTO updatePassenger(PassengerRequestDTO passengerRequestDTO);
//    PassengerResponseDTO passwordReset
    //TODO PASSWORD RESET
}
