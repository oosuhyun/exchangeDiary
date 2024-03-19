package com.example.exchangeDiary.repository;


import com.example.exchangeDiary.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByDiaryId(Long id, Pageable pageable);

}
