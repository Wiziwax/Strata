package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public interface RideService {

    Integer createRide(RideRequestDTO rideRequestDTO) throws InterruptedException;
    RideResponseDTO driverMatching();
    RideResponseDTO rideStatusUpdate();
    RideResponseDTO fareCalculation();
    RideResponseDTO rateAndFeedback();
    RideResponseDTO getRide();
    void cancelRide();
}
