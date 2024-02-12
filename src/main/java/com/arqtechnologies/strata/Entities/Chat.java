package com.arqtechnologies.strata.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer messageId;
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
