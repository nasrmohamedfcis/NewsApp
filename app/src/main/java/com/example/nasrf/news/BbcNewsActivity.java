package com.example.nasrf.news;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nasrf.news.adapters.ListAdapter;
import com.example.nasrf.news.news.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BbcNewsActivity extends AppCompatActivity {

    private List<News> news;
    private ListView newsList;
    private List<String> urls;
    private ListAdapter listAdapter;
    private Button btnViewMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbc_news);
        newsList = (ListView) findViewById(R.id.lv_news);

        news = new ArrayList<>();
        urls = new ArrayList<>();

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=d72174043b224f7cbace25cd241989fc";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject all = new JSONObject(response);
                            JSONArray articles = all.getJSONArray("articles");
                            String title="",desc="",imgUrl="",url="";
                            for(short i=0;i<articles.length();i++){
                                JSONObject member=articles.getJSONObject(i);
                                title=member.getString("title");
                                desc=member.getString("description");
                                imgUrl=member.getString("urlToImage");
                                url=member.getString("url");
                                news.add(new News(title,desc,imgUrl));
                                urls.add(i,url);

                            }
                            listAdapter = new ListAdapter(news,getApplicationContext());
                            newsList.setAdapter(listAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BbcNewsActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


        /*
        btnViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BbcNewsActivity.this, "ay 7aga wenaby", Toast.LENGTH_SHORT).show();
            }
        });
        */

        /*
        WebView webview = new WebView(getApplicationContext());
        setContentView(webview);
        webview.loadUrl(urls.get(position));
        */
    }

}
