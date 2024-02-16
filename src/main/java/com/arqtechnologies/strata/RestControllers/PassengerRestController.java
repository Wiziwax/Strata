package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.PassengerResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.RestResponsePojo;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.PassengerService;
import com.arqtechnologies.strata.Services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passenger")
public class PassengerRestController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RideService rideService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createPassenger(@RequestBody PassengerRequestDTO passengerRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(passengerService.createPassenger(passengerRequestDTO));
        restResponsePojo.setSuccess(true);
        return restResponsePojo;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public RestResponsePojo<DriverResponseDTO> getDriverById(@RequestParam Integer driverId){

        RestResponsePojo<DriverResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(driverService.getDriverById(driverId));

        return restResponsePojo;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public RestResponsePojo<PassengerResponseDTO> updatePassenger(@RequestBody PassengerRequestDTO passengerRequestDTO){

        RestResponsePojo<PassengerResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(passengerService.updatePassenger(passengerRequestDTO));
        restResponsePojo.setSuccess(true);

        return restResponsePojo;
    }

    @PostMapping("riderequest")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createRide(@RequestBody RideRequestDTO rideRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(rideService.createRide(rideRequestDTO));
        restResponsePojo.setSuccess(true);
        restResponsePojo.setMessage("Ride successfully requested");
        return restResponsePojo;
    }

}
