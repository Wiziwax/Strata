package com.arqtechnologies.strata.RestControllers;

import com.arqtechnologies.strata.DTOs.RestResponsePojo;
import com.arqtechnologies.strata.DTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponsePojo<String> createPassenger(@RequestBody UserRequestDTO userRequestDTO){

        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();
        restResponsePojo.setData(userService.createUser(userRequestDTO));
        restResponsePojo.setSuccess(true);
        return restResponsePojo;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public RestResponsePojo<List<UserResponseDTO>> getAllByRole(@RequestParam Integer roleId){

        RestResponsePojo<List<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        restResponsePojo.setData(userService.getAllUser(roleId));

        return restResponsePojo;
    }
}
