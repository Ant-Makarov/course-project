package com.fintech.courseproject.service;

import com.fintech.courseproject.entity.Notification;
import com.fintech.courseproject.entity.Parcel;
import com.fintech.courseproject.repository.NotificationRepository;
import com.fintech.courseproject.repository.ParcelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private ParcelRepository parcelRepository;

    @Scheduled(initialDelay = 5*1000, fixedDelay = 2*1000)
    public void createNotification() {
        List<Parcel> parcelList = getNotEmptyParcelList();
        for (Parcel p : parcelList) {
            boolean isNotificationNotExist = notificationRepository.findAll().stream()
                    .noneMatch(n -> n.getId().equals(p.getParcelSendID()));
            if (isNotificationNotExist) {
                Notification notification = notificationRepository.save(Notification.builder()
                        .id(p.getParcelSendID())
                        .status("New")
                        .text("The parcel is not delivered yet")
                        .build());
                log.info("The notification has been created: " + notification);
            }
        }
    }

    @Scheduled(initialDelay = 5*1000, fixedDelay = 2*1000)
    public void updateNotification() {
        List<Parcel> parcelList = getNotEmptyParcelList();
        for (Parcel p : parcelList) {
            String status = p.getSendStatus();
            Notification notification = notificationRepository.getById(p.getParcelSendID());
            if (notification != null) {
                if (status.equals("Expired")) {
                    notification.setText("The parcel: " + p.getParcelSendID() + "was overdue");
                    notification.setStatus("Sent");
                } else if (status.equals("Delivered")) {
                    notification.setText("The parcel: " + p.getParcelSendID() + "has been delivered successfully!");
                    notification.setStatus("Sent");
                } else {
                    notification.setText("The parcel: " + p.getParcelSendID() + "has not been delivered yet!");
                }
            }
        }
    }

    public List<Parcel> getNotEmptyParcelList() {
        List<Parcel> parcelList = parcelRepository.findAll();
        while (parcelList.size() == 0) {
            parcelList = parcelRepository.findAll();
        }
        return parcelList;
    }

}
