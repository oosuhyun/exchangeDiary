package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.PostReq;
import com.example.exchangeDiary.dto.PostRes;
import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.entity.Post;
import com.example.exchangeDiary.repository.ExDiaryRepository;
import com.example.exchangeDiary.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ExDiaryRepository exDiaryRepository;

    //우편 생성
    public void create(PostReq req){
        ExDiary exDiary = exDiaryRepository.findById(req.getExDiaryId())
                .orElseThrow(EntityExistsException::new);
        postRepository.save(req.toEntity(req, exDiary));
    }

    //우편 단일 조회
    public PostRes findById(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return PostRes.toDTO(post);
    }

    //내가 받은 우편 모두 조회
    public Page<PostRes> findByReceiverId(String id, Pageable pageable){
        return postRepository.findByReceiverIdAndGetTimeBefore(id, LocalDateTime.now(), pageable)
                .map(PostRes::toDTO);
    }

    //내가 보낸 편지 모두 조회
    public Page<PostRes> findBySenderId(String id, Pageable pageable) {
        return postRepository.findBySenderId(id, pageable)
                .map(PostRes::toDTO);
    }

    //우편 삭제
    public void delete(Long id){
        postRepository.deleteById(id);
    }

}
