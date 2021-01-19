package com.example.comics_app.model;

import java.io.Serializable;
import java.util.List;

public class Comic implements Serializable {
    private long id;
    private String title;
    private String description;
    private String category;
    private String thumbnail;

    public Comic(long id, String title, String description, String category, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnail = thumbnail;
    }


    public Comic(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
