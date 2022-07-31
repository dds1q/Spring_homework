package com.sparta.springcore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Folder {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn( name = "USER_ID", nullable = false)
    private Users user;

    public Folder( String name, Users user ) {
        this.name = name;
        this.user = user;
    }
}