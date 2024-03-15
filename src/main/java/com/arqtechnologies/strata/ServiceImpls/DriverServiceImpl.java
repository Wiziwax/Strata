package com.arqtechnologies.strata.ServiceImpls;

import com.arqtechnologies.strata.DTOs.DriverDTO.DriverRideRequestDTO;
import com.arqtechnologies.strata.DTOs.DriverDTO.DriverRideResponseDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;
import com.arqtechnologies.strata.Entities.Driver;
import com.arqtechnologies.strata.Repositories.DriverRepository;
import com.arqtechnologies.strata.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.arqtechnologies.strata.Enums.EnumRole.DRIVER;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public String createDriver(DriverRequestDTO driverRequestDTO) {
        Driver newDriver = new Driver();

        newDriver.setFirstName(driverRequestDTO.getFirstName().trim());
        newDriver.setLastName(driverRequestDTO.getLastName().trim());
        newDriver.setEmail(driverRequestDTO.getEmail().toLowerCase());
        newDriver.setPassword(driverRequestDTO.getPassword());
        newDriver.setPhoneNumber(driverRequestDTO.getPhoneNumber().trim());
        newDriver.setPhoneNumber2(driverRequestDTO.getPhoneNumber2().trim());
        newDriver.setLicenseNumber(driverRequestDTO.getLicenseNumber().trim());
        newDriver.setIdType(driverRequestDTO.getIdType());//Create an Enum or a static data for this
        newDriver.setCarModel(driverRequestDTO.getCarModel().trim());
        newDriver.setCarType(driverRequestDTO.getCarType());
        newDriver.setCarColour(driverRequestDTO.getCarColour().trim());
        newDriver.setCarPlateNumber(driverRequestDTO.getCarPlateNumber().trim());
        newDriver.setCarCapacity(driverRequestDTO.getCarCapacity());
//        newDriver.setCreatedBy(newDriver.getUserId());//TODO AUTHENTICATION
        newDriver.setCreatedDate(new Date());
        newDriver.setUserRole(DRIVER);
        newDriver.setAverageRating(0.0);
        newDriver.setIsAvailable(true);
        newDriver.setTrips(0);

        driverRepository.save(newDriver);
        return "Successfully Created";
    }
    @Override
    public DriverResponseDTO getDriverById(Integer driverId) {
        Driver existingUser = driverRepository
                .findById(driverId).orElseThrow(RuntimeException::new);

        return  DriverResponseDTO.builder()
                .firstName(existingUser.getFirstName())
                .lastName(existingUser.getLastName())
                .userRole(DRIVER)
                .phoneNumber(existingUser.getPhoneNumber())
                .phoneNumber2(existingUser.getPhoneNumber2())
                .createdDate(existingUser.getCreatedDate())
                .build();
    }


//    @Override
//    public UserResponseDTO updateDriver(DriverRequestDTO driverRequestDTO) {
//
//        //TODO PUT RESTRICTIONS ON THE FREQUENCY OF HOW THIS CAN BE DONE PER USER
//        //TODO PROTOCOLS SHOULD BE PUT IN PLACE
//        Driver driver = driverRepository.findById(driverRequestDTO.getDriverId())
//                                        .orElseThrow(()-> new RuntimeException("Couldn't find Driver with id " + driverRequestDTO.getDriverId()));
//
//        //TODO LIMIT THE CHANGE OF LICENSE NUMBER AND PLATE NUMBER, THEY SHOULD APPLY FOR THAT
//        driver.set
//        return null;
//    }

    @Override
    public void deleteDriverAccount(Integer driverId) {
        driverRepository.deleteById(driverId);
    }

    @Override
    public DriverResponseDTO passwordReset(DriverRequestDTO driverRequestDTO) {
        return null;
    }

    @Override
    public DriverRequestDTO licenseVerification(DriverRequestDTO driverRequestDTO) {
        return null;
    }



}
