package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.CommentReq;
import com.example.exchangeDiary.dto.CommentRes;
import com.example.exchangeDiary.entity.Comment;
import com.example.exchangeDiary.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CommentReq req){
        commentService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //댓글 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(commentService.findById(id));
    }

    //일기 내 댓글 조회
    @GetMapping("/diary")
    public ResponseEntity<List<Comment>> getByDiaryId(
            @RequestParam(value = "id") Long id
    ){
        return ResponseEntity
                .ok(commentService.findByDiaryId(id));
    }

    //댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
