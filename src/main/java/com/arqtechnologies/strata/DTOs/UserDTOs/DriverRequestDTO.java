package com.arqtechnologies.strata.DTOs.UserDTOs;


import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class DriverRequestDTO {

    private Integer driverId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String phoneNumber2;

    @NonNull
    private String idType;
    @NonNull
    private String licenseNumber;
    @NonNull
    private String carModel;
    @NonNull
    private String carColour;
    @NonNull
    private String carPlateNumber;
    @NonNull
    private String carType;
    @NonNull
    private Integer carCapacity;

}
