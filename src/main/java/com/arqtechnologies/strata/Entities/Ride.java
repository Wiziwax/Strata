package com.arqtechnologies.strata.Entities;

import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import com.arqtechnologies.strata.Enums.EnumStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

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
    Integer creatorRole;
    @Column
    Integer passengerId;
    @Column
    String passengerName;
    @Column
    String carType;
    @Column
    Integer driverId;
    @Column
    String driverName;
    @Column
    String startLocationName;
    @Column
    String endLocationName;
    @Column
    Double startLongitude;
    @Column
    Double startLatitude;
    @Column
    Double endLongitude;
    @Column
    Double endLatitude;
    @Column
    EnumStatus bookingStatus;
    @Column
    Date startTime;
    @Column
    Date endTime;
    @Column
    BigDecimal transportFare;
    @Column
    Double rating;
    @Column
    EnumPaymentMethod paymentMethod;
    @Column
    @CreatedDate
    Date createdDate;
    @Column
    String additionalNotes;
    @Column
    String reviews;
    @Column
    String originAddress;
    @Column
    String destinationAddress;
    @Column
    String buildingName;
    @Column
    String landmarkNearby;
    @Column
    Integer estimatedDistance;
    @Column
    Integer ETA;
    @Column
    String travelPath;

    @OneToMany
    Set<Driver> driversInPath;
}
