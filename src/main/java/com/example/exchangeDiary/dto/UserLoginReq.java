package com.example.exchangeDiary.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserLoginReq {

    private String userId;
    private String userPw;

}
