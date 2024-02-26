package com.arqtechnologies.strata.DTOs.UserDTOs;

import lombok.Data;

@Data
public class LocationRequest {

    Integer userId;
    Double longitude;
    Double latitude;
}
