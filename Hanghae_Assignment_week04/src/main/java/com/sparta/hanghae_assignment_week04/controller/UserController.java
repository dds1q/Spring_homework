package com.sparta.hanghae_assignment_week04.controller;


import com.sparta.hanghae_assignment_week04.model.Users;
import com.sparta.hanghae_assignment_week04.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //    @PostMapping("/api/users/signup")
//    public Users signup(@RequestBody SignupRequestDto requestDto ){
//        return userService.addAccount( requestDto );
//    }
    @GetMapping("/me")
    public Users getMyInfo() {
        return userService.getMyInfo();
    }

    @GetMapping("/{username}")
    public Users getUserInfo(@PathVariable String username) {
        return userService.getUserInfo( username );
    }

}

