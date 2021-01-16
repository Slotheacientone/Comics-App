package com.example.comics_app.model;

import java.io.Serializable;

public class Comic implements Serializable {
    private String title;
    private String description;
    private String category;
    private String thumbnail;
    private int numberOfChapters;

    public Comic(String title, String description, String category, String thumbnail, int numberOfChapters) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
        this.numberOfChapters = numberOfChapters;
    }

    public Comic(String title, String description, String category, String thumbnail) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
    }

    public Comic(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }
}
