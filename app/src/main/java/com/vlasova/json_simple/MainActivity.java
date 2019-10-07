package com.vlasova.json_simple;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainContract.View {

    private Button btnGo;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter= new Presenter(this);

        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        presenter.onButtonWasClicked();
    }

    @Override
    public void showText(ArrayList<HashMap<String, String>> arrayList) {
        Intent intent = new Intent(this, next_view.class);
        intent.putExtra("array",arrayList );
        startActivity(intent);
    }
}
