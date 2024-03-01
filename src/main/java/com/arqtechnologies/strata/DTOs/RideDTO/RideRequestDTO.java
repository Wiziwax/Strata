package com.arqtechnologies.strata.DTOs.RideDTO;

import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import com.arqtechnologies.strata.Enums.EnumStatus;
import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RideRequestDTO {

    Integer rideId;
    Integer passengerId;
    String carType;
    Double startLongitude;
    Double startLatitude;
    Double endLongitude;
    Double endLatitude;
    Date startTime;
    Date endTime;
    Double rating;
    EnumPaymentMethod paymentMethod;
    String additionalNotes;
    String destinationAddress;
    String originAddress;//TODO comes from device's location
    String landmarkNearby;
}
