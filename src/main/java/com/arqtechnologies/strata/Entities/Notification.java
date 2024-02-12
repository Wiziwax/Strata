package com.arqtechnologies.strata.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer notificationId;
    @Column
    Integer userId;
    @Column
    String message;
    @Column
    Date createdDate;
    @Column
    Boolean isRead;
    @Column
    Boolean isSent;
    @Column
    Boolean isDelivered;
}
