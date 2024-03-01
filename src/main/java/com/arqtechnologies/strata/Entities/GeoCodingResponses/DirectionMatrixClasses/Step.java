package com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses;

import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionsMatrixResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {
    private Distance distance;
    private Duration duration;
    private DirectionMatrixLocation endLocation;
    private String htmlInstructions;
    private String maneuver;
    private Polyline polyline;
    private DirectionMatrixLocation startLocation;
    private String travelMode;

}

