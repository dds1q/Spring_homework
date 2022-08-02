package com.sparta.hanghae_assignment_week04.service;

import com.sparta.hanghae_assignment_week04.model.Users;
import com.sparta.hanghae_assignment_week04.repository.UserRepository;
import com.sparta.hanghae_assignment_week04.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Users getUserInfo(String username ) {
        return userRepository.findByUsername( username )
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public Users getMyInfo() {
        return userRepository.findByUsername( SecurityUtil.getCurrentUserId() )
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }
}
