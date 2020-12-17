package com.example.comics_app.model;

public class Comic {
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
}
