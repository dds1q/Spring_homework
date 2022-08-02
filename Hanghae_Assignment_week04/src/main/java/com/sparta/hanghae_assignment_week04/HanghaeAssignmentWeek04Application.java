package com.sparta.hanghae_assignment_week04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HanghaeAssignmentWeek04Application {

    public static void main(String[] args) {
        SpringApplication.run(HanghaeAssignmentWeek04Application.class, args);
    }

}
