package com.arqtechnologies.strata.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.Where;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Where(clause = "available=true")
public class Driver extends User{

    @OneToOne
    @JoinColumn(name = "user_id") // This is the foreign key column name
    @JsonIgnore
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
    @Column(name = "available")
    private Boolean isAvailable;
    @Column
    private Integer trips;
    @Column
    private Double averageRating;
    @Getter
    private String carType;

}
