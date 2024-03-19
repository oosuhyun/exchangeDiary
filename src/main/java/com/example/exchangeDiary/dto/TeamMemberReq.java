package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.entity.TeamMember;
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
public class TeamMemberReq {

    private Long exDiaryId;
    private String userId;

    public TeamMember toEntity(TeamMemberReq req, ExDiary exDiary) {
        return TeamMember.builder()
                .userId(req.userId)
                .status("T")
                .exDiary(exDiary)
                .build();
    }

}
