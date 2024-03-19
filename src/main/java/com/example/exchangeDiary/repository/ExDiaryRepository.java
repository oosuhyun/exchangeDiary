package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.ExDiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExDiaryRepository extends JpaRepository<ExDiary, Long> {

}
