package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.TeamMember;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class TeamMemberRes {

    private Long memberId;
    private Long exDiaryId;
    private String memberName;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Character status;

    public static TeamMemberRes toDTO(TeamMember teamMember){
        return TeamMemberRes.builder()
                .memberId(teamMember.getMemberId())
                .exDiaryId(teamMember.getExDiaryId())
                .memberName(teamMember.getMemberName())
                .createdDate(teamMember.getCreatedDate())
                .modifiedDate(teamMember.getModifiedDate())
                .status(teamMember.getStatus())
                .build();
    }

}
