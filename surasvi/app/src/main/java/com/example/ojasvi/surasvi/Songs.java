package com.example.ojasvi.surasvi;

/**
 * Created by Ojasvi on 12-07-2018.
 */

public class Songs {

    private String title;
    private String desc;
    private int image;

    public Songs(String name, String artist, int cover) {
        this.title = name;
        this.desc = artist;
        this.image = cover;
    }

    public Songs(String name, int cover) {
        this.title = name;
        this.image = cover;
    }

    public String getSongName() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}
