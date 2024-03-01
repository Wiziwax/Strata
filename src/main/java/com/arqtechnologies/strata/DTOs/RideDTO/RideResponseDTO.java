package com.arqtechnologies.strata.DTOs.RideDTO;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class RideResponseDTO {

    Integer numberOfRoutes;
    List<String> routes;
}
