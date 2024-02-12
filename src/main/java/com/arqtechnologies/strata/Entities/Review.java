package com.arqtechnologies.strata.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reviewId;
    @Column
    Integer rideId;
    @Column
    Float rating;
    @Column
    String comment;
    @Column
    String reviewedBy;

}
