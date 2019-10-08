package com.vlasova.json_simple.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

 class startRetrofit1 {
     ArrayList<HashMap<String, String>> arrayListArticle;

     ///// преоборазуем List<articles> в ArrayList<HashMap<String, String>>
     private ArrayList<HashMap<String, String>> listToArrayList (List<articles> list) {
         ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
         HashMap<String, String> map = new HashMap<>();

         for (int i = 0; i < list.size(); i++ ){
             map.put("title", list.get(i).getTitle());
             map.put("description", list.get(i).getDescription());
             map.put("getUrl", list.get(i).getUrl());
             map.put("getUrlToImage", list.get(i).getUrlToImage());

             arrayList.add(map);
         }
         return arrayList;
     }

     //запускаем Retrofit
    public ArrayList<HashMap<String, String>> start(){
        String url = "https://newsapi.org/";
        arrayListArticle = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagesAPI messagesAPI = retrofit.create(MessagesAPI.class);
        Call<Message> messages = messagesAPI.messages();


        messages.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if(response.isSuccessful()){
                    List<articles> list =  response.body().getArticles();
                    arrayListArticle = listToArrayList(list);
                }
                else {
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
            }
        });
        return arrayListArticle;
    }




}
