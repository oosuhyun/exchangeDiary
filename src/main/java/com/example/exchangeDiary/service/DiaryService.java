package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.DiaryReq;
import com.example.exchangeDiary.dto.DiaryRes;
import com.example.exchangeDiary.entity.Diary;
import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.repository.DiaryRepository;
import com.example.exchangeDiary.repository.ExDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final ExDiaryRepository exDiaryRepository;

    //일기 생성
    public void create(DiaryReq req, String imgURL){
        req.setImg(imgURL);
        ExDiary exDiary = exDiaryRepository.findById(req.getExDiaryId())
                .orElseThrow(EntityExistsException::new);
        diaryRepository.save(req.toEntity(req, exDiary));
    }

    //일기 단일조회
    public DiaryRes findById(Long id){
        Diary diary = diaryRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return DiaryRes.toDTO(diary);
    }

    //교환일기 내에 모든 일기 조회
    public Page<DiaryRes> findByExDiary_ExDiaryId(Long id, Pageable pageable){
        return diaryRepository.findByExDiary_ExDiaryId(id, pageable)
                .map(DiaryRes::toDTO);
    }

    //일기 삭제
    public void deleteById(Long id){
        diaryRepository.deleteById(id);
    }

}
