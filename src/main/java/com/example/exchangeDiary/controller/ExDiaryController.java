package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.ExDiaryReq;
import com.example.exchangeDiary.dto.ExDiaryRes;
import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.service.ExDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ex_diary")
public class ExDiaryController {

    private final ExDiaryService exDiaryService;

    //교환일기 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ExDiaryReq req){
        exDiaryService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //교환일기 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<ExDiaryRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(exDiaryService.findById(id));
    }

    //내 교환일기 조회
    @GetMapping("/search")
    public ResponseEntity<List<ExDiary>> getByExDiaryId(
            @RequestParam(value= "id") List<Long> list
    ){
        System.out.println(list);
        return ResponseEntity
                .ok(exDiaryService.findByExDiaryId(list));
    }

    //교환일기 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        exDiaryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
