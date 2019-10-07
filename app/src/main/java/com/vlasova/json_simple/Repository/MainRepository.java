package com.vlasova.json_simple.Repository;

import com.vlasova.json_simple.MainContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class MainRepository implements MainContract.Repository {
    ArrayList<HashMap<String, String>> newsList;

    MyAsyncTask mainRepository = new MyAsyncTask();

    @Override
    public ArrayList<HashMap<String, String>> loadNews() {
        mainRepository.execute();
        try {
            return mainRepository.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
