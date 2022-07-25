package com.example.spring_homework_week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHomeworkWeek03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomeworkWeek03Application.class, args);
    }

}
