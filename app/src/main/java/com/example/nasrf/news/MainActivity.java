package com.example.nasrf.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.nasrf.news.adapters.GridAdapter;
import com.example.nasrf.news.news.News;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridAdapter gridAdapter;
    private int icons[]={R.drawable.bbcnews,R.drawable.associatedpress,R.drawable.bbcsports,R.drawable.cnnlogo,R.drawable.hackersnews};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializer();
    }

    private void initializer() {
        gridView = (GridView) findViewById(R.id.grid_view);
        gridAdapter=new GridAdapter(this,icons);
        gridView.setAdapter(gridAdapter);
        //testing
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in;
                if(id==0){ //bbc new
                    //Toast.makeText(MainActivity.this, "bbc news " + id, Toast.LENGTH_SHORT).show();
                    in=new Intent(getApplicationContext(),BbcNewsActivity.class);
                    startActivity(in);
                }
                else if(id==1){ // associated press
                    //Toast.makeText(MainActivity.this, "associated press news " + id, Toast.LENGTH_SHORT).show();
                    in=new Intent(getApplicationContext(),AssocPressActivity.class);
                    startActivity(in);
                }
                else if(id==2){ //bbc sport
                    //Toast.makeText(MainActivity.this, "bbc sports " + id, Toast.LENGTH_SHORT).show();
                    in=new Intent(getApplicationContext(),BbcSportsActivity.class);
                    startActivity(in);
                }
                else if(id==3){ // CNN news
                    //Toast.makeText(MainActivity.this, "CNN news " + id, Toast.LENGTH_SHORT).show();
                    in=new Intent(getApplicationContext(),CnnActivity.class);
                    startActivity(in);
                }
                else if(id==4){ //hackers news
                    //Toast.makeText(MainActivity.this, "hackers news " + id, Toast.LENGTH_SHORT).show();
                    in=new Intent(getApplicationContext(),HackerNewsActivity.class);
                    startActivity(in);
                }
            }
        });


    }
}
