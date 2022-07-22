package com.sparta.week02_homework.service;

import com.sparta.week02_homework.Domain.Friend;
import com.sparta.week02_homework.Domain.FriendRepository;
import com.sparta.week02_homework.Domain.FriendRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class FriendService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final FriendRepository friendRepository;


    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, FriendRequestDto requestDto) {
        Friend friend1 = friendRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        friend1.update( requestDto );
        return friend1.getId();
    }
}