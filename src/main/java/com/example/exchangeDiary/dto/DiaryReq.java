package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Diary;
import com.example.exchangeDiary.entity.ExDiary;
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
public class DiaryReq {

    private Long exDiaryId;
    private String userId;
    private String writing;
    private String img;
    private String weather;
    private String place;

    public Diary toEntity(DiaryReq req, ExDiary exDiary){
        return Diary.builder()
                .userId(req.userId)
                .writing(req.writing)
                .img(req.img)
                .weather(req.weather)
                .place(req.place)
                .exDiary(exDiary)
                .build();
    }

}
