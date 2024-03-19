package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.ExDiaryReq;
import com.example.exchangeDiary.dto.ExDiaryRes;
import com.example.exchangeDiary.service.ExDiaryService;
import com.example.exchangeDiary.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ex_diary")
public class ExDiaryController {

    private final ExDiaryService exDiaryService;
    private final PhotoService photoService;

    //교환일기 생성
    @PostMapping
    public ResponseEntity<Void> create(
            @RequestPart(value = "req") ExDiaryReq req,
            @RequestPart(value = "file") MultipartFile multipartFile
    ){
        String imgURL = photoService.uploadFile(multipartFile);
        exDiaryService.create(req, imgURL);
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

    //교환일기 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        exDiaryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
