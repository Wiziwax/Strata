package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.RestResponsePojo;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverRestController {

    @Autowired
    private DriverService driverService;
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createDriver(@RequestBody DriverRequestDTO driverRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(driverService.createDriver(driverRequestDTO));
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

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.FOUND)
    public RestResponsePojo<List<UserResponseDTO>> getAllByRole(@RequestParam Integer roleId){

        RestResponsePojo<List<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        restResponsePojo.setData(userService.getAllUser(roleId));

        return restResponsePojo;
    }
}
