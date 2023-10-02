package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.CommentReq;
import com.example.exchangeDiary.dto.CommentRes;
import com.example.exchangeDiary.entity.Comment;
import com.example.exchangeDiary.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 생성
    public void create(CommentReq req){
        commentRepository.save(req.toEntity());
    }

    //댓글 단일조회
    public CommentRes findById(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return CommentRes.toDTO(comment);
    }

    //일기 내에 모든 댓글 조회
    public List<Comment> findByDiaryId(Long id){
        return commentRepository.findByDiaryId(id);
    }

    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }

}
