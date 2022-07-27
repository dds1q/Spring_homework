package com.example.spring_homework_week03.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public class BoardResponseDto {
    private LocalDateTime modifiedAt;
    private String title;
    private String author;
    private String content;
}
