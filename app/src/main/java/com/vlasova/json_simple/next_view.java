package com.vlasova.json_simple;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class next_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        ArrayList<HashMap<String, String>> arrayList = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("array");
        LayoutInflater ltInflater = getLayoutInflater();
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.container1);
        for (HashMap<String, String> list:arrayList) {
            View item = ltInflater.inflate(R.layout.news, linLayout, false);
            TextView txtTitle = (TextView) item.findViewById(R.id.txtTitle);
            txtTitle.setText(list.get("title"));
            String s = list.get("imgUrl");
            DownloadImageTask downloadImageTask = new DownloadImageTask();
            downloadImageTask.execute(s);
            ImageView img1 = (ImageView) item.findViewById(R.id.img); //picasso
            try {
                Bitmap bitmap = downloadImageTask.get();
                img1.setImageBitmap(bitmap);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*Uri uri = Uri.parse("s" + R.drawable.mainimg);
            img1.setImageURI(null);
            img1.setImageURI(uri);*/
            TextView txtDiscription = (TextView) item.findViewById(R.id.txtDiscription);
            txtDiscription.setText(list.get("description"));
            item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            linLayout.addView(item);
        }
    }
}
