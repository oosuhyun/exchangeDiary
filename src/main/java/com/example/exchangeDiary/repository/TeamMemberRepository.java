package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    //같은 교환일기 멤버 조회
    List<TeamMember> findByExDiaryId(Long id);

    //내가 포함된 교환일기 전체 조회
    List<TeamMember> findByMemberName(String name);


}
