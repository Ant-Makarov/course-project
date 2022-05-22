package com.fintech.courseproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@lombok.Data
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "phonenumber")
    private String phoneNumber;
}
