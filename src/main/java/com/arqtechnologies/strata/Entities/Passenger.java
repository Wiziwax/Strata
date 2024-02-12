package com.arqtechnologies.strata.Entities;

import com.arqtechnologies.strata.Enums.EnumPaymentMethod;
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
//@RequiredArgsConstructor
public class Passenger extends User{

    @OneToOne
    @JoinColumn(name = "user_id") // This is the foreign key column name
    private User passengerId;
    @Column
    private EnumPaymentMethod paymentMethod;

}
