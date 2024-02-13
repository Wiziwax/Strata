package com.arqtechnologies.strata.Entities;

import com.arqtechnologies.strata.Enums.EnumRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phoneNumber;
    @Column
    private String phoneNumber2;
    @Column
    private EnumRole userRole;
    @Column
    @CreatedBy
    private String createdBy;
    @Column
    @CreatedDate
    private Date createdDate;

}
