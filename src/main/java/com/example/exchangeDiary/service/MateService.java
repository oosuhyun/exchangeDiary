package com.example.exchangeDiary.service;

import java.util.List;

import com.example.exchangeDiary.dto.*;
import com.example.exchangeDiary.entity.Friendship;
import com.example.exchangeDiary.entity.Mate;
import com.example.exchangeDiary.entity.User;
import com.example.exchangeDiary.repository.FriendshipRepository;
import com.example.exchangeDiary.repository.MateRepository;
import com.example.exchangeDiary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class MateService {

    private final MateRepository mateRepository;
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    //친구 신청
    public void request(MateReq req){
        mateRepository.save(req.toEntity(req));
    }

    //친구 수락
    public void accept(Long id){
        Mate mate = mateRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
        mate.setStatus("Y");
        mateRepository.save(mate);

        User requestUser = userRepository.findById(mate.getRequestMate())
                .orElseThrow(EntityExistsException::new);
        User responseUser = userRepository.findById(mate.getResponseMate())
                .orElseThrow(EntityExistsException::new);

        Friendship requestFriendship = friendshipRepository.findByUserId(mate.getRequestMate())
                .orElseThrow(EntityExistsException::new);
        Friendship responseFriendship = friendshipRepository.findByUserId(mate.getResponseMate())
                .orElseThrow(EntityExistsException::new);

        requestFriendship.getFriendList().add(responseUser);
        responseFriendship.getFriendList().add((requestUser));

        friendshipRepository.save(requestFriendship);
        friendshipRepository.save(responseFriendship);

    }

    //친구 거절
    public void reject(Long id){
        mateRepository.deleteById(id);
    }

    //친구 삭제

    //친구 목록
    public Friendship friendList(String userId){
        Friendship friendship = friendshipRepository.findByUserId(userId)
                .orElseThrow(EntityExistsException::new);

        return friendship;
    }

    //내가 친구 요청한 목록
    public Page<MateRes> friendRequestList(String userId, Pageable pageable){
        return mateRepository.findByRequestMateAndStatus(userId, "N", pageable)
                .map(MateRes::toDTO);
    }

    //나에게 친구 요청한 목록
    public Page<MateRes> friendResponseList(String userId, Pageable pageable){
        return mateRepository.findByResponseMateAndStatus(userId, "N", pageable)
                .map(MateRes::toDTO);
    }
}


//public interface MateService {
//
//    public List<MateInfoDto> getMateList(String userId);
//
//    public int requestMate(reqMateDto reqInfo);
//
//    public int responseMate(reqMateDto reqInfo);
//
//    public int deleteMate(reqMateDto reqInfo);
//}


