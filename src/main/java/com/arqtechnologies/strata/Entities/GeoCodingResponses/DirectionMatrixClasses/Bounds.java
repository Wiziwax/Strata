package com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bounds {
    private DirectionMatrixLocation northeast;
    private DirectionMatrixLocation southwest;
}

