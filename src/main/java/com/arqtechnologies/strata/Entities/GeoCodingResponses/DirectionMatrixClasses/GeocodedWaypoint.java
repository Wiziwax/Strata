package com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodedWaypoint {
    private String geocoderStatus;
    private boolean partialMatch;
    private String placeId;
    private List<String> types;


}
