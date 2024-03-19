package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Comment;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class CommentRes {

    private Long commentId;
    private Long diaryId;
    private String writerId;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static CommentRes toDTO(Comment comment){
        return CommentRes.builder()
                .commentId(comment.getCommentId())
                .diaryId(comment.getDiaryId())
                .writerId(comment.getWriterId())
                .content(comment.getContent())
                .createdDate(comment.getCreatedDate())
                .modifiedDate(comment.getModifiedDate())
                .build();
    }

}
