package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.ServiceImpls.DriverMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/matching")
public class MatchingRestController {

    @Autowired
    private DriverMatchingService driverMatchingService;
//
//    @PostMapping("/match")
//    public CompletableFuture<List<Driver>> matchDrivers(@RequestBody String userLocation) {
//        return driverMatchingService.matchDriversAsync(userLocation);
//    }
}
