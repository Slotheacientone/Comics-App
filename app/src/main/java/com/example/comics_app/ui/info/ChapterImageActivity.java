package com.example.comics_app.ui.info;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comics_app.R;
import com.example.comics_app.ui.info.adapter.RecycleViewChapterAdapter;
import com.example.comics_app.ui.info.adapter.RecycleViewChapterImageApdater;

import java.util.ArrayList;
import java.util.List;

public class ChapterImageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_image);
        List<String> url = new ArrayList<>();
        url.add("http://i.boxtruyen.net/data/images/17545/357579/001-fix.jpg");
        url.add("http://i.boxtruyen.net/data/images/17545/357579/002-fix.jpg");
        url.add("http://i.boxtruyen.net/data/images/17545/357579/003-fix.jpg");
        recyclerView = findViewById(R.id.rc_chapter_image);
        RecycleViewChapterImageApdater recycleViewChapterImageApdater = new RecycleViewChapterImageApdater(this,url);
        recyclerView.setAdapter(recycleViewChapterImageApdater);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);

    }
}
