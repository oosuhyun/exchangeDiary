package com.example.exchangeDiary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long commentId;
    private Long diaryId;
    private String writer;
    private String content;




}
