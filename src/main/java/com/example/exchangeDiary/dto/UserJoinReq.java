package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserJoinReq {

    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String isAd;
    private String img;

    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .userPw(this.userPw)
                .userName(this.userName)
                .userBirth(this.userBirth)
                .userPhone(this.userPhone)
                .userEmail(this.userEmail)
                .isAd(this.isAd)
                .status("T")
                .img(this.img)
                .build();
    }

}
