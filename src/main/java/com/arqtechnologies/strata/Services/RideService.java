package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;

public interface RideService {

    String createRide(RideRequestDTO rideRequestDTO);
    RideResponseDTO driverMatching();
    RideResponseDTO rideStatusUpdate();
    RideResponseDTO fareCalculation();
    RideResponseDTO rateAndFeedback();
    RideResponseDTO getRide();
    void cancelRide();
}
