package com.arqtechnologies.strata.DTOs.UserDTOs;

import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import com.arqtechnologies.strata.Enums.EnumRole;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String phoneNumber2;
    private EnumRole userRole;
}
