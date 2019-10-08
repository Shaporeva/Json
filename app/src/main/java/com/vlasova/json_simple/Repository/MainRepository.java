package com.vlasova.json_simple.Repository;

import com.vlasova.json_simple.Delete.MyAsyncTask;
import com.vlasova.json_simple.MainContract;

import java.util.ArrayList;
import java.util.HashMap;

public class MainRepository implements MainContract.Repository {
    ArrayList<HashMap<String, String>> newsList;

   // MyAsyncTask mainRepository = new MyAsyncTask();

    @Override
    public ArrayList<HashMap<String, String>> loadNews() {
        return new startRetrofit1().start();
    }

}
