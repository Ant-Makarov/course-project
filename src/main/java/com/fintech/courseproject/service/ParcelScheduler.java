package com.fintech.courseproject.service;

import com.fintech.courseproject.entity.Parcel;
import com.fintech.courseproject.repository.ParcelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Component
@Slf4j
@Transactional
public class ParcelScheduler {

    @Autowired
    private ParcelRepository parcelRepository;

    @Scheduled(initialDelay = 5*1000, fixedDelay = 6*1000)
    public void checkParcelStatus() {
        List<Parcel> list = getNotEmptyParcelList();
        for (Parcel p : list) {
            if (p.getSendStatus().equals("Not delivered")) {
                Long creationTime = p.getCreationDate().getTime();
                Long currentTime = System.currentTimeMillis();
                if (currentTime - creationTime > 30 * 1000) {
                    p.setSendStatus("Expired");
                    p.setChangeDate(new Timestamp(currentTime));
                }
            }
        }
    }

    public List<Parcel> getNotEmptyParcelList() {
        List<Parcel> parcelList = parcelRepository.findAll();
        while(parcelList.size() == 0) {
            parcelList = parcelRepository.findAll();
        }
        return parcelList;
    }
}
