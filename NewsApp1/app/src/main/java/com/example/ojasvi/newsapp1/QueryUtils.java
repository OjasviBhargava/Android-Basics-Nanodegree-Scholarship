package com.example.ojasvi.newsapp1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ojasvi on 02-09-2018.
 */

public class QueryUtils {

    static URL formURL() {
        String stringUrl = "http://content.guardianapis.com/search?show-tags=contributor" +
                "&api-key=fe71bc46-c646-4dc6-8db7-e6e5a31b8437&q=india";
        try {
            return new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("Log", "Error creating URL", e);
            return null;
        }
    }

    static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null){
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("log", "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("log", "HTTP error: ", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    static List<News> parseJsonResponse(String response) {
        ArrayList<News> newsList = new ArrayList<>();
        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONObject jsonResults = jsonResponse.getJSONObject("response");
            JSONArray resultsArray = jsonResults.getJSONArray("results");

            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject resultJSON = resultsArray.getJSONObject(i);
                String webTitle = resultJSON.getString("webTitle");
                String link = resultJSON.getString("webUrl");
                String date = resultJSON.getString("webPublicationDate");
                String section = resultJSON.getString("sectionName");
                JSONArray tagsArray = resultJSON.getJSONArray("tags");
                StringBuilder writer = new StringBuilder();
                if (tagsArray.length() == 0) {
                    writer = null;
                } else {
                    for (int j = 0; j < tagsArray.length(); j++) {
                        JSONObject firstObject = tagsArray.getJSONObject(j);
                        writer.append(firstObject.getString("webTitle")).append(". ");
                    }
                }
                if (writer != null) {
                    newsList.add(new News(webTitle, date, link, section, writer.toString()));
                }
            }
        } catch (JSONException e) {
            Log.e("Log", "Error in JSON response", e);
        }
        return newsList;
    }
}
