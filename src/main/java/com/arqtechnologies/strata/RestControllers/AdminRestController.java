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
@RequestMapping("/api/admin")
public class AdminRestController {


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
    @ResponseStatus(HttpStatus.OK)
    public RestResponsePojo<Page<UserResponseDTO>> getAllByRole(@RequestParam Integer roleId, Pageable pageable){

        RestResponsePojo<Page<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        String userRole = null;
        if(roleId==0){
            userRole = "Driver(s)";
        } else if (roleId==1) {
            userRole = "Passenger(s)";
        } else if (roleId == 2) {
            userRole = "Customer Service member(s)";
        } else if (roleId == 3) {
            userRole = "Developer(s)";
        } else if (roleId == 4) {
            userRole = "Admin(s)";
        } else {
            throw new RuntimeException("Unknown User Role");
        }
        restResponsePojo.setMessage( userRole +" Found");
        restResponsePojo.setData(userService.getAllUser(roleId, pageable));
//        restResponsePojo.setStatus(HttpStatus);//TODO UNDO THIS AFTER SETTING EXCEPTION HANDLER
        restResponsePojo.setSuccess(true);

        return restResponsePojo;
    }



    @GetMapping("allusers")
    public List<User> getEveryOne(){
        return userService.getEveryUser();
    }


    @GetMapping("/driver/getall")
    @ResponseStatus(HttpStatus.OK)
    public RestResponsePojo<Page<UserResponseDTO>> getAllDrivers(Pageable pageable){

        RestResponsePojo<Page<UserResponseDTO>> restResponsePojo= new RestResponsePojo<>();
        restResponsePojo.setData(userService.getAllUser(0, pageable));

        return restResponsePojo;
    }

    @DeleteMapping("deleteuser")
    public String deleteUser(@RequestBody Integer userId){
        userService.deleteAccount(userId);
        return "User deleted Successfully";
    }
}
