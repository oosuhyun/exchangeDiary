package com.example.exchangeDiary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Diary extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;
    private String userId;
    private String writing;
    private String img;
    private String weather;
    private String place;

    @ManyToOne
    @JoinColumn(name = "exDiaryId")
    private ExDiary exDiary;

}
