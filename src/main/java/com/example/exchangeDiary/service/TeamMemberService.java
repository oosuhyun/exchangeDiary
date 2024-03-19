package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.TeamMemberReq;
import com.example.exchangeDiary.dto.TeamMemberRes;
import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.entity.TeamMember;
import com.example.exchangeDiary.repository.ExDiaryRepository;
import com.example.exchangeDiary.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;
    private final ExDiaryRepository exDiaryRepository;

    //팀원 생성
    public void create(TeamMemberReq req){
        ExDiary exDiary = exDiaryRepository.findById(req.getExDiaryId())
                .orElseThrow(EntityExistsException::new);
        teamMemberRepository.save(req.toEntity(req, exDiary));
    }

    //팀원 단일 조회
    public TeamMemberRes findById(Long id){
        TeamMember teamMember = teamMemberRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return TeamMemberRes.toDTO(teamMember);
    }

    //교환일기 팀원 조회
    public Page<TeamMemberRes> findByExDiary_ExDiaryIdAndStatus(Long id, Pageable pageable){
        return teamMemberRepository.findByExDiary_ExDiaryIdAndStatus(id, "T", pageable)
                .map(TeamMemberRes::toDTO);
    }

    //내 교환일기 조회
    public Page<TeamMemberRes> findByUserIdAndStatus(String id, Pageable pageable){
        return teamMemberRepository.findByUserIdAndStatus(id, "T", pageable)
                .map(TeamMemberRes::toDTO);
    }

    //팀원 탈퇴
    public void deleteById(Long id){
        TeamMember teamMember = teamMemberRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        teamMember.setStatus("F"); //멤버 상태 F(false) 변경
        teamMemberRepository.save(teamMember);
    }

}
