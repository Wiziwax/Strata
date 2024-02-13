package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.PassengerRequestDTO;
import com.arqtechnologies.strata.DTOs.UserRequestDTO;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;
import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Entities.Passenger;
import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumRole;
import com.arqtechnologies.strata.Repositories.UserRepository;
import com.arqtechnologies.strata.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.arqtechnologies.strata.Enums.EnumRole.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public String createDriver(DriverRequestDTO driverRequestDTO) {
//        Driver newDriver = new Driver();
//
//        newDriver.setFirstName(driverRequestDTO.getFirstName());
//        newDriver.setLastName(driverRequestDTO.getLastName());
//        newDriver.setEmail(driverRequestDTO.getEmail());
//        newDriver.setPassword(driverRequestDTO.getPassword());
//        newDriver.setPhoneNumber(driverRequestDTO.getPhoneNumber());
//        newDriver.setPhoneNumber2(driverRequestDTO.getPhoneNumber2());
//        newDriver.setLicenseNumber(driverRequestDTO.getLicenseNumber());
//        newDriver.setCarModel(driverRequestDTO.getCarModel());
//        newDriver.setCarColour(driverRequestDTO.getCarColour());
//        newDriver.setCarPlateNumber(driverRequestDTO.getCarPlateNumber());
//        newDriver.setCarCapacity(driverRequestDTO.getCarCapacity());
////        newDriver.setCreatedBy();//TODO AUTHENTICATION
//        newDriver.setCreatedDate(new Date());
//        newDriver.setUserRole(DRIVER);
//
//        userRepository.save(newDriver);
//        return "Successfully Created";
//    }

    @Override
    public String createPassenger(PassengerRequestDTO passengerRequestDTO) {

        Passenger newPassenger = new Passenger();

        newPassenger.setFirstName(passengerRequestDTO.getFirstName());
        newPassenger.setLastName(passengerRequestDTO.getLastName());
        newPassenger.setEmail(passengerRequestDTO.getEmail());
        newPassenger.setPassword(passengerRequestDTO.getPassword());
        newPassenger.setPhoneNumber(passengerRequestDTO.getPhoneNumber());
        newPassenger.setPhoneNumber2(passengerRequestDTO.getPhoneNumber2());
        newPassenger.setCreatedDate(new Date());
//        newPassenger.setCreatedBy();//TODO AUTHENTICATION
        newPassenger.setUserRole(PASSENGER);

        return "Successfully Created";
    }

    @Override
    public String createAdmin(UserRequestDTO userRequestDTO) {
        User newUser = new User();
        newUser.setFirstName(userRequestDTO.getFirstName());
        newUser.setLastName(userRequestDTO.getLastName());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setPassword(userRequestDTO.getPassword());
        newUser.setPhoneNumber(userRequestDTO.getPhoneNumber());
        newUser.setPhoneNumber2(userRequestDTO.getPhoneNumber2());
        newUser.setCreatedDate(new Date());
//        user.setCreatedBy();
        newUser.setUserRole(ADMIN);
        return "Successfully Created";
    }

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
       newUser.setUserRole(userRequestDTO.getUserRole());
       userRepository.save(newUser);
        return "Successfully Created";
    }

//    @Override
//    public String createCustomerService(UserRequestDTO userRequestDTO) {
//
//        User newUser = new User();
//        dataTransfer(userRequestDTO, newUser);
//        return "Successfully Created";
//    }

    private void dataTransfer(UserRequestDTO userRequestDTO, User user) {
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setPhoneNumber2(userRequestDTO.getPhoneNumber2());
        user.setCreatedDate(new Date());
//        user.setCreatedBy();
        user.setUserRole(userRequestDTO.getUserRole());

    }

    @Override
    public List<UserResponseDTO> getAllUser(Integer roleId) {
        userRepository.getUserByUserRole(EnumRole.fromNumericValue(roleId));
        return null;
    }

    @Override
    public UserResponseDTO updateUser(Integer userId) {
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
                .userRole(EnumRole.fromNumericValue(existingUser.getUserRole().getNumericValue()))
                .phoneNumber(existingUser.getPhoneNumber())
                .phoneNumber2(existingUser.getPhoneNumber2())
                .createdDate(existingUser.getCreatedDate())
                .build();
    }

    @Override
    public void deleteAccount() {

    }
}
