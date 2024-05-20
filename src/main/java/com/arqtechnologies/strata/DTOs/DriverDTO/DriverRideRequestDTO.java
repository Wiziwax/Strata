package com.arqtechnologies.strata.DTOs.DriverDTO;

import lombok.Data;

@Data
public class DriverRideRequestDTO {

    String rideId;
    Double startLongitude;
    Double startLatitude;
    String destinationAddress;
    String originAddress;//TODO comes from device's location
    String route;
}
