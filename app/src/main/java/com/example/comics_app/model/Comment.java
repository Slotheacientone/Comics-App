package com.example.comics_app.model;

public class Comment {
    private String avatar;
    private String name;
    private String comment;
    private String date;

    public Comment(String avatar, String name, String comment, String date) {
        this.avatar = avatar;
        this.name = name;
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
}
