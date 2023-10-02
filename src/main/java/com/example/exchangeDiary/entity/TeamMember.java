package com.example.exchangeDiary.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamMember extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long memberId;
    private Long exDiaryId;
    private String memberName;
    private Character status;  //탈퇴했으면 F

//    @OneToMany(mappedBy = "member")
//    private List<ExDiary_Member> exDiary_members = new ArrayList<>();


}
