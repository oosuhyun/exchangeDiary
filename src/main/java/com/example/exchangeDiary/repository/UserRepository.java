package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //로그인
    Boolean existsByUserIdAndUserPw(String id, String pw);

    //아이디 중복체크
    Boolean existsByUserId(String id);

    //유저 목록
    Page<User> findAll(Pageable pageable);
}
