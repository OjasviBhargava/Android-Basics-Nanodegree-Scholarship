package com.example.ojasvi.newsapp2;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsData>> {

    public NewsAdapter mNewsAdapter;
    public ListView mNewsListView;
    private TextView mStatusTextView;
    private ProgressBar mLoadingProgressBar;

    private static final String REQUEST_URL_STRING = "https://content.guardianapis.com/search?" +
            "api-key=fe71bc46-c646-4dc6-8db7-e6e5a31b8437";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork!=null && activeNetwork.isConnectedOrConnecting();

        mLoadingProgressBar = findViewById(R.id.loader);
        mNewsAdapter = new NewsAdapter(this,new ArrayList<NewsData>());
        mNewsListView = findViewById(R.id.news_list);
        mNewsListView.setAdapter(mNewsAdapter);
        mStatusTextView = findViewById(R.id.info_tv);
        mNewsListView.setEmptyView(mStatusTextView);

        mNewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsData currentNewsData = mNewsAdapter.getItem(position);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(currentNewsData.getWebUrl()));
                startActivity(browserIntent);
            }
        });

        if (!isConnected) {
            mLoadingProgressBar.setVisibility(View.GONE);
            mStatusTextView.setText(R.string.no_internet_connection);
        } else {
            getLoaderManager().initLoader(0, null, this);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_settings) {
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<NewsData>> onCreateLoader(int id, Bundle args) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String pageSize = sharedPreferences.getString(getString(R.string.settings_page_size_key),getString(R.string.settings_page_size_default));
        String orderBy = sharedPreferences.getString(getString(R.string.settings_order_by_key),getString(R.string.settings_order_by_default));
        String category = sharedPreferences.getString(getString(R.string.settings_section_news_key), getString(R.string.settings_section_news_default));

        Uri baseUri = Uri.parse(REQUEST_URL_STRING);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("show-tags","contributor");
        uriBuilder.appendQueryParameter("tag","science/science,music/music");
        uriBuilder.appendQueryParameter("page-size",pageSize);
        uriBuilder.appendQueryParameter("order-by",orderBy);

        if (!category.equals(getString(R.string.settings_section_news_default))){
            uriBuilder.appendQueryParameter("section", category);
        }
        return new NewsLoader(HomeActivity.this,uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<NewsData>> loader, List<NewsData> data) {
        mStatusTextView.setText(R.string.no_news);
        mNewsAdapter.clear();

        mLoadingProgressBar.setVisibility(View.GONE);

        if (data!=null && !data.isEmpty()) {
            mNewsAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewsData>> loader) {
        mNewsAdapter.clear();
    }


    @Override
    protected void onStart() {
        super.onStart();
        getLoaderManager().restartLoader(0,null,this);
    }
}
