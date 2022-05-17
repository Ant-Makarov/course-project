package com.fintech.courseproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
@lombok.Data
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
public class User {

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Id
    @Column(name = "phoneNumber")
    private String phoneNumber;
}
