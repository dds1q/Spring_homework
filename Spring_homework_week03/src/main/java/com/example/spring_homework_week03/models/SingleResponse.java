package com.example.spring_homework_week03.models;

public class SingleResponse<T> {
    public boolean success = true;
    public T data;
    public String error;
}
