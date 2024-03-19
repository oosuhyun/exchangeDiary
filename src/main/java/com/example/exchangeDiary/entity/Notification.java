package com.example.exchangeDiary.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Notification extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;     //알림 번호
    private String getUserId;   //알림 받는 사람
    private String sendUserId;  //알림 보내는 사람
    private String noticeType;  //알림 종류
    private Long exDiaryId;  //알림 온 모임
    private String content;     //알림 내용

}
