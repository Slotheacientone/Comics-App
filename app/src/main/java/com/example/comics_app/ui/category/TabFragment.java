package com.example.comics_app.ui.category;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.comics_app.R;

public class TabFragment extends Fragment {

    private String title;
    private TextView textView;

    public TabFragment(String title){
        this.title=title;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_fragment, container, false);
        textView = root.findViewById(R.id.text_view);
        textView.setText(title);
        return root;
    }

}