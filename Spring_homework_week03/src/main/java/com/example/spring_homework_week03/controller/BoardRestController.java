package com.example.spring_homework_week03.controller;


import com.example.spring_homework_week03.models.*;
import com.example.spring_homework_week03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 모든 게시글 조회
    @GetMapping("/api/board")
    public ListResponse getBoard_list(){
        return boardService.getBoard_list();
    }

    // 특정 게시글 조회
    @GetMapping("/api/board/{id}")
    public SingleResponse getBoardById(@PathVariable Long id ){
        return boardService.getBoardById( id );
    }

    // 게시글 작성
    @PostMapping("/api/board")
    public SingleResponse writeBoard(@RequestBody BoardRequestDto requestDto ){
        return boardService.writeBoard( requestDto );
    }

    // 게시글 비밀번호 확인
    @PostMapping("/api/board/{id}")
    public SingleResponse isCorrect(@PathVariable Long id , @RequestBody BoardPasswordRequestDto requestDto){
        return boardService.isCorrect( id , requestDto );
    }

    // 게시글 수정
    @PutMapping("/api/board/{id}")
    public SingleResponse modifyBoard(@PathVariable Long id , @RequestBody BoardRequestDto requestDto ){
        return boardService.modifyBoard( id , requestDto );
    }

    // 게시글 삭제
    @DeleteMapping("/api/board/{id}")
    public SingleResponse deleteBoard(@PathVariable Long id){
        return boardService.deleteById( id );
    }
}
