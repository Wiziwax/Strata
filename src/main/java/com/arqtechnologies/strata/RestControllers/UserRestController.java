package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.UserDTOs.RestResponsePojo;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserResponseDTO;
import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Services.DriverService;
import com.arqtechnologies.strata.Services.PassengerService;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private PassengerService passengerService;


    @GetMapping("getbyid")
    public RestResponsePojo<UserResponseDTO> getUserById(@RequestParam Integer userId){
        RestResponsePojo<UserResponseDTO> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(userService.getById(userId));
        restResponsePojo.setMessage("User Found");
        restResponsePojo.setSuccess(true);

        return restResponsePojo;
    }


}
