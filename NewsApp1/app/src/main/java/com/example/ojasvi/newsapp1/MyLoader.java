package com.example.ojasvi.newsapp1;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Ojasvi on 02-09-2018.
 */

public class MyLoader extends android.support.v4.content.AsyncTaskLoader<List<News>> {

    public MyLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        List<News> newsData = null;
        try {
            URL url = QueryUtils.formURL();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            newsData = QueryUtils.parseJsonResponse(jsonResponse);
        } catch (IOException e) {
            Log.e("Log", "Error :", e);
        }
        return newsData;
    }
}
