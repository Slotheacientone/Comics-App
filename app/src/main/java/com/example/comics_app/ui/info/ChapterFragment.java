package com.example.comics_app.ui.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comics_app.R;
import com.example.comics_app.ui.info.adapter.RecycleViewChapterAdapter;

import java.util.Objects;

public class ChapterFragment extends Fragment {

    private int chapterNumber;
    private RecyclerView recyclerView;

    public ChapterFragment(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.chapter_recycle_view);
        RecycleViewChapterAdapter recycleViewChapterAdapter = new RecycleViewChapterAdapter(this.getContext(), chapterNumber);
        recyclerView.setAdapter(recycleViewChapterAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        /*DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(this.requireContext(), R.drawable.divider)));
        recyclerView.addItemDecoration(divider);*/
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.requireContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.divider, requireContext().getTheme())));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}