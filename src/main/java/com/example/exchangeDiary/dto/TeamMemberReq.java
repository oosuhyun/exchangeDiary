package com.example.exchangeDiary.dto;

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
    private String memberName;
    private Character status;

    public TeamMember toEntity() {
        return TeamMember.builder()
                .exDiaryId(this.exDiaryId)
                .memberName(this.memberName)
                .status('T')
                .build();
    }

}
