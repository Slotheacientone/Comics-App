package com.example.comics_app.model;

public class Chapter {
    private String name;
    private long id;
    private Comic comic;

    public Chapter(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public Chapter(String name, long id, Comic comic) {
        this.name = name;
        this.id = id;
        this.comic = comic;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
