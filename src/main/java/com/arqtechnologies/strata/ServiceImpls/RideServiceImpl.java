package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;
import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.DistanceMatrixResponse;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.GeocodingResponse;
import com.arqtechnologies.strata.Entities.Ride;
import com.arqtechnologies.strata.Repositories.DriverRepository;
import com.arqtechnologies.strata.Repositories.RideRepository;
import com.arqtechnologies.strata.Services.RideService;
import com.arqtechnologies.strata.Utils.RideChangeEvent;
import com.arqtechnologies.strata.Utils.RideEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.arqtechnologies.strata.Enums.EnumStatus.*;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private GoogleMapsService googleMapsService;
    @Autowired
    private DriverMatchingService driverMatchingService;
    @Autowired
    private DriverRepository driverRepository;



    public String createRide(RideRequestDTO rideRequestDTO) throws InterruptedException {
        Ride newRide = new Ride();

        setRideAttributesFromDTO(newRide, rideRequestDTO);

        try {
            GeocodingResponse.Results originGeoCodingResult = googleMapsService.getGeocodingData(rideRequestDTO.getOriginAddress()).getResults().get(0);
            GeocodingResponse.Results destinationGeoCodingResult = googleMapsService.getGeocodingData(rideRequestDTO.getDestinationAddress()).getResults().get(0);

            setRideLocationAttributes(newRide, originGeoCodingResult, destinationGeoCodingResult);

            DistanceMatrixResponse.Element distanceMatrixElement = googleMapsService.getDistanceMatrix(rideRequestDTO.getOriginAddress(), rideRequestDTO.getDestinationAddress()).getRows().get(0).getElements().get(0);

            setRideDistanceAttributes(newRide, distanceMatrixElement);

        } catch (Exception e) {
            // Handle exceptions (e.g., API call failures) appropriately
            return "Failed to create ride";
        }

        rideRepository.save(newRide);
        System.out.println("Ride created successfully");
        return "Ride created successfully";
    }

    public CompletableFuture<List<Driver>> PrintDrivers(String matchingResultString) throws InterruptedException {
        Thread.sleep(20000L);
        return driverMatchingService.matchDriversAsync(matchingResultString);
    }

    private void setRideAttributesFromDTO(Ride newRide, RideRequestDTO rideRequestDTO) {
        newRide.setCarType(rideRequestDTO.getCarType());
        newRide.setBookingStatus(REQUESTED);
        newRide.setPaymentMethod(rideRequestDTO.getPaymentMethod());
        newRide.setCreatedDate(new Date());
        newRide.setAdditionalNotes(rideRequestDTO.getAdditionalNotes());
        newRide.setOriginAddress(rideRequestDTO.getDestinationAddress());
        newRide.setDestinationAddress(rideRequestDTO.getDestinationAddress());
        newRide.set
        //TODO GEO DISTANCE MATRIX
        newRide.setEstimatedDistance(0); // Set default values
        newRide.setETA(0); // Set default values
    }

    private void setRideLocationAttributes(Ride newRide, GeocodingResponse.Results originGeoCodingResult, GeocodingResponse.Results destinationGeoCodingResult) {
        newRide.setStartLongitude(originGeoCodingResult.getGeometry().getLocation().getLng());
        newRide.setStartLatitude(originGeoCodingResult.getGeometry().getLocation().getLat());
        newRide.setEndLongitude(destinationGeoCodingResult.getGeometry().getLocation().getLng());
        newRide.setEndLatitude(destinationGeoCodingResult.getGeometry().getLocation().getLat());
    }

    private void setRideDistanceAttributes(Ride newRide, DistanceMatrixResponse.Element distanceMatrixElement) {
        newRide.setEstimatedDistance(distanceMatrixElement.getDistance().getValue());
        newRide.setETA(distanceMatrixElement.getDuration().getValue());
    }


    @Override
    public RideResponseDTO driverMatching() {
        return null;
    }

    @Override
    public RideResponseDTO rideStatusUpdate() {
        return null;
    }

    @Override
    public RideResponseDTO fareCalculation() {
        return null;
    }

    @Override
    public RideResponseDTO rateAndFeedback() {
        return null;
    }

    @Override
    public RideResponseDTO getRide() {
        return null;
    }

    @Override
    public void cancelRide() {
    }

    @Async
    public CompletableFuture<List<Driver>> matchDriversAsync(String userLocation, Double latitude, Double longitude) {
        // Implement your driver matching logic here
        // Return a CompletableFuture with the matched drivers

        CompletableFuture<List<Driver>> availableDrivers = driverRepository.find

//        simulateDelay();

        //TODO Filter available drivers based on the user's location
//        List<DriverTest> availableDrivers = allDrivers.stream()
//                .filter(driver -> driver.isAvailable() && isWithinRadius(driver.getLocation(), userLocation))
//                .collect(Collectors.toList());

        List<Driver> availableDrivers = driverRepository.getAllByIsAvailable(true);
        return CompletableFuture.completedFuture(availableDrivers);
    }



//    @EventListener
//    public void handleRideChangeEvent(RideChangeEvent event) {
//        Ride ride = (Ride) event.getSource();
//        // Check booking_status and trigger actions accordingly
//        // Example: If booking_status is '0', start matching to an available driver
//    }

}

//    @EventListener
//    public void handleRideChangeEvent(RideChangeEvent event) {
//        Ride ride = (Ride) event.getSource();
//
//        if (ride.getBookingStatus() == REQUESTED) {
//            // Booking status is '0' (PENDING), initiate driver matching
//            CompletableFuture<List<Driver>> matchingResult = driverMatchingService.matchDriversAsync(ride.getOriginAddress());
//
//            matchingResult.thenAccept(drivers -> {
//                if (!drivers.isEmpty()) {
//                    // Assign the first available driver to the ride
//                    Driver matchedDriver = drivers.get(0);//TODO NOT THE FIRST IN THE LIST, RATHER, THE FIRST TO TAKE IT
//                    System.out.printf("Driver with name %s %s was matched to you%n", matchedDriver.getFirstName(), matchedDriver.getLastName());
//                    ride.setDriverId(matchedDriver.getUserId());
//                    ride.setDriverName(matchedDriver.getFirstName() + " " + matchedDriver.getLastName());
//
//                    //TODO DRIVER ACCEPTS RIDE FIRST
//                    ride.setBookingStatus(ACCEPTED);
//                    rideEventPublisher.publishRideChangeEvent(ride);
//
//                    // Perform any additional actions or notifications as needed
//
//                    // Update the ride in the database or any persistent storage
//                    rideRepository.save(ride);
//                } else {
//                    // No available drivers, handle accordingly (e.g., update booking status to 'NO_DRIVERS_AVAILABLE')
//                    ride.setBookingStatus(NO_DRIVERS_AVAILABLE);
//
//                    // Update the ride in the database or any persistent storage
//                    // rideRepository.save(ride);
//                }
//            });
//        }
//    }


//    @Override
//    public String createRide(RideRequestDTO rideRequestDTO) {
//        Ride newRide = new Ride();
//
////        newRide.setPassengerId();//TODO FIX THIS AFTER AUTHENTICATION IS DONE
////        newRide.setPassengerName();
//        newRide.setCarType(rideRequestDTO.getCarType());
////        newRide.setDriverId();//TODO FIX AFTER DRIVER MATCHING IS SUCCESSFUL
////        newRide.setDriverName();//TODO FIX AFTER DRIVER MATCHING IS SUCCESSFUL
////        newRide.setCarType();//TODO GET FROM DRIVER INFORMATION
//        newRide.setStartLongitude(googleMapsService.getGeocodingData(rideRequestDTO.getOriginAddress()).getResults().get(0)
//                .getGeometry().getLocation().getLng());//TODO FIX AFTER IMPLEMENTING GOOGLE MAP
//        newRide.setStartLatitude(googleMapsService.getGeocodingData(rideRequestDTO.getOriginAddress()).getResults().get(0)
//                .getGeometry().getLocation().getLat());
//        newRide.setEndLongitude(googleMapsService.getGeocodingData(rideRequestDTO.getDestinationAddress()).getResults().get(0)
//                .getGeometry().getLocation().getLng());
//        newRide.setEndLatitude(googleMapsService.getGeocodingData(rideRequestDTO.getDestinationAddress()).getResults().get(0)
//                .getGeometry().getLocation().getLat());
//        newRide.setBookingStatus(REQUESTED);
////        newRide.setStartTime(new Date());//TODO SET AFTER BOARDING THE VEHICLE
////        newRide.setEndTime(rideRequestDTO.getEndTime());//TODO DO THIS AFTER FINISHING TRIP
////        newRide.setTransportFare(rideRequestDTO.getTransportFare());//TODO CALCULATE USING NECESSARY PARAMETERS
//        newRide.setPaymentMethod(rideRequestDTO.getPaymentMethod());
//        newRide.setCreatedDate(new Date());
//        newRide.setAdditionalNotes(rideRequestDTO.getAdditionalNotes());
////        newRide.setReviews();//TODO SET AFTER RIDE FINISHES
//        newRide.setOriginAddress(rideRequestDTO.getDestinationAddress());
//        newRide.setDestinationAddress(rideRequestDTO.getDestinationAddress());
////        newRide.setLandmarkNearby();
//        newRide.setEstimatedDistance(googleMapsService.getDistanceMatrix(rideRequestDTO.getOriginAddress(),
//                rideRequestDTO.getDestinationAddress()).getRows().get(0).getElements().get(0).getDistance().getValue());
//        newRide.setETA(googleMapsService.getDistanceMatrix(rideRequestDTO.getOriginAddress(),
//                rideRequestDTO.getDestinationAddress()).getRows().get(0).getElements().get(0).getDuration().getValue());
//
//        rideRepository.save(newRide);
//        return "Ride Created successfully";
//    }

