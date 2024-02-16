package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.UserDTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.UserDTOs.DriverResponseDTO;

public interface DriverService {

    String createDriver(DriverRequestDTO driverRequestDTO);

    //TODO LOGIN
    DriverResponseDTO getDriverById(Integer driverId);
//    UserResponseDTO updateDriver(DriverRequestDTO driverRequestDTO);
    void deleteDriverAccount(Integer driverId);

    DriverResponseDTO passwordReset(DriverRequestDTO driverRequestDTO);

    DriverRequestDTO licenseVerification(DriverRequestDTO driverRequestDTO);
    //TODO Add License Verification to the RequestBody
}
