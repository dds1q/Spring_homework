package com.sparta.hanghae_assignment_week04.controller;


import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.dto.ResponseDto;

import com.sparta.hanghae_assignment_week04.security.UserDetailsImpl;
import com.sparta.hanghae_assignment_week04.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public ResponseDto<?> addBoard(
            @RequestBody BoardRequestDto requestDto
            ){
        return boardService.addBoard( requestDto );
    }

    @GetMapping("/board")
    public ResponseDto<?> getBoards(){
        return boardService.getBoards();
    }

    @PutMapping("/board/{id}")
    public ResponseDto<?> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.updateBoard( id , requestDto );
    }

    @DeleteMapping("/board/{id}")
    public ResponseDto<?> deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.deleteBoard( id , requestDto );
    }
}
