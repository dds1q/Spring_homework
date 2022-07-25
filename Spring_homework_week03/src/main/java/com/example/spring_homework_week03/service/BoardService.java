package com.example.spring_homework_week03.service;

import com.example.spring_homework_week03.models.Board;
import com.example.spring_homework_week03.models.BoardRepository;
import com.example.spring_homework_week03.models.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long updateBoard( Long id , BoardRequestDto requestDto ){

        Board board = boardRepository.findById( id ).orElseThrow(
                () -> new NullPointerException("게시글 존재하지 않음")
        );
        if( board.getPassword().equals( requestDto.getPassword() ) ){
            board.updateBoard( requestDto );
        }else{
            System.out.println("비밀번호가 다릅니다");
        }
        return id;

    }
}
