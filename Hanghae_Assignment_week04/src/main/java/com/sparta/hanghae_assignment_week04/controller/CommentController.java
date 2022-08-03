package com.sparta.hanghae_assignment_week04.controller;

import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.dto.CommentRequestDto;
import com.sparta.hanghae_assignment_week04.dto.ResponseDto;
import com.sparta.hanghae_assignment_week04.security.UserDetailsImpl;
import com.sparta.hanghae_assignment_week04.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/Comment")
    public ResponseDto<?> addComment(
            @RequestBody CommentRequestDto requestDto

    ){
        return commentService.addComment( requestDto );
    }

//    @GetMapping("/Comment/{id}")
//    public ResponseDto<?> getComments(){
//        return commentService.getComments();
//    }
//
//    @PutMapping("/Comment/{id}")
//    public ResponseDto<?> updateComment(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
//        return commentService.updateComment( id , requestDto );
//    }
//
//    @DeleteMapping("/Comment/{id}")
//    public ResponseDto<?> deleteComment(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
//        return commentService.deleteComment( id , requestDto );
//    }
}

