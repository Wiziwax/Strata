package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.*;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class DriverRestController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createDriver(@RequestBody DriverRequestDTO driverRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(driverService.createDriver(driverRequestDTO));
        restResponsePojo.setMessage("Successful");
        restResponsePojo.setSuccess(true);
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
    @ResponseStatus(HttpStatus.FOUND)
    public RestResponsePojo<Page<UserResponseDTO>> getAllDrivers(Pageable pageable){

        RestResponsePojo<Page<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        restResponsePojo.setData(userService.getAllUser(0, pageable));

        return restResponsePojo;
    }
}
