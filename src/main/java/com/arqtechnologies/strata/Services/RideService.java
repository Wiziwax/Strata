package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.DriverDTO.DriverRideRequestDTO;
import com.arqtechnologies.strata.DTOs.DriverDTO.DriverRideResponseDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.CreateRideResponseDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public interface RideService {

    RideResponseDTO setPassengerDestination(RideRequestDTO rideRequestDTO) throws InterruptedException;

    CreateRideResponseDTO requestRide(RideRequestDTO rideRequestDTO);
    DriverRideResponseDTO createDriverRide(DriverRideRequestDTO driverRideRequestDTO);
    RideResponseDTO driverMatching();
    RideResponseDTO rideStatusUpdate();
    RideResponseDTO fareCalculation();
    RideResponseDTO rateAndFeedback();
    RideResponseDTO getRide();
    void cancelRide();
}
