package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.DriverResponseDTO;
import com.arqtechnologies.strata.DTOs.UserResponseDTO;

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
