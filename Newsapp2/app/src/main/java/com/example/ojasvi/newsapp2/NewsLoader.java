package com.example.ojasvi.newsapp2;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsData>> {
    private String mUrlString;

    public NewsLoader(Context context, String urlString) {
        super(context);
        mUrlString = urlString;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<NewsData> loadInBackground() {
        return FetchQueryUtils.fetchNewsData(mUrlString);
    }
}
