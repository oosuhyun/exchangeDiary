package com.example.exchangeDiary.controller;

import javax.servlet.http.HttpSession;

import com.example.exchangeDiary.service.PhotoService;
import com.example.exchangeDiary.service.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.exchangeDiary.dto.*;
//import com.example.exchangeDiary.serviceImpl.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PhotoService photoService;


    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<Void> registerUser(
            @RequestPart(value = "req") UserJoinReq req,
            @RequestPart(value = "file") MultipartFile multipartFile
    ) {
        if(userService.checkUserIdDuplicate(req.getUserId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        String imgURL = photoService.uploadFile(multipartFile);
        userService.join(req, imgURL);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> loginCheck(@RequestBody UserLoginReq req) {
        if(!userService.login(req)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }

    //로그인 사용자 정보 확인
    @GetMapping("/info")
    public ResponseEntity<UserRes> getByMemberId(@RequestParam String id){
        return ResponseEntity
                .ok(userService.info(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<UserRes>> getAll(
            @PageableDefault(size = 20, sort = {"createdDate"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ){
        return ResponseEntity
                .ok(userService.findAll(pageable));
    }


//    @Autowired
//    private final UserServiceImpl userService;
//
//    // 로그인
//    @PostMapping("/login")
//    public ResponseEntity<UserInfoDto> loginCheck(@RequestBody UserInfoDto dto) {
//        System.out.println("UserController - loginCheck");
//        UserInfoDto userInfoDto = userService.loginCheck(dto);
////        System.out.println(userInfo.getUserId() + "  login");
//        if (userInfoDto.getUserId() == null) { // 로그인 실패 시
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
//    }
//
//    // 회원 가입
//    @PostMapping("/signup")
//    public ResponseEntity<Void> registerUser(@RequestBody UserSignupReqDto dto) {
//        System.out.println("UserController - registerUser");
//        userService.registerUser(dto);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//
//    }
}