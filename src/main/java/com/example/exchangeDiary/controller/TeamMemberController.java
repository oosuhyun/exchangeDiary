package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.TeamMemberReq;
import com.example.exchangeDiary.dto.TeamMemberRes;
import com.example.exchangeDiary.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    //교환일기 멤버 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TeamMemberReq req){
        teamMemberService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //교환일기 멤버 단일조회
    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(teamMemberService.findById(id));
    }

    //교환일기 멤버 전체 조회
    @GetMapping
    public ResponseEntity<List<TeamMemberRes>> getBll(){
        return ResponseEntity
                .ok(teamMemberService.findAll());
    }

    //같은 교환일기 멤버 조회
    @GetMapping("/search/team_member")
    public ResponseEntity<List<TeamMemberRes>> getByExDiaryId(
            @RequestParam(value= "exdiary_id") Long id
    ){
        return ResponseEntity
                .ok(teamMemberService.findByExDiaryId(id));
    }

    //내가 포함된 교환일기 전체 조회
    @GetMapping("/search/my_teams")
    public ResponseEntity<List<Long>> getByMemberName(
            @RequestParam(value= "name") String name
    ){
        return ResponseEntity
                .ok(teamMemberService.findByMemberName(name));
    }

    //멤버 탈퇴
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        teamMemberService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
