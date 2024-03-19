package com.example.exchangeDiary.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String senderId;
    private String receiverId;
    private String postContent;
    private LocalDateTime sendTime;
    private LocalDateTime getTime;

    @ManyToOne
    @JoinColumn(name = "exDiaryId")
    private ExDiary exDiary;

}
