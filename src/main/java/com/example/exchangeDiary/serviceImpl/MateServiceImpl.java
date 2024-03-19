//package com.example.exchangeDiary.serviceImpl;
//
//import java.util.List;
//
//import jakarta.inject.Inject;
//import org.springframework.stereotype.Service;
//
//import com.example.exchangeDiary.dao.MateDao;
//import com.example.exchangeDiary.dto.*;
//import com.example.exchangeDiary.service.MateService;
//
//@Service
//public class MateServiceImpl implements MateService {
//
//    @Inject
//    private final MateDao mateDao;
//
//    public MateServiceImpl(MateDao mateDao) {
//        this.mateDao = mateDao;
//    }
//
//    public List<MateInfoDto> getMateList(String userId) {
//        return mateDao.getMateList(userId);
//    }
//
//    public int requestMate(reqMateDto reqInfo) {
//        MateDto mate = mateDao.isAlreadyMate(reqInfo);
//        if (mate == null) {						// 친구 요청 가능
//            return mateDao.requestMate(reqInfo);
//        } else if (mate.getStatus() == "y") {	// 이미 친구인 상태
//            return 2;
//        } else if (mate.getStatus() == "n") {	// 이미 요청중인 상태
//            return 3;
//        } else {
//            return 0;
//        }
//    }
//
//    public int responseMate(reqMateDto reqInfo) {
//        return mateDao.responseMate(reqInfo);
//    }
//
//    public int deleteMate(reqMateDto reqInfo) {
//        return mateDao.deleteMate(reqInfo);
//    }
//}