package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.DiaryReq;
import com.example.exchangeDiary.dto.DiaryRes;
import com.example.exchangeDiary.entity.Diary;
import com.example.exchangeDiary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {

    private final DiaryService diaryService;

    //일기 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DiaryReq req){
        diaryService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //일기 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<DiaryRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(diaryService.findById(id));
    }

    //교환일기 내 모든 일기 조회
    @GetMapping("/in/exdiary")
    public ResponseEntity<List<Diary>> getByExDiaryId(
            @RequestParam(value = "id") Long id
    ){
        return ResponseEntity
                .ok(diaryService.findByExDiaryId(id));
    }

    //일기 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        diaryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
