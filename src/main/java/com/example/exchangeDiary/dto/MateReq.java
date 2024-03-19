package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Mate;
import com.example.exchangeDiary.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MateReq {

    private String requestMate;
    private String responseMate;

    public Mate toEntity(MateReq req){
        return Mate.builder()
                .requestMate(req.requestMate)
                .responseMate(req.responseMate)
                .status("N")
                .build();
    }

}
