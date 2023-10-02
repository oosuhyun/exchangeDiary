package com.example.exchangeDiary.dto;

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
public class ExDiaryRes {

    private Long exDiaryId;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String exDiaryName;
    private String createMemberName;

    public static ExDiaryRes toDTO(ExDiary exDiary){
        return ExDiaryRes.builder()
                .exDiaryId(exDiary.getExDiaryId())
                .startDate(exDiary.getStartDate())
                .finishDate(exDiary.getFinishDate())
                .createdDate(exDiary.getCreatedDate())
                .modifiedDate(exDiary.getModifiedDate())
                .exDiaryName(exDiary.getExDiaryName())
                .createMemberName(exDiary.getCreateMemberName())
                .build();
    }

}
