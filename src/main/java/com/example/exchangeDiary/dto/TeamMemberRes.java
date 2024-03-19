package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.ExDiary;
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

    private Long teamMemberId;
    private String userId;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private ExDiary exDiary;

    public static TeamMemberRes toDTO(TeamMember teamMember){
        return TeamMemberRes.builder()
                .teamMemberId(teamMember.getTeamMemberId())
                .userId(teamMember.getUserId())
                .status(teamMember.getStatus())
                .createdDate(teamMember.getCreatedDate())
                .modifiedDate(teamMember.getModifiedDate())
                .exDiary(teamMember.getExDiary())
                .build();
    }

}
