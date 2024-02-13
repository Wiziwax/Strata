package com.arqtechnologies.strata.Services;

import com.arqtechnologies.strata.DTOs.DriverRequestDTO;
import com.arqtechnologies.strata.DTOs.DriverResponseDTO;

public interface DriverService {

    String createDriver(DriverRequestDTO driverRequestDTO);
    DriverResponseDTO getDriverById(Integer driverId);
}
