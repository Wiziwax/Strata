package com.arqtechnologies.strata.DTOs.UserDTOs;

import com.arqtechnologies.strata.Entities.User;
import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassengerResponseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String phoneNumber2;
    private EnumPaymentMethod paymentMethod;
}
