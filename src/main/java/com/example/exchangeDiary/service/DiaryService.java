package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.DiaryReq;
import com.example.exchangeDiary.dto.DiaryRes;
import com.example.exchangeDiary.entity.Diary;
import com.example.exchangeDiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    //일기 생성
    public void create(DiaryReq req){
        diaryRepository.save(req.toEntity());
    }

    //일기 단일조회
    public DiaryRes findById(Long id){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return DiaryRes.toDTO(diary);
    }

    //한 교환일기 내에 모든 일기 조회
    public List<Diary> findByExDiaryId(Long id){
        return diaryRepository.findByExDiaryId(id);
    }

    //일기 삭제
    public void deleteById(Long id){
        diaryRepository.deleteById(id);
    }
}
