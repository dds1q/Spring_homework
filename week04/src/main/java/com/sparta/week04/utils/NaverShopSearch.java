package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component  // 컴포넌트 등록
public class NaverShopSearch {
    public String search( String query ) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "S6_XqFRIRydVf4uIeUi9");
        headers.add("X-Naver-Client-Secret", "HDR8y7alGx");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query , HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();    // 200 이라는 숫자받아옴
        String response = responseEntity.getBody(); //받아온 결과화면이 문자열 하나로 쭉 되어서 문자열로 변환
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems( String result ){
        JSONObject rjson = new JSONObject( result );
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();
        for( int i = 0 ; i < items.length() ; i++ ){
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto( itemJson );
            itemDtoList.add( itemDto );
        }
        return itemDtoList;
    }
}