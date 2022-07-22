package com.sparta.week02_homework.Domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FriendRequestDto {
    private final String name;
    private final int age;
}
