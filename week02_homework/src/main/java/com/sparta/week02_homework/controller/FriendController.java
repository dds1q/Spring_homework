package com.sparta.week02_homework.controller;

import com.sparta.week02_homework.Domain.Friend;
import com.sparta.week02_homework.Domain.FriendRepository;
import com.sparta.week02_homework.Domain.FriendRequestDto;
import com.sparta.week02_homework.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FriendController {

    private final FriendRepository friendRepository;
    private final FriendService friendService;

    @GetMapping("/api/friends")
    public List<Friend> getFriends() {
        return friendRepository.findAll();
    }


    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/friends")
    public Friend createCourse(@RequestBody FriendRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Friend friend = new Friend(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return friendRepository.save(friend);
    }

    @PutMapping("/api/friends/{id}")
    public Long updateFriend(@PathVariable Long id, @RequestBody FriendRequestDto requestDto) {
        return friendService.update(id, requestDto);
    }

    @DeleteMapping("/api/friends/{id}")
    public Long deleteFriend( @PathVariable Long id , @RequestBody FriendRequestDto requestDto){
        friendRepository.deleteById( id );
        return id;
    }
}
