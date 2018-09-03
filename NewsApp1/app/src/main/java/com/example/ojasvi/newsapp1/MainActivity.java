 package com.example.ojasvi.newsapp1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

 public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private CustomAdapter newsAdapter;
    private View loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_news);
        newsAdapter = new CustomAdapter(this);
        listView.setAdapter(newsAdapter);
        TextView errorMessageTV = findViewById(R.id.error_tv);
        loadingIndicator = findViewById(R.id.custom_loader);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                News currentFeedNews = newsAdapter.getItem(position);
                Uri feedNewsUri = Uri.parse(currentFeedNews.getNewsLink());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, feedNewsUri);

                if (websiteIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(websiteIntent);
                }

            }
        });

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (manager != null) {
            networkInfo = manager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            int LOADER_ID = 0;
            getSupportLoaderManager().initLoader(LOADER_ID, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            errorMessageTV.setText(R.string.error);
        }
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        return new MyLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> data) {
        if (data != null) {
            loadingIndicator = findViewById(R.id.custom_loader);
            loadingIndicator.setVisibility(View.GONE);
            newsAdapter.setNotifyOnChange(false);
            newsAdapter.clear();
            newsAdapter.setNotifyOnChange(true);
            newsAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {
    }
}
