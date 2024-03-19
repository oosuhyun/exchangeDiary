package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.ExDiary;
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
public class ExDiaryReq {

    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private String exDiaryName;
    private String createUserId;
    private String img;
    private String backgroundColor;

    public ExDiary toEntity() {
        return ExDiary.builder()
                .startDate(this.startDate)
                .finishDate(this.finishDate)
                .exDiaryName(this.exDiaryName)
                .createUserId(this.createUserId)
                .img(this.img)
                .backgroundColor(this.backgroundColor)
                .build();
    }

}
