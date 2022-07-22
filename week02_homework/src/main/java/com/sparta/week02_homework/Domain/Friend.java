package com.sparta.week02_homework.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Friend extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private int age;

    public Friend(FriendRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
    }
    public Friend(String name , int age ) {
        this.name = name;
        this.age = age;
    }
    public void update(FriendRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
    }



}