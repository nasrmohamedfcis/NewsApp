package com.example.nasrf.news.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.nasrf.news.R;
import com.example.nasrf.news.news.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nasrf on 9/10/2017.
 */

public class ListAdapter extends BaseAdapter {

    private TextView title,description;
    private ImageView newsImg;
    //Button btnMore;
    private List<News> news;
    private Context context;

    public ListAdapter(List<News> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context,R.layout.news_list,null);
        title = (TextView) v.findViewById(R.id.newsTitle);
        description = (TextView) v.findViewById(R.id.newsDesc);
        newsImg = (ImageView) v.findViewById(R.id.newsImg);

        title.setText(news.get(position).getTitle());
        description.setText(news.get(position).getDesc());
        Picasso.with(context).load(news.get(position).getImageUrl()).placeholder(R.drawable.imageunavailable).fit().into(newsImg);

        return v;
    }


}
