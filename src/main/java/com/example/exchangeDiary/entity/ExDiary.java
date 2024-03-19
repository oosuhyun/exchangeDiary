package com.example.exchangeDiary.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExDiary extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exDiaryId;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private String exDiaryName;
    private String createUserId;
    private String img;
    private String backgroundColor;

}
