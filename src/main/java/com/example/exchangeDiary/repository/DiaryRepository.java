package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long>{

    List<Diary> findByExDiaryId(Long id);

}
