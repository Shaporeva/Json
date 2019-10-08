package com.vlasova.json_simple.Delete;

import android.os.AsyncTask;

import com.vlasova.json_simple.Delete.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAsyncTask extends AsyncTask<Void, Void, ArrayList<HashMap<String, String>>> {
    private static String url = "https://newsapi.org/v2/top-headlines?sources=google-news-ru&apiKey=4b1b5539788e4bf3be958892a276769f";
    ArrayList<HashMap<String, String>> newsList;

    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(Void... voids) {
        HttpHandler handler = new HttpHandler();
        String jsonStr = handler.makeServiceCall(url);
        newsList= new ArrayList<>();

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String status = jsonObj.getString("status");
                String totalResults = jsonObj.getString("totalResults");
                JSONArray articles = jsonObj.getJSONArray("articles");
                for (int i = 0; i < Integer.parseInt(totalResults); i++){
                    JSONObject article = articles.getJSONObject(i);
                    String title = article.getString("title");
                    String imgUrl = article.getString("urlToImage");
                    String contentUrl = article.getString("url");
                    String description = article.getString("description");

                    HashMap<String, String> news = new HashMap<>();
                    news.put("title", title);
                    news.put("imgUrl", imgUrl);
                    news.put("contentUrl", contentUrl);
                    news.put("description", description);

                    newsList.add(news);

                }
            } catch (JSONException e) {
                return newsList;
            //    e.printStackTrace();
            }
        }
        return newsList;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(ArrayList<HashMap<String, String>> hashMaps) {
        super.onPostExecute(hashMaps);
    }
}
/*
    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer= new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null){
                buffer.append(line + "\n");
            }
            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                connection.disconnect();
            }
            try{
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void
}*/
