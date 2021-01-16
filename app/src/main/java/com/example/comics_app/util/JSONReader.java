package com.example.comics_app.util;

import android.util.TypedValue;

import com.example.comics_app.model.Comic;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public List<Comic> getComics(String json) {
        List<Comic> comicList;
        Type listType = new TypeToken<ArrayList<Comic>>(){}.getType();
        comicList = new Gson().fromJson(json, listType);
        return comicList;
    }
}
