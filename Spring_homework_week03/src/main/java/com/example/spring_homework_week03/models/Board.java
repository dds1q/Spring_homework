package com.example.spring_homework_week03.models;

import com.example.spring_homework_week03.utils.Timestamped;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Board extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public Board( BoardRequestDto requestDto ){
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
    }

    public void updateBoard( BoardRequestDto requestDto ){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
}