package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DiaryRepository extends JpaRepository<Diary, Long>{

    Page<Diary> findByExDiary_ExDiaryId(Long id, Pageable pageable);

}
