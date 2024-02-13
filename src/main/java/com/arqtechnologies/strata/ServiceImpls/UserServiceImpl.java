package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;
import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Entities.Passenger;
import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumRole;
import com.arqtechnologies.strata.Repositories.DriverRepository;
import com.arqtechnologies.strata.Repositories.UserRepository;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.arqtechnologies.strata.Enums.EnumRole.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public String createUser(UserRequestDTO userRequestDTO) {
        User newUser = new User();
       newUser.setFirstName(userRequestDTO.getFirstName());
       newUser.setLastName(userRequestDTO.getLastName());
       newUser.setEmail(userRequestDTO.getEmail());
       newUser.setPassword(userRequestDTO.getPassword());
       newUser.setPhoneNumber(userRequestDTO.getPhoneNumber());
       newUser.setPhoneNumber2(userRequestDTO.getPhoneNumber2());
       newUser.setCreatedDate(new Date());
//       user.er.setCreatedBy();

        //TODO IF USER IS DRIVER OR PASSENGER, CALL THEIR CORRESPONDING REPOSITORY
       newUser.setUserRole(userRequestDTO.getUserRole());
       userRepository.save(newUser);
        return "Successfully Created";
    }


    @Override
    public Page<UserResponseDTO> getAllUser(Integer roleId, Pageable pageable) {

        EnumRole enumRole = EnumRole.fromNumericValue(roleId);
        Page<User> userPage = userRepository.getUserByUserRole(enumRole, pageable);

        return userPage.map(user -> UserResponseDTO.builder()
                .createdDate(user.getCreatedDate())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .phoneNumber2(user.getPhoneNumber2())
                .userRole(user.getUserRole())
                .build());
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        return null;
    }


    //TODO
    @Override
    public UserResponseDTO getById(Integer userId) {
        User existingUser = userRepository
                .findById(userId).orElseThrow(RuntimeException::new);

        return  UserResponseDTO.builder()
                .firstName(existingUser.getFirstName())
                .lastName(existingUser.getLastName())
                .email(existingUser.getEmail())
                .userRole(existingUser.getUserRole())
                .phoneNumber(existingUser.getPhoneNumber())
                .phoneNumber2(existingUser.getPhoneNumber2())
                .createdDate(existingUser.getCreatedDate())
                .build();
    }

    @Override
    public void deleteAccount() {

    }
}
