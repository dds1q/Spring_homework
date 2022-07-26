package com.example.spring_homework_week03.service;

import com.example.spring_homework_week03.models.Board;
import com.example.spring_homework_week03.models.ListResponse;
import com.example.spring_homework_week03.models.SingleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    public SingleResponse getSingleResponse( Board board ){
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.data = board;
        return singleResponse;
    }
    public ListResponse getListResponse( List<Board> board_list ){
        ListResponse listResponse = new ListResponse();
        listResponse.data = board_list;
        return listResponse;
    }
}
