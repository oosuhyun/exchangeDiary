package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CommentReq {

    private Long diaryId;
    private String writer;
    private String content;

    public Comment toEntity(){
        return Comment.builder()
                .diaryId(this.diaryId)
                .writer(this.writer)
                .content(this.content)
                .build();
    }

}
