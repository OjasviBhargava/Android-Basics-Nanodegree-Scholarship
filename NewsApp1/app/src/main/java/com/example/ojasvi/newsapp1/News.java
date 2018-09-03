package com.example.ojasvi.newsapp1;

/**
 * Created by Ojasvi on 02-09-2018.
 */

public class News {
    String newsHeading;
    String newsDate;
    String newsLink;
    String newsWriter;

    public News(String newsHeading, String newsDate, String newsLink, String newsWriter) {
        this.newsHeading = newsHeading;
        this.newsDate = newsDate;
        this.newsLink = newsLink;
        this.newsWriter = newsWriter;
    }

    public String getNewsHeading() {
        return newsHeading;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getNewsWriter() {
        return newsWriter;
    }

    public String getNewsLink() {
        return newsLink;
    }

}
