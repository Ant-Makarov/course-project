package com.fintech.courseproject.service;

import com.fintech.courseproject.entity.Parcel;
import com.fintech.courseproject.repository.ParcelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Slf4j
public class ParcelService {
    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private NotificationService notificationService;

    public void saveParcel(Parcel parcel) {
        parcel.setCreationDate(new Timestamp(System.currentTimeMillis()));
        parcel.setSendStatus("Not delivered");
        parcelRepository.save(parcel);
        log.info("Parcel has been created successfully: " + parcel);
    }


    public void takeParcel(Parcel p) {
        Parcel parcel = parcelRepository.getById(p.getParcelSendID());
        if(checkStatus(parcel)) {
            parcel.setChangeDate(new Timestamp(System.currentTimeMillis()));
            parcel.setSendStatus("Delivered");
            parcelRepository.save(parcel);
            log.info("Parcel: " + "Has been successfully delivered!");
        } else {
            log.error("We are sorry but the parcel: " + p + "was overdue :(");
        }
    }

    public boolean checkStatus(Parcel p) {
        boolean isNotExpired = true;
        if (p.getSendStatus().equals("Expired")) isNotExpired = false;
        return isNotExpired;
    }
}
