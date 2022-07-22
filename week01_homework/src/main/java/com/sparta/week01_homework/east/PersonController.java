package com.sparta.week01_homework.east;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {
    @GetMapping("/person")
    public Person getPerson(){
        Person person = new Person();
        person.setName("이동규");
        person.setAge(27);
        person.setAddress("부산");
        person.setJob("항해99 학생");
        return person;
    }
}
