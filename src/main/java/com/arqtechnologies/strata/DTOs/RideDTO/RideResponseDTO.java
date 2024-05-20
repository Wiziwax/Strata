package com.arqtechnologies.strata.DTOs.RideDTO;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class RideResponseDTO {

    String rideId;
    Integer numberOfRoutes;
    List<String> routes;

    public RideResponseDTO() {
        this.routes = new ArrayList<>();
    }
}
