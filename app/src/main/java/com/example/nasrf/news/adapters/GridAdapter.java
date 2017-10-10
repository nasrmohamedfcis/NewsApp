package com.example.nasrf.news.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.nasrf.news.R;

/**
 * Created by nasrf on 8/10/2017.
 */

public class GridAdapter extends BaseAdapter {

    private Context context;
    private int icon[];
    private LayoutInflater inflater;

    public GridAdapter(Context context, int[] icon) {
        this.context = context;
        this.icon = icon;
    }

    @Override
    public int getCount() {
        return icon.length;
    }

    @Override
    public Object getItem(int position) {
        return icon[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grid_view,null);
        }

        ImageView imgIcon = (ImageView) v.findViewById(R.id.imgIcon);
        imgIcon.setImageResource(icon[position]);
        return v;
    }
}
