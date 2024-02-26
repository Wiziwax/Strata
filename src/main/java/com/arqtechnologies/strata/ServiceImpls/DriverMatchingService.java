package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DriverMatchingService {

    @Autowired
    private DriverRepository driverRepository;


    @Async
    public CompletableFuture<List<Driver>> matchDriversAsync(String userLocation) {
        // Implement your driver matching logic here
        // Return a CompletableFuture with the matched drivers

//        simulateDelay();

        //TODO Filter available drivers based on the user's location
//        List<DriverTest> availableDrivers = allDrivers.stream()
//                .filter(driver -> driver.isAvailable() && isWithinRadius(driver.getLocation(), userLocation))
//                .collect(Collectors.toList());

        List<Driver> availableDrivers = driverRepository.getAllByIsAvailable(true);
        return CompletableFuture.completedFuture(availableDrivers);
    }


//    private boolean isWithinRadius(String driverLocation, String userLocation) {
//        // Implement your logic to check if the driver is within an acceptable radius
//        // This is a placeholder method, replace it with your actual distance calculation logic
//        return true;
//    }
//
//    private void simulateDelay() {
//        // Simulating some processing time for driver matching
//        try {
//            Thread.sleep(2000); // 2 seconds delay (adjust as needed)
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
}
