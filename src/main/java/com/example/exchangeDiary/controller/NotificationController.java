package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.NotificationReq;
import com.example.exchangeDiary.dto.NotificationRes;
import com.example.exchangeDiary.entity.Notification;
import com.example.exchangeDiary.service.NotificationService;
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
@RequestMapping("/api/notice")
public class NotificationController {

    private final NotificationService notificationService;

    //알림 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NotificationReq req){
        notificationService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //알림 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<NotificationRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(notificationService.findById(id));
    }

    //내가 받은 알림 타입별 조회
    @GetMapping("/get/type")
    public ResponseEntity<Page<Notification>> getByGetUserIdAndNoticeType(
            String id,
            String type,
            @PageableDefault(size = 5, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(notificationService.findByGetUserIdAndNoticeType(id, type, pageable));
    }

    //알림 전체 조회
    @GetMapping("/get/all")
    public ResponseEntity<Page<Notification>> getAll(
            @PageableDefault(size = 10, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(notificationService.findAll(pageable));
    }

    //알림 단일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        notificationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //알림 전체 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        notificationService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
