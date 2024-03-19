package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Long> {

    //내가 받은 편지 모두 조회
    Page<Post> findByReceiverIdAndGetTimeBefore(String id, LocalDateTime now, Pageable pageable);

    //내가 보낸 편지 모두 조회
    Page<Post> findBySenderId(String id, Pageable pageable);

}
