package com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses;

import com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionsMatrixResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Leg {
    private Distance distance;
    private Duration duration;
    private String endAddress;
    private DirectionMatrixLocation endLocation;
    private String startAddress;
    private DirectionMatrixLocation startLocation;
    private List<Step> steps;


}
