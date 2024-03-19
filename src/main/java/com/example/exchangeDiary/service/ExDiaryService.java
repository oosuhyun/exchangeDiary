package com.example.exchangeDiary.service;

import com.example.exchangeDiary.dto.ExDiaryReq;
import com.example.exchangeDiary.dto.ExDiaryRes;
import com.example.exchangeDiary.entity.ExDiary;
import com.example.exchangeDiary.repository.ExDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class ExDiaryService {

    private final ExDiaryRepository exDiaryRepository;

    //교환일기 생성
    public void create(ExDiaryReq req, String imgURL){
        req.setImg(imgURL);
        exDiaryRepository.save(req.toEntity());
    }

    //교환일기 단일 조회
    public ExDiaryRes findById(Long id){
        ExDiary exDiary = exDiaryRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return ExDiaryRes.toDTO(exDiary);
    }

    //교환일기 삭제
    public void deleteById(Long id){
        exDiaryRepository.deleteById(id);
    }

}
