package com.example.exchangeDiary.dao;

import jakarta.inject.Inject;
import org.apache.ibatis.session.SqlSession;

import com.example.exchangeDiary.dto.UserInfoDto;
import com.example.exchangeDiary.dto.UserSignupReqDto;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Inject
    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserInfoDto loginCheck(UserInfoDto dto) {
        return sqlSession.selectOne("user.loginCheck", dto);
    }

    public int registerUser(UserSignupReqDto dto) {
        return sqlSession.insert("user.register", dto);
    }

}