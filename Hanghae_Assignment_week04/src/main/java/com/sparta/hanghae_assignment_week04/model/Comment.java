package com.sparta.hanghae_assignment_week04.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.dto.CommentRequestDto;
import com.sparta.hanghae_assignment_week04.utils.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn( name = "USER_ID", nullable = false)
    private Users user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn( name = "BOARD_ID", nullable = false)
    private Board board;

    public Comment( CommentRequestDto requestDto , Users user , Board board ){
        this.content = requestDto.getContent();
        this.user = user;
        this.author = user.getUsername();
        this.board = board;
    }

    public void updateComment(BoardRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}
