package com.arqtechnologies.strata.Entities.GeoCodingResponses.DirectionMatrixClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Route {
    private Bounds bounds;
    private String copyrights;
    private List<Leg> legs;
    private OverviewPolyline overviewPolyline;
    private String summary;
    private List<String> warnings;
    private List<Integer> waypointOrder;


}