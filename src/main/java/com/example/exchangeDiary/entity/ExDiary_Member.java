//package com.example.exchangeDiary.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Builder
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class ExDiary_Member {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "memberId")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "exDiaryId")
//    private ExDiary exDiary;
//
//}
