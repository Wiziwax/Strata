package com.arqtechnologies.strata.Entities;

import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends User{

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id") // This is the foreign key column name
    private User passengerId;
    @Column
    private EnumPaymentMethod paymentMethod;

}
