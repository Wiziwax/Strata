package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.Entities.GeoCodingResponses.GeocodingResponse;
import com.arqtechnologies.strata.ServiceImpls.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapsController {

    @Autowired
    private GoogleMapsService googleMapsService;

    @GetMapping("")
    public GeocodingResponse getGeocodingData(@RequestParam String address) {
        return googleMapsService.getGeocodingData(address);
    }
}
