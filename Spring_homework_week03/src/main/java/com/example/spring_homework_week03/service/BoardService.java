package com.example.spring_homework_week03.service;

import com.example.spring_homework_week03.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long updateBoard( Long id , BoardRequestDto requestDto ){

        Board board = boardRepository.findById( id ).orElseThrow(
                () -> new IllegalArgumentException("게시글 존재하지 않음")
        );
        board.updateBoard( requestDto );

        return id;

    }

    public SingleResponse getBoardById(Long id) {
        SingleResponse singleResponse = new SingleResponse();
        Board board = boardRepository.findById( id ).orElseThrow(() -> new IllegalArgumentException("게시글이 존재 하지 않습니다"));
        singleResponse.data = board;
        return singleResponse;
    }
    public ListResponse getBoard_list(){
        ListResponse listResponse = new ListResponse();
        List<Board> board_list = boardRepository.findAllByOrderByModifiedAtDesc();
        listResponse.data = board_list;
        return  listResponse;
    }

}
