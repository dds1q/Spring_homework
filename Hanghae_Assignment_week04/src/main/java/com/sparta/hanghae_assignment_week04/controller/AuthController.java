package com.sparta.hanghae_assignment_week04.controller;


import com.sparta.hanghae_assignment_week04.dto.*;
import com.sparta.hanghae_assignment_week04.model.Board;
import com.sparta.hanghae_assignment_week04.model.Users;
import com.sparta.hanghae_assignment_week04.security.UserDetailsImpl;
import com.sparta.hanghae_assignment_week04.service.AuthService;
import com.sparta.hanghae_assignment_week04.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final BoardService boardService;

    @PostMapping("/signup")
    public Users signup(@RequestBody SignupRequestDto requestDto ) {
        return authService.signup(requestDto);
    }

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginRequestDto requestDto) {
        return authService.login(requestDto);
    }

    @PostMapping("/reissue")
    public TokenDto reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return authService.reissue(tokenRequestDto);
    }

}
