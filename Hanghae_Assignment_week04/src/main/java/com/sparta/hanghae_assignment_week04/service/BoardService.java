package com.sparta.hanghae_assignment_week04.service;

import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.model.Board;
import com.sparta.hanghae_assignment_week04.model.Users;
import com.sparta.hanghae_assignment_week04.repository.BoardRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepsitory boardRepsitory;

    @Autowired
    public BoardService(BoardRepsitory boardRepsitory) {
        this.boardRepsitory = boardRepsitory;
    }

    public Board addBoard(BoardRequestDto requestDto, Users user) {
        Board board = new Board( requestDto , user );
        return boardRepsitory.save( board );
    }
}
