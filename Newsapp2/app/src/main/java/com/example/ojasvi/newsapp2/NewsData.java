package com.example.ojasvi.newsapp2;

public class NewsData {
    private String newsLink;
    private String newsTitle;
    private String newsAuthor;
    private String newsSection;
    private String newsDate;

    public NewsData(String webUrl, String webTitle, String author, String sectionName, String date)
    {
        newsLink = webUrl;
        newsTitle = webTitle;
        newsAuthor = author;
        newsSection = sectionName;
        newsDate = date;
    }

    public String getWebUrl() { return newsLink; }
    public String getLink() { return newsTitle; }
    public String getAuthor() { return newsAuthor; }
    public String getSectionName() { return newsSection; }
    public String getNewsDate() {
        return newsDate;
    }
}
