package com.fintech.courseproject.repository;

import com.fintech.courseproject.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
