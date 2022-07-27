package com.example.spring_homework_week03.models;

import java.util.List;
public class ListResponse<T> {
    public boolean success = true;
    public List<T> data;
    public String error;
}
