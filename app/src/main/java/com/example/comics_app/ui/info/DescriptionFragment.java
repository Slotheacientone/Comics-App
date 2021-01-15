package com.example.comics_app.ui.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.comics_app.R;
import com.example.comics_app.model.Comment;
import com.example.comics_app.ui.info.adapter.RecycleViewCommentAdapter;

import java.util.ArrayList;
import java.util.List;


public class DescriptionFragment extends Fragment {

    private String description;
    private TextView textView;
    private RecyclerView commentList;
    private List<Comment> listOfComment = new ArrayList<Comment>();

    public DescriptionFragment(String description) {
        this.description = description;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComment();
        textView = view.findViewById(R.id.description);
        commentList = view.findViewById(R.id.comment_list);
        textView.setText(description);
        commentList.setAdapter(new RecycleViewCommentAdapter(this.getContext(), listOfComment));
        commentList.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    private void initComment() {
        Comment comment1 = new Comment("https://preview.redd.it/wpwxc0rvjd961.jpg?auto=webp&s=03c5c7fbc818daa80d7acecb55ffe635988c47e5", "Slo", "Chuyện hay đấy", "14/01/2021");
        Comment comment2 = new Comment("https://preview.redd.it/wpwxc0rvjd961.jpg?auto=webp&s=03c5c7fbc818daa80d7acecb55ffe635988c47e5", "Su", "Chuyện không tệ", "14/01/2021");
        listOfComment.add(comment1);
        listOfComment.add(comment2);
        listOfComment.add(comment1);
        listOfComment.add(comment2);
        listOfComment.add(comment1);
        listOfComment.add(comment2);
    }
}