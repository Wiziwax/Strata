package com.arqtechnologies.strata.Entities;

import com.arqtechnologies.strata.Enums.EnumPaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "payment")
@NoArgsConstructor
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer paymentId;
    @Column
    Integer rideId;
    @Column
    BigDecimal amount;
    @Column
    String createdBy;
    @Column
    Date createdDate;
    @Column
    EnumPaymentStatus paymentStatus;
    @Column
    Date transactionDate;
}
