package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.TeamMemberReq;
import com.example.exchangeDiary.dto.TeamMemberRes;
import com.example.exchangeDiary.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    //팀원 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TeamMemberReq req){
        teamMemberService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //팀원 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(teamMemberService.findById(id));
    }

    //교환일기 팀원 조회
    @GetMapping("/inExDiary")
    public ResponseEntity<Page<TeamMemberRes>> getByExDiary_ExDiaryIdAAndStatus(
            @RequestParam(value= "id") Long id,
            @PageableDefault(sort = {"teamMemberId"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(teamMemberService.findByExDiary_ExDiaryIdAndStatus(id, pageable));
    }

    //내 교환일기 조회
    @GetMapping("/myExDiary")
    public ResponseEntity<Page<TeamMemberRes>> getByUserIdAndStatus(
            @RequestParam(value= "id") String id,
            @PageableDefault(sort = {"teamMemberId"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(teamMemberService.findByUserIdAndStatus(id, pageable));
    }

    //팀원 탈퇴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        teamMemberService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
