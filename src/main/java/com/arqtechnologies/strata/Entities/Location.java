package com.arqtechnologies.strata.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "location")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer locationId;
    @Column
    String address;
    @Column
    String driverId;
    @Column
    Double latitude;
    @Column
    Double longitude;
    @Column
    String buildingName;
    @Column
    String landmarkNearBy;

}
