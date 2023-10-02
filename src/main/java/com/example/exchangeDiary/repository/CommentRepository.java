package com.example.exchangeDiary.repository;


import com.example.exchangeDiary.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByDiaryId(Long id);

}
