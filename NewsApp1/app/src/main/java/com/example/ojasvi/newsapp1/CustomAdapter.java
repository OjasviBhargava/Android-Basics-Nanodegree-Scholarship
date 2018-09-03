package com.example.ojasvi.newsapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ojasvi on 02-09-2018.
 */

public class CustomAdapter extends ArrayAdapter<News> {

    public CustomAdapter(Context context) {
        super(context, -1, new ArrayList<News>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView
                    = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView title = convertView.findViewById(R.id.title_news);
        TextView writer = convertView.findViewById(R.id.writer_news);
        TextView date = convertView.findViewById(R.id.date);

        News currentNews = getItem(position);
        title.setText(currentNews.getNewsHeading());
        writer.setText(currentNews.getNewsWriter());
        date.setText(currentNews.getNewsDate());
        return convertView;
    }
}