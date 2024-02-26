package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.UserDTOs.LocationRequest;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {


    String createUser(UserRequestDTO userRequestDTO); //TODO Move to Admin Dashboard
    Page<UserResponseDTO> getAllUser(Integer roleId, Pageable pageable);
    UserResponseDTO updateUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getById(Integer userId);
    void deleteAccount();
    void updateUserLocation(LocationRequest locationRequest);
}
