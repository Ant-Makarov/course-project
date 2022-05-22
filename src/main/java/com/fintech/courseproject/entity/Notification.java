package com.fintech.courseproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " notifications")
@lombok.Data
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @Column(name = "sendid")
    private Long id;

    @Column(name = "message")
    private String text;

    @Column(name = "status")
    private String status;
}
