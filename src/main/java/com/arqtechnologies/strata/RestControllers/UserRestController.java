package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.UserDTOs.RestResponsePojo;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserResponseDTO;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.PassengerService;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private PassengerService passengerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createUser(@RequestBody UserRequestDTO userRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(userService.createUser(userRequestDTO));
        restResponsePojo.setMessage("Successful");
        restResponsePojo.setSuccess(true);
        return restResponsePojo;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public RestResponsePojo<Page<UserResponseDTO>> getAllByRole(@RequestParam Integer roleId, Pageable pageable){

        RestResponsePojo<Page<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        restResponsePojo.setMessage("User(s) Found");
        restResponsePojo.setData(userService.getAllUser(roleId, pageable));
//        restResponsePojo.setStatus(HttpStatus);//TODO UNDO THIS AFTER SETTING EXCEPTION HANDLER
        restResponsePojo.setSuccess(true);

        return restResponsePojo;
    }

    //Get ride by driver and user

}
