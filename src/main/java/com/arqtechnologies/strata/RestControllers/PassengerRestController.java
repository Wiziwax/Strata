package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.RestResponsePojo;
import com.arqtechnologies.strata.Services.PassengerService;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/passenger")
public class PassengerRestController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createPassenger(@RequestBody PassengerRequestDTO passengerRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(passengerService.createPassenger(passengerRequestDTO));
        restResponsePojo.setSuccess(true);
        return restResponsePojo;
    }
}
