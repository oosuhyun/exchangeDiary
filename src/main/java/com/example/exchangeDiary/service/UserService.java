package com.example.exchangeDiary.service;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpSession;

import com.example.exchangeDiary.dto.*;
import com.example.exchangeDiary.entity.Friendship;
import com.example.exchangeDiary.entity.User;
import com.example.exchangeDiary.repository.FriendshipRepository;
import com.example.exchangeDiary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//public interface UserService {
//
//    public UserInfoDto loginCheck(UserInfoDto dto);
//
//    public int registerUser(UserSignupReqDto dto);
//
//}

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    //회원가입
    public void join(UserJoinReq req, String imgURL){
        req.setImg(imgURL);
        userRepository.save(req.toEntity());

        //친구목록 엔티티도 생성해준다.
        Friendship friendshipFrom = Friendship.builder()
                .userId(req.getUserId())
                .build();
        friendshipRepository.save(friendshipFrom);
    }

    //회원가입 중복체크
    public boolean checkUserIdDuplicate(String id){
        return userRepository.existsByUserId(id);
    }

    //로그인
    public boolean login(UserLoginReq req){
        return userRepository.existsByUserIdAndUserPw(req.getUserId(), req.getUserPw());
    }

    //내정보확인
    public UserRes info(String id){
        User user = userRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        return UserRes.toDTO(user);
    }

    //상품 후기 조회
    public Page<UserRes> findAll(Pageable pageable){
        return userRepository.findAll(pageable)
                .map(UserRes::toDTO);
    }

}