package com.example.exchangeDiary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExDiary extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long exDiaryId;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private String exDiaryName;
    private String createMemberName;

//    @OneToMany(mappedBy = "exDiary")
//    private List<ExDiary_Member> exDiary_members = new ArrayList<>();

}
