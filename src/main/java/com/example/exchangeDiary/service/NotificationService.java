package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.NotificationReq;
import com.example.exchangeDiary.dto.NotificationRes;
import com.example.exchangeDiary.entity.Notification;
import com.example.exchangeDiary.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    //알림 생성
    public void create(NotificationReq req){
        notificationRepository.save(req.toEntity());
    }

    //알림 단일 조회
    public NotificationRes findById(Long id){
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return NotificationRes.toDTO(notification);
    }

    //내가 받은 알림 타입별 조회
    public Page<Notification> findByGetUserIdAndNoticeType(String name, String type, Pageable pageable){
        return notificationRepository.findByGetUserIdAndNoticeType(name, type, pageable);
    }

    public Page<Notification> findAll(Pageable pageable){
        return notificationRepository.findAll(pageable);
    }

    //알림 단일 삭제
    public void deleteById(Long id){
        notificationRepository.deleteById(id);
    }

    //알림 전체 삭제
    public void deleteAll(){
        notificationRepository.deleteAll();
    }

}
