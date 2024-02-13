package com.arqtechnologies.strata.DTOs;

import com.arqtechnologies.strata.Enums.EnumRole;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DriverResponseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String phoneNumber2;

    private String licenseNumber;
    private String carModel;
    private String carColour;
    private String carPlateNumber;
    private Integer carCapacity;
    private Boolean isAvailable;
    private Long trips;
    private Float averageRating;

    private Date createdDate;
    private EnumRole userRole;
}
