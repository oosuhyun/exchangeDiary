package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.TeamMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    //팀원 조회
    Page<TeamMember> findByExDiary_ExDiaryIdAndStatus(Long id, String status, Pageable pageable);

    List<TeamMember> findByExDiary_ExDiaryId(Long id);


    //내 교환일기 조회
    Page<TeamMember> findByUserIdAndStatus(String id, String status, Pageable pageable);


}
