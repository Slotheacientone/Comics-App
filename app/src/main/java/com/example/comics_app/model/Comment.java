package com.example.comics_app.model;

public class Comment {
    private String name;
    private String avatar;
    private String comment;
    private String date;

    public Comment(String name, String avatar, String comment, String date) {
        this.name = name;
        this.avatar = avatar;
        this.comment = comment;
        this.date = date;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
