//package com.example.exchangeDiary.serviceImpl;
//
//import javax.servlet.http.HttpSession;
//
//import jakarta.inject.Inject;
//
//import com.example.exchangeDiary.dao.UserDao;
//import com.example.exchangeDiary.dto.UserInfoDto;
//import com.example.exchangeDiary.dto.UserSignupReqDto;
//import com.example.exchangeDiary.service.UserService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Inject
//    private final UserDao userDao;
//
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Override
//    public UserInfoDto loginCheck(UserInfoDto dto) {
//        UserInfoDto userInfo = userDao.loginCheck(dto);
//        String answer = "Success";
//        if (userInfo == null) { // 세션 변수 저장
//            answer = "Failed";
//            userInfo = new UserInfoDto();
//        }
//        return userInfo;
//    }
//
//    @Override
//    public int registerUser(UserSignupReqDto dto) {
//        int result = userDao.registerUser(dto);
//        return result;
//    }
//
//
//}