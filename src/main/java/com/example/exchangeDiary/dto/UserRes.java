package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.User;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class UserRes {

    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userPhone;
    private String userEmail;
    private String isAd;
    private String status;
    private String img;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static UserRes toDTO(User user){
        return UserRes.builder()
                .userId(user.getUserId())
                .userPw(user.getUserPw())
                .userName(user.getUserName())
                .userBirth(user.getUserBirth())
                .userPhone(user.getUserPhone())
                .userEmail(user.getUserEmail())
                .isAd(user.getIsAd())
                .status(user.getStatus())
                .img(user.getImg())
                .createdDate(user.getCreatedDate())
                .modifiedDate(user.getModifiedDate())
                .build();
    }

}
