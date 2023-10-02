package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.ExDiaryRes;
import com.example.exchangeDiary.dto.TeamMemberReq;
import com.example.exchangeDiary.dto.TeamMemberRes;
import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.entity.TeamMember;
import com.example.exchangeDiary.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    //교환일기 멤버 생성
    public void create(TeamMemberReq req){
        teamMemberRepository.save(req.toEntity());
    }

    //교환일기 멤버 단일조회
    public TeamMemberRes findById(Long id){
        TeamMember teamMember = teamMemberRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return TeamMemberRes.toDTO(teamMember);
    }

    //교환일기 멤버 전체 조회
    public List<TeamMemberRes> findAll(){
        return teamMemberRepository.findAll()
                .stream()
                .map(TeamMemberRes::toDTO)
                .collect(Collectors.toList());
    }

    //같은 교환일기 멤버 조회
    public List<TeamMemberRes> findByExDiaryId(Long id){
        return teamMemberRepository.findByExDiaryId(id)
                .stream()
                .map(TeamMemberRes::toDTO)
                .collect(Collectors.toList());
    }

    //내가 포함된 교환일기 전체 조회
    public List<Long> findByMemberName(String name){
        return teamMemberRepository.findByMemberName(name)
                .stream()
                .map(TeamMember::getExDiaryId)
                .collect(Collectors.toList());
    }

    //멤버 탈퇴
    public void deleteById(Long id){
        TeamMember teamMember = teamMemberRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        TeamMemberRes teamMemberRes = TeamMemberRes.toDTO(teamMember);
        teamMemberRes.setStatus('F'); //멤버 상태 F(false) 변경
    }

}
