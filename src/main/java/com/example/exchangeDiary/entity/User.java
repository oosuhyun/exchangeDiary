package com.example.exchangeDiary.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity{

    @Id
    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String isAd;
    private String status;
    private String img;
}
