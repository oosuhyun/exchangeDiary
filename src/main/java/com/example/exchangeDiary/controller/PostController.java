package com.example.exchangeDiary.controller;

import com.example.exchangeDiary.dto.PostReq;
import com.example.exchangeDiary.dto.PostRes;
import com.example.exchangeDiary.service.PostService;
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
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    //우편 생성
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PostReq req){
        postService.create(req);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    //우편 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostRes> getById(@PathVariable Long id){
        return ResponseEntity
                .ok(postService.findById(id));
    }

    //내가 받은 우편 모두 조회
    @GetMapping("/receive")
    public ResponseEntity<Page<PostRes>> getByReceiverName(
        @RequestParam("id") String id,
        @PageableDefault(sort = {"getTime"}, direction = Sort.Direction.DESC)
        Pageable pageable
    ){
        return ResponseEntity
                .ok(postService.findByReceiverId(id, pageable));
    }

    //내가 보낸 우편 모두 조회
    @GetMapping("/send")
    public ResponseEntity<Page<PostRes>> getBySenderName(
            @RequestParam("id") String id,
            @PageableDefault(sort = {"sendTime"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(postService.findBySenderId(id, pageable));
    }

    //우편 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
