package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.DiaryReq;
import com.example.exchangeDiary.dto.DiaryRes;
import com.example.exchangeDiary.dto.UserJoinReq;
import com.example.exchangeDiary.entity.Diary;
import com.example.exchangeDiary.service.DiaryService;
import com.example.exchangeDiary.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {

    private final DiaryService diaryService;
    private final PhotoService photoService;

    //일기 생성
    @PostMapping
    public ResponseEntity<Void> create(
            @RequestPart(value = "req") DiaryReq req,
            @RequestPart(value = "file") MultipartFile multipartFile
    ){
        String imgURL = photoService.uploadFile(multipartFile);
        diaryService.create(req, imgURL);
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

    //교환일기 내에 모든 일기 조회
    @GetMapping("/inExDiary")
    public ResponseEntity<Page<DiaryRes>> getByExDiary_ExDiaryId(
            @RequestParam(value = "id") Long id,
            @PageableDefault(sort = {"diaryId"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(diaryService.findByExDiary_ExDiaryId(id, pageable));
    }

    //일기 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        diaryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
