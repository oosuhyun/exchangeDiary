package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.dto.ExDiaryRes;
import com.example.exchangeDiary.entity.ExDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExDiaryRepository extends JpaRepository<ExDiary, Long> {
//    List<ExDiary> findAll(List<Long> id);

    @Query("select e from ExDiary e where  e.exDiaryId in :id")
    List<ExDiary> findByExDiaryId(@Param("id") List<Long> id);

}
