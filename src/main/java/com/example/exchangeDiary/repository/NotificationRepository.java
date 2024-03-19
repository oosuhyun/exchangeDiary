package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    //내가 받은 알림 타입별 조회
    Page<Notification> findByGetUserIdAndNoticeType(String id, String type, Pageable pageable);

    //알림 전체 조회
    Page<Notification> findAll(Pageable pageable);


}