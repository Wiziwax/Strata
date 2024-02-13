package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;

import java.util.List;

public interface UserService {

//    String createDriver(DriverRequestDTO driverRequestDTO);
    String createPassenger(PassengerRequestDTO passengerRequestDTO);
    String createAdmin(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard
//    String createDeveloper(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard
    String createUser(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard

    List<UserResponseDTO> getAllUser(Integer roleId);
    UserResponseDTO updateUser(Integer userId);
    UserResponseDTO getById(Integer userId);
    void deleteAccount();

}
