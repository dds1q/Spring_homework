package com.sparta.week02_homework;

import com.sparta.week02_homework.Domain.Friend;
import com.sparta.week02_homework.Domain.FriendRepository;
import com.sparta.week02_homework.Domain.FriendRequestDto;
import com.sparta.week02_homework.service.FriendService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week02HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02HomeworkApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(FriendRepository friendRepository, FriendService friendService) {
        return (args) -> {
            friendRepository.save(new Friend("이동규", 27));

            List<Friend> Friendlist = friendRepository.findAll();
            for ( Friend friend : Friendlist ) {
                System.out.println(friend.getId());
                System.out.println(friend.getName());
                System.out.println(friend.getAge());
            }

            FriendRequestDto new_friend = new FriendRequestDto("이동규", 26 );
            friendService.update(1L, new_friend );
            Friendlist = friendRepository.findAll();
            for ( Friend friend : Friendlist ) {
                System.out.println(friend.getId());
                System.out.println(friend.getName());
                System.out.println(friend.getAge());
            }
        };
    }
}
