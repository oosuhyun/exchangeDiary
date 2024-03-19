package com.example.exchangeDiary.dto;

import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.entity.Post;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class PostRes {

    private Long postId;
    private String senderId;
    private String receiverId;
    private String postContent;
    private LocalDateTime sendTime;
    private LocalDateTime getTime;
    private ExDiary exDiary;

    public static PostRes toDTO(Post post){
        return PostRes.builder()
                .postId(post.getPostId())
                .senderId(post.getSenderId())
                .receiverId(post.getReceiverId())
                .postContent(post.getPostContent())
                .sendTime(post.getSendTime())
                .getTime(post.getGetTime())
                .exDiary(post.getExDiary())
                .build();
    }

}
