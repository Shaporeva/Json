package com.vlasova.json_simple.Repository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesAPI {
    @GET("v2/top-headlines?sources=google-news-ru&apiKey=4b1b5539788e4bf3be958892a276769f")
    Call<Message> messages();
}
