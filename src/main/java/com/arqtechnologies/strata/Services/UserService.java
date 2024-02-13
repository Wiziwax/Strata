package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {


    String createAdmin(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard
//    String createDeveloper(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard
    String createUser(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard

    Page<UserResponseDTO> getAllUser(Integer roleId, Pageable pageable);
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getById(Integer userId);
    void deleteAccount();

}
