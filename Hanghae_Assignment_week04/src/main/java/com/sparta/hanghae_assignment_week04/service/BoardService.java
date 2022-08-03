package com.sparta.hanghae_assignment_week04.service;

import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.dto.ResponseDto;
import com.sparta.hanghae_assignment_week04.model.Board;
import com.sparta.hanghae_assignment_week04.model.Users;
import com.sparta.hanghae_assignment_week04.repository.BoardRepository;
import com.sparta.hanghae_assignment_week04.repository.UserRepository;
import com.sparta.hanghae_assignment_week04.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepsitory;
    private final UserRepository userRepository;

    @Autowired
    public BoardService(BoardRepository boardRepsitory, UserRepository userRepository) {
        this.boardRepsitory = boardRepsitory;
        this.userRepository = userRepository;
    }

    public ResponseDto<?> addBoard(BoardRequestDto requestDto ) {
        Users user = userRepository.findByUsername( SecurityUtil.getCurrentUserId() )
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        Board board = new Board( requestDto , user );
        return ResponseDto.success(boardRepsitory.save( board ));
    }

    public ResponseDto<?> getBoards(){
        return ResponseDto.success(boardRepsitory.findAll());
    }


    public ResponseDto<?> updateBoard(Long id , BoardRequestDto requestDto ) {
        Users user = userRepository.findByUsername( SecurityUtil.getCurrentUserId() )
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        Board board = boardRepsitory.findById( id )
                .orElseThrow(() -> new RuntimeException("게시글이 없습니다."));

        if( !board.getUser().getUsername().equals( user.getUsername() ) ){
            throw new RuntimeException("본인이 작성한 게시글이 아닙니다.");
        }

        board.updateBoard( requestDto );

        boardRepsitory.save( board );

        return ResponseDto.success(board);
    }

    public ResponseDto<?> deleteBoard(Long id, BoardRequestDto requestDto) {
        Users user = userRepository.findByUsername( SecurityUtil.getCurrentUserId() )
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        Board board = boardRepsitory.findById( id )
                .orElseThrow(() -> new RuntimeException("게시글이 없습니다."));

        if( !board.getUser().getUsername().equals( user.getUsername() ) ){
            throw new RuntimeException("본인이 작성한 게시글이 아닙니다.");
        }
        boardRepsitory.deleteById( id );

        return ResponseDto.success("delete success");
    }
}
