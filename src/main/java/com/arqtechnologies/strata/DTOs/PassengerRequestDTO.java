package com.arqtechnologies.strata.DTOs;

import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String phoneNumber2;
}
