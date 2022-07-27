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

    // 게시글 목록 보기
    @Transactional
    public ListResponse getBoard_list(){
        List<Board> board_list = boardRepository.findAllByOrderByModifiedAtDesc();
        return  getListResponse( board_list );
    }

    // 특정 게시글 보기
    @Transactional
    public SingleResponse getBoardById(Long id) {
        Board board = boardRepository.findById( id ).orElseThrow(() -> new IllegalArgumentException("게시글이 존재 하지 않습니다"));
        return getSingleResponse( board );
    }

    // 게시글 작성
    @Transactional
    public SingleResponse writeBoard( BoardRequestDto requestDto ) {
        Board board = new Board( requestDto );
        return getSingleResponse( boardRepository.save( board ) );
    }

    // 게시글 비밀번호 일치여부
    @Transactional
    public SingleResponse isCorrect(Long id , BoardPasswordRequestDto requestDto) {
        Board board = boardRepository.findById( id ).orElseThrow(
                () -> new NullPointerException("게시글이 존재 하지 않습니다"));
        boolean chk = board.getPassword().equals( requestDto.getPassword() );
        return getSingleResponse( chk );
    }

    // 게시글 수정
    @Transactional
    public SingleResponse modifyBoard( Long id , BoardRequestDto requestDto ){
        Board board = boardRepository.findById( id ).orElseThrow(
                () -> new IllegalArgumentException("게시글 존재하지 않음")
        );
        board.updateBoard( requestDto );
        return getSingleResponse( board );
    }

    // 게시글 삭제
    @Transactional
    public SingleResponse deleteById(Long id) {
        boardRepository.deleteById( id );
        return getSingleResponse( true );
    }

    /* ------------------- 응답을 Response 형태로 변환 ---------------- */

    public<T> SingleResponse<T> getSingleResponse( T data ) {
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.data = data;
        return singleResponse;
    }

    public<T> ListResponse<T> getListResponse( List<T> data ) {
        ListResponse listResponse = new ListResponse();
        listResponse.data = data;
        return listResponse;
    }
}
