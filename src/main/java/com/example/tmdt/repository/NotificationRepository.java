package com.example.tmdt.repository;

import com.example.tmdt.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findNotificationByAccount_Id(Long id);
    List<Notification> findNotificationByShop_Id(Long id);
}
