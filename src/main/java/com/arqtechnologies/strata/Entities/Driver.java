package com.arqtechnologies.strata.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User{

    @OneToOne
    @JoinColumn(name = "user_id") // This is the foreign key column name
    private User driverId;
    @Column
    private String licenseNumber;
    @Column
    private String carModel;
    @Column
    private String idType;
    @Column
    private String carColour;
    @Column
    private String carPlateNumber;
    @Column
    private Integer carCapacity;
    @Column
    private Boolean isAvailable;
    @Column
    private Integer trips;
    @Column
    private Double averageRating;
    @Getter
    private String carType;

}
