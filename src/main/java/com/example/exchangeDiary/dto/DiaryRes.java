package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Diary;
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
    private Long exDiaryId;
    private Long userId;
    private String writing;
    private String img;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static DiaryRes toDTO(Diary diary){
        return DiaryRes.builder()
                .diaryId(diary.getDiaryId())
                .exDiaryId(diary.getExDiaryId())
                .userId(diary.getUserId())
                .writing(diary.getWriting())
                .img(diary.getImg())
                .createdDate(diary.getCreatedDate())
                .modifiedDate(diary.getModifiedDate())
                .build();
    }

}
