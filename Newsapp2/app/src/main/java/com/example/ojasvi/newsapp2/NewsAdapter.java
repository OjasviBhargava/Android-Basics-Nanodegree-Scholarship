package com.example.ojasvi.newsapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<NewsData> {
    public NewsAdapter(Context context, ArrayList<NewsData> newsDataArrayList) {
        super(context, 0, newsDataArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        NewsData currentNewsData = getItem(position);

        TextView heading = listItemView.findViewById(R.id.title_news);
        heading.setText(currentNewsData.getLink());

        TextView sectionNews = listItemView.findViewById(R.id.section);
        sectionNews.setText("Section: " + currentNewsData.getSectionName());

        TextView author = listItemView.findViewById(R.id.writer_news);
        if (currentNewsData.getAuthor()!="") {
            author.setText("by " + currentNewsData.getAuthor());
        } else {
            author.setVisibility(View.GONE);
        }

        TextView newsDatetextView = listItemView.findViewById(R.id.date_news);
        String date = currentNewsData.getNewsDate();
        newsDatetextView.setText(date);
        return listItemView;
    }
}