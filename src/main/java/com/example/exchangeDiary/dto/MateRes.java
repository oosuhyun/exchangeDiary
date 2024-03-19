package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Mate;
import com.example.exchangeDiary.entity.User;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class MateRes {

    private Long mateId;
    private String requestMate;
    private String responseMate;
    private String status;

    public static MateRes toDTO(Mate mate){
        return MateRes.builder()
                .mateId(mate.getMateId())
                .requestMate(mate.getRequestMate())
                .responseMate(mate.getResponseMate())
                .status(mate.getStatus())
                .build();
    }
}
