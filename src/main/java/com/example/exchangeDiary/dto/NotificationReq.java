package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NotificationReq {

    private String getUserId;   //알림 받는 사람
    private String sendUserId;  //알림 보내는 사람
    private String noticeType;  //알림 종류
    private Long exDiaryId;  //알림 온 모임
    private String content;     //알림 내용

    public Notification toEntity() {
        return Notification.builder()
                .getUserId(this.getUserId)
                .sendUserId(this.sendUserId)
                .noticeType(this.noticeType)
                .exDiaryId(this.exDiaryId)
                .content(this.content)
                .build();
    }

}
