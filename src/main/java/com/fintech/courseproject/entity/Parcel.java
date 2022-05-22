package com.fintech.courseproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "parcel_sendings")
@lombok.Data
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Parcel {

    @Id
    @SequenceGenerator(name = "jpaSequence1", sequenceName = "JPA_SEQUENCE1", allocationSize = 1, initialValue = 30000001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence1")
    @Column(name = "sendid")
    private Long parcelSendID;

    @Column(name = "senderid")
    private String senderID;

    @Column(name = "sender_po_id")
    private Long senderPostOffice;

    @Column(name = "receiver_po_id")
    private Long receiverPostOffice;

    @Column(name = "receiver_fio")
    private String receiverFullName;

    @Column(name = "receiverphone")
    private String receiverPhoneNumber;

    @Column(name = "status")
    private String sendStatus;

    @Column(name = "creation_datetime")
    private Timestamp creationDate;

    @Column(name = "statuschange_datetime")
    private Timestamp changeDate;
}
