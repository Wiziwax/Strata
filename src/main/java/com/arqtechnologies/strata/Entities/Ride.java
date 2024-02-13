package com.arqtechnologies.strata.Entities;

import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import com.arqtechnologies.strata.Enums.EnumStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Table(name = "ride")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer rideId;
    @Column
    Integer passengerId;
    @Column
    Integer driverId;
    @Column
    String startLocation;
    @Column
    String endLocation;
    @Column
    EnumStatus bookingStatus;
    @Column
    LocalDateTime startTime;
    @Column
    LocalDateTime endTime;
    @Column
    EnumPaymentMethod paymentMethod;
}
