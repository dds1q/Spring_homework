package com.sparta.hanghae_assignment_week04.controller;


import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.model.Board;
import com.sparta.hanghae_assignment_week04.security.UserDetailsImpl;
import com.sparta.hanghae_assignment_week04.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public Board addBoard(
            @RequestBody BoardRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ){
        return boardService.addBoard( requestDto, userDetails.getUser() );

    }


}
