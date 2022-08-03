package com.sparta.hanghae_assignment_week04.service;

import com.sparta.hanghae_assignment_week04.dto.CommentRequestDto;
import com.sparta.hanghae_assignment_week04.dto.ResponseDto;
import com.sparta.hanghae_assignment_week04.model.Board;
import com.sparta.hanghae_assignment_week04.model.Comment;
import com.sparta.hanghae_assignment_week04.model.Users;
import com.sparta.hanghae_assignment_week04.repository.BoardRepository;
import com.sparta.hanghae_assignment_week04.repository.CommentRepository;
import com.sparta.hanghae_assignment_week04.repository.UserRepository;
import com.sparta.hanghae_assignment_week04.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(BoardRepository boardRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public ResponseDto<?> addComment(CommentRequestDto requestDto ) {
        Users user = userRepository.findByUsername( SecurityUtil.getCurrentUserId() )
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        Board board = boardRepository.findById( requestDto.getPostId() )
                .orElseThrow( () -> new NullPointerException("게시글이 존재하지 않습니다") );

        Comment comment = new Comment( requestDto, user , board );

        commentRepository.save( comment );

        return ResponseDto.success( comment );



    }
}
