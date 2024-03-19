package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Diary;
import com.example.exchangeDiary.entity.ExDiary;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class DiaryRes {

    private Long diaryId;
    private String userId;
    private String writing;
    private String img;
    private String weather;
    private String place;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private ExDiary exDiary;

    public static DiaryRes toDTO(Diary diary){
        return DiaryRes.builder()
                .diaryId(diary.getDiaryId())
                .userId(diary.getUserId())
                .writing(diary.getWriting())
                .img(diary.getImg())
                .weather(diary.getWeather())
                .place(diary.getPlace())
                .createdDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .exDiary(diary.getExDiary())
                .build();
    }

}
