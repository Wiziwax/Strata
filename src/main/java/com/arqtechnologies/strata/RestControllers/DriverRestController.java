package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.DriverDTO.DriverRideRequestDTO;
import com.arqtechnologies.strata.DTOs.DriverDTO.DriverRideResponseDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideRequestDTO;
import com.arqtechnologies.strata.DTOs.RideDTO.RideResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.RestResponsePojo;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserResponseDTO;
import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.RideService;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverRestController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private UserService userService;
    @Autowired
    private RideService rideService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createDriver(@RequestBody DriverRequestDTO driverRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(driverService.createDriver(driverRequestDTO));
        restResponsePojo.setMessage("Successful");
        restResponsePojo.setSuccess(true);
        return restResponsePojo;
    }


    @PostMapping("initiateride")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<DriverRideResponseDTO> createDriverRide(@RequestBody DriverRideRequestDTO driverRideRequestDTO) throws InterruptedException {

        RestResponsePojo<DriverRideResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(rideService.createDriverRide(driverRideRequestDTO));
        restResponsePojo.setSuccess(true);
        restResponsePojo.setMessage("Ride successfully initiated");
//        rideServiceImpl.PrintDrivers("Sad man");
        return restResponsePojo;
    }



    //TODO VISIT ALL THESE COMMENTED PARTS AND DO THEM
//
//    @PutMapping("alterpassword")
//    public RestResponsePojo<String> changePassword(@RequestBody PasswordReset passwordReset){
//
//    }
//
//    @PutMapping("updatedetails")
//    public RestResponsePojo<String> updateDriverDetails(@RequestBody DriverRequestDTO driverRequestDTO){
//
//    }
//
//    @GetMapping("seecluster")
//    public RestResponsePojo<String> seeClusterAndDestination(@RequestParam DriverRequestDTO driverRequestDTO){
//
//    }
//TODO THE ABOVE API should take Driver location and see just as much as subscribed for for cluster of passengers

    //View passengers going driver's direction
//    @GetMapping("viewonpath")
//    public RestResponsePojo<String> seePassengers(@RequestParam DriverRequestDTO driverRequestDTO){
//
//    }


    //TODO DOUBT WE'LL NEED THIS HERE
//    @GetMapping
//    @ResponseStatus(HttpStatus.FOUND)
//    public RestResponsePojo<DriverResponseDTO> getDriverById(@RequestParam Integer driverId){
//
//        RestResponsePojo<DriverResponseDTO> restResponsePojo = new RestResponsePojo<>();
//        restResponsePojo.setData(driverService.getDriverById(driverId));
//
//        return restResponsePojo;
//    }


    //TODO MOVE TO ADMIN PANEL
    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public RestResponsePojo<Page<UserResponseDTO>> getAllDrivers(Pageable pageable){

        RestResponsePojo<Page<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        restResponsePojo.setData(userService.getAllUser(0, pageable));
//        restResponsePojo.setData(userService.getAllUser(0, pageable));

        return restResponsePojo;
//        return userService.getAllUser(0, pageable);
    }

    //Search for clusters
    //Search by destination

}
