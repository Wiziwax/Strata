package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.RideDTO.CreateRideResponseDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.RestResponsePojo;
import com.arqtechnologies.strata.ServiceImpls.RideServiceImpl;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.PassengerService;
import com.arqtechnologies.strata.Services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerRestController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RideService rideService;

    @Autowired
    private RideServiceImpl rideServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createPassenger(@RequestBody PassengerRequestDTO passengerRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(passengerService.createPassenger(passengerRequestDTO));
        restResponsePojo.setSuccess(true);
        return restResponsePojo;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RestResponsePojo<DriverResponseDTO> getUserById(@RequestParam Integer userId){

        RestResponsePojo<DriverResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(driverService.getDriverById(userId));

        return restResponsePojo;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<PassengerResponseDTO> updatePassenger(@RequestBody PassengerRequestDTO  passengerRequestDTO){

        RestResponsePojo<PassengerResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(passengerService.updatePassenger(passengerRequestDTO));
        restResponsePojo.setSuccess(true);

        return restResponsePojo;
    }

    @PostMapping("destination")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<RideResponseDTO> setDestination(@RequestBody RideRequestDTO rideRequestDTO) throws InterruptedException {

        RestResponsePojo<RideResponseDTO> restResponsePojo = new RestResponsePojo<>();
        RideResponseDTO rideResponseDTO = rideService.setPassengerDestination(rideRequestDTO);
        restResponsePojo.setData(rideResponseDTO);
        restResponsePojo.setSuccess(true);
        restResponsePojo.setMessage("Ride created successfully");
        //Each route should come with data.
        return restResponsePojo;
    }


    @PutMapping("selectroute")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<List<DriverResponseDTO>> selectRoute(@RequestBody RideRequestDTO rideRequestDTO, @RequestParam Integer passengerId){
        //TODO Get from signed in user instead of passing from request param


        RestResponsePojo<List<DriverResponseDTO>>restResponsePojo = new RestResponsePojo<>();
        List<DriverResponseDTO> driversFound = passengerService.getDriversInPath(passengerId, rideRequestDTO);
        restResponsePojo.setData(driversFound);
        restResponsePojo.setMessage(driversFound.size()+ " Driver(s) found");
        return restResponsePojo;
    }

    //TODO DRIVERS INDICATE PATH THEY"RE TRAVELLING
    //TODO Filter available drivers based on the user's location
    //TODO LET IT NOT JUST CONTAIN EVERYONE HEADING THERE, OTHERWISE EVEN PEOPLE NOT IN PATH WILL BE IDENTIFIED,
    // SO ALSO FILTER BY PATH AND DESTINATION
    //TODO In driver-matching, match them based on active rides
//    @GetMapping("driversinpath")
//    @ResponseStatus(HttpStatus.OK)
//    public RestResponsePojo<DriverResponseDTO> getDriversHeadingInDirection(@RequestBody ){
//
//        RestResponsePojo<DriverResponseDTO> restResponsePojo =new RestResponsePojo<>();
////        restResponsePojo.setData();
//        restResponsePojo.setSuccess(true);
//        restResponsePojo.setMessage("Drivers Found");
//
//
//        return restResponsePojo;
//    }


    @PutMapping("requestride")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<CreateRideResponseDTO> requestRide(@RequestBody RideRequestDTO rideRequestDTO){

        RestResponsePojo<CreateRideResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setMessage("Ride request sent");
        restResponsePojo.setData(rideService.requestRide(rideRequestDTO));
        restResponsePojo.setStatus(201);
        return restResponsePojo;
    }

}
