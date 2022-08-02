package com.sparta.hanghae_assignment_week04.model;


import com.sparta.hanghae_assignment_week04.dto.BoardRequestDto;
import com.sparta.hanghae_assignment_week04.utils.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Board extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn( name = "USER_ID", nullable = false)
    private Users user;

    public Board(BoardRequestDto requestDto , Users user ){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = user;
        this.author = user.getUsername();
    }
}
