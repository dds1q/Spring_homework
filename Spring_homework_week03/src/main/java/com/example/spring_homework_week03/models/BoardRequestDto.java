package com.example.spring_homework_week03.models;


import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String author;
    private String password;
    private String content;
}
