package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Notification;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class NotificationRes {

    private Long noticeId;     //알림 번호
    private String getUserId;   //알림 받는 사람
    private String sendUserId;  //알림 보내는 사람
    private String noticeType;  //알림 종류
    private Long exDiaryId;  //알림 온 모임
    private String content;     //알림 내용
    private LocalDateTime createdDate; //생성 날짜
    private LocalDateTime modifiedDate; //마지막 수정 날짜

    public static NotificationRes toDTO(Notification notification) {
        return NotificationRes.builder()
                .noticeId(notification.getNoticeId())
                .getUserId(notification.getGetUserId())
                .sendUserId(notification.getSendUserId())
                .noticeType(notification.getNoticeType())
                .exDiaryId(notification.getExDiaryId())
                .content(notification.getContent())
                .createdDate(notification.getCreatedDate())
                .modifiedDate(notification.getModifiedDate())
                .build();
    }

}
