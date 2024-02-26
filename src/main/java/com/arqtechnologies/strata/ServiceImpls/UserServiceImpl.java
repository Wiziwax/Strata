package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.UserDTOs.LocationRequest;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.UserResponseDTO;
import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Entities.Passenger;
import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumRole;
import com.arqtechnologies.strata.Repositories.DriverRepository;
import com.arqtechnologies.strata.Repositories.PassengerRepository;
import com.arqtechnologies.strata.Repositories.UserRepository;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PassengerRepository passengerRepository;


    @Override
    public String createUser(UserRequestDTO userRequestDTO) {
        EnumRole userRole = userRequestDTO.getUserRole();

        switch (userRole) {
            case DRIVER -> {
                Driver newDriver = new Driver();
                copyCommonProperties(userRequestDTO, newDriver);
                driverRepository.save(newDriver);
                return "Driver Successfully Created";
            }
            case PASSENGER -> {
                Passenger newPassenger = new Passenger();
                copyCommonProperties(userRequestDTO, newPassenger);
                passengerRepository.save(newPassenger);
                return "Passenger Successfully Created";
            }
            default -> {
                User newUser = new User();
                copyCommonProperties(userRequestDTO, newUser);
                userRepository.save(newUser);
                return EnumRole.fromNumericValue(userRole.getNumericValue()) +
                        " Successfully Created";
            }//TODO AFTER DOING SECURITY MOVE THIS TO A METHOD THAT'LL PROTECTED AND LET ONLY ADMINS ACCESS
        }
    }

    private void copyCommonProperties(UserRequestDTO userRequestDTO, User user) {
        user.setFirstName(userRequestDTO.getFirstName().trim());
        user.setLastName(userRequestDTO.getLastName().trim());
        user.setEmail(userRequestDTO.getEmail().toLowerCase());
        user.setPassword(userRequestDTO.getPassword());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber().trim());
        user.setPhoneNumber2(userRequestDTO.getPhoneNumber2().trim());
        user.setCreatedDate(new Date());
        user.setUserRole(userRequestDTO.getUserRole());
    }



    @Override
    public Page<UserResponseDTO> getAllUser(Integer roleId, Pageable pageable) {

        EnumRole enumRole = EnumRole.fromNumericValue(roleId);
        Page<User> userPage = userRepository.getUserByUserRole(enumRole, pageable);

        return userPage.map(user -> UserResponseDTO.builder().createdDate(user.getCreatedDate()).firstName(user.getFirstName()).lastName(user.getLastName()).email(user.getEmail()).phoneNumber(user.getPhoneNumber()).phoneNumber2(user.getPhoneNumber2()).userRole(user.getUserRole()).build());
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        return null;
    }


    //TODO
    @Override
    public UserResponseDTO getById(Integer userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(RuntimeException::new);

        return UserResponseDTO.builder().firstName(existingUser.getFirstName()).lastName(existingUser.getLastName()).email(existingUser.getEmail()).userRole(existingUser.getUserRole()).phoneNumber(existingUser.getPhoneNumber()).phoneNumber2(existingUser.getPhoneNumber2()).createdDate(existingUser.getCreatedDate()).build();
    }

    @Override
    public void deleteAccount() {

    }

    @Override
    public void updateUserLocation(LocationRequest locationRequest) {

        Optional<User> optionalUser = userRepository.findById(locationRequest.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setOriginLatitude(locationRequest.getLatitude());
            user.setOriginLongitude(locationRequest.getLongitude());
            userRepository.save(user);
        }
    }
}
