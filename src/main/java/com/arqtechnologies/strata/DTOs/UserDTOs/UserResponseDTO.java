package com.arqtechnologies.strata.DTOs.UserDTOs;

import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import com.arqtechnologies.strata.Enums.EnumRole;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
//@NoArgsConstructor
//@RequiredArgsConstructor
public class UserResponseDTO {

    public String firstName;
    public String lastName;
//    private String email;
//    private String password;
    public String phoneNumber;
    public String phoneNumber2;
    public EnumRole userRole;
    public Date createdDate;
}
