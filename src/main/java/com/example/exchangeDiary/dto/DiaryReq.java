package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Diary;
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
    private Long userId;
    private String writing;
    private String img;

    public Diary toEntity(){
        return Diary.builder()
                .exDiaryId(this.exDiaryId)
                .userId(this.userId)
                .writing(this.writing)
                .img(this.img)
                .build();
    }

}
