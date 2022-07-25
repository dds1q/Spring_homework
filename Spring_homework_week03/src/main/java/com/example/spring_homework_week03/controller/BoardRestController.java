package com.example.spring_homework_week03.controller;


import com.example.spring_homework_week03.models.Board;
import com.example.spring_homework_week03.models.BoardPasswordRequestDto;
import com.example.spring_homework_week03.models.BoardRepository;
import com.example.spring_homework_week03.models.BoardRequestDto;
import com.example.spring_homework_week03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardRestController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/board")
    public List<Board> getBoard_list(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/board/{id}")
    public Board getBoardById( @PathVariable Long id ){
        Board board = boardRepository.findById( id ).orElseThrow(
                () -> new NullPointerException("게시글이 존재 하지 않습니다"));
        return board;
    }

    @PostMapping("/api/board")
    public Board writeBoard(@RequestBody BoardRequestDto requestDto ){
        Board board = new Board( requestDto );
        return boardRepository.save( board );
    }

    @PostMapping("/api/board/{id}")
    public boolean isCorrect(@PathVariable Long id , @RequestBody BoardPasswordRequestDto requestDto){
        Board board = boardRepository.findById( id ).orElseThrow(
                () -> new NullPointerException("게시글이 존재 하지 않습니다"));
        if( board.getPassword().equals( requestDto.getPassword() ) ) return true;
        else return false;
    }

    @PutMapping("/api/board/{id}")
    public Long modifyBoard(@PathVariable Long id , @RequestBody BoardRequestDto requestDto ){
        boardService.updateBoard( id , requestDto );
        return id;
    }

    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById( id );
        return id;
    }
}
