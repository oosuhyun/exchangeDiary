package com.example.exchangeDiary.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long teamMemberId;
    private String userId;
    private String status;  //탈퇴했으면 F

    @ManyToOne
    @JoinColumn(name = "exDiaryId")
    private ExDiary exDiary;

}
