package com.vlasova.json_simple;

import android.content.Intent;
import android.os.Bundle;

import com.vlasova.json_simple.Repository.MainRepository;
import java.util.ArrayList;
import java.util.HashMap;

import static android.support.v4.content.ContextCompat.startActivity;

public class Presenter implements MainContract.Presenter{
    ArrayList<HashMap<String, String>> newsList;
    MainContract.View view;
    MainRepository mainRepository;

    public Presenter(MainContract.View v){
        this.view = v;
        this.mainRepository = new MainRepository();
    }

    @Override
    public void onButtonWasClicked() {
        newsList = mainRepository.loadNews();
        view.showText(newsList);
    }

    @Override
    public void onDestroy() {

    }
}
