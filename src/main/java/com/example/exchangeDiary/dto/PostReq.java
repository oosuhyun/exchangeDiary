package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PostReq {

    private Long exDiaryId;
    private String senderId;
    private String receiverId;
    private String postContent;
    private Integer month;

    public Post toEntity(PostReq req, ExDiary exDiary){
        return Post.builder()
                .senderId(req.senderId)
                .receiverId(req.receiverId)
                .postContent(req.postContent)
                .sendTime(LocalDateTime.now())
                .getTime(LocalDateTime.now().plusMonths(req.month))
                .exDiary(exDiary)
                .build();
    }

}
