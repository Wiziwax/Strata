package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;
import com.arqtechnologies.strata.Entities.GeoCodingResponses.GeocodingResponse;
import com.arqtechnologies.strata.Entities.Ride;
import com.arqtechnologies.strata.Repositories.RideRepository;
import com.arqtechnologies.strata.Services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.arqtechnologies.strata.Enums.EnumStatus.REQUESTED;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private GoogleMapsService googleMapsService;

    @Override
    public String createRide(RideRequestDTO rideRequestDTO) {
        Ride newRide = new Ride();

//        newRide.setPassengerId();//TODO FIX THIS AFTER AUTHENTICATION IS DONE
//        newRide.setPassengerName();
        newRide.setCarType(rideRequestDTO.getCarType());
//        newRide.setDriverId();//TODO FIX AFTER DRIVER MATCHING IS SUCCESSFUL
//        newRide.setDriverName();//TODO FIX AFTER DRIVER MATCHING IS SUCCESSFUL
//        newRide.setCarType();//TODO GET FROM DRIVER INFORMATION
        newRide.setStartLongitude(googleMapsService.getGeocodingData(rideRequestDTO.getOriginAddress()).getResults().get(0).getGeometry().getLocation().getLng());//TODO FIX AFTER IMPLEMENTING GOOGLE MAP
        newRide.setStartLatitude(googleMapsService.getGeocodingData(rideRequestDTO.getOriginAddress()).getResults().get(0).getGeometry().getLocation().getLat());
        newRide.setEndLongitude(googleMapsService.getGeocodingData(rideRequestDTO.getDestinationAddress()).getResults().get(0).getGeometry().getLocation().getLng());
        newRide.setEndLatitude(googleMapsService.getGeocodingData(rideRequestDTO.getDestinationAddress()).getResults().get(0).getGeometry().getLocation().getLat());
        newRide.setBookingStatus(REQUESTED);
//        newRide.setStartTime(new Date());//TODO SET AFTER BOARDING THE VEHICLE
//        newRide.setEndTime(rideRequestDTO.getEndTime());//TODO DO THIS AFTER FINISHING TRIP
//        newRide.setTransportFare(rideRequestDTO.getTransportFare());//TODO CALCULATE USING NECESSARY PARAMETERS
        newRide.setPaymentMethod(rideRequestDTO.getPaymentMethod());
        newRide.setCreatedDate(new Date());
        newRide.setAdditionalNotes(rideRequestDTO.getAdditionalNotes());
//        newRide.setReviews();//TODO SET AFTER RIDE FINISHES
        newRide.setOriginAddress(rideRequestDTO.getDestinationAddress());
        newRide.setDestinationAddress(rideRequestDTO.getDestinationAddress());
//        newRide.setLandmarkNearby();
        newRide.setEstimatedDistance(googleMapsService.getDistanceMatrix(rideRequestDTO.getOriginAddress(), rideRequestDTO.getDestinationAddress()).getRows().get(0).getElements().get(0).getDistance().getValue());
        newRide.setETA(googleMapsService.getDistanceMatrix(rideRequestDTO.getOriginAddress(), rideRequestDTO.getDestinationAddress()).getRows().get(0).getElements().get(0).getDuration().getValue());

        rideRepository.save(newRide);
        return "Ride Created successfully";
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
}
