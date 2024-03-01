package com.arqtechnologies.strata.Entities.GeoCodingResponses;

import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses.GeocodedWaypoint;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses.DirectionMatrixLocation;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses.Route;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class DirectionsMatrixResponse {
    
        private List<GeocodedWaypoint> geocodedWaypoints;
        private List<Route> routes;
        private String status;

}
