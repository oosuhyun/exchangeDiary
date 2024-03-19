package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.Mate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateRepository extends JpaRepository<Mate, Long> {

    //내가 친구 요청한 목록
    Page<Mate> findByRequestMateAndStatus(String userId, String status, Pageable pageable);

    //나에게 친구 요청한 목록
    Page<Mate> findByResponseMateAndStatus(String userId, String status, Pageable pageable);
}
