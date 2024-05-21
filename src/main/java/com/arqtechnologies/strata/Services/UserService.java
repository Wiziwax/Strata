package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.UserDTOs.LocationRequest;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserResponseDTO;
import com.arqtechnologies.strata.Entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    String createUser(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard
    Page<UserResponseDTO> getAllUser(Integer roleId, Pageable pageable);
    List<User> getEveryUser();
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getById(Integer userId);
    void deleteAccount(Integer userId);
    void updateUserLocation(LocationRequest locationRequest);
}
