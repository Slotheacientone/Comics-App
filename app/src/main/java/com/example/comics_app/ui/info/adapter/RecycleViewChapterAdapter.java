package com.example.comics_app.ui.info.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comics_app.R;

public class RecycleViewChapterAdapter extends RecyclerView.Adapter<RecycleViewChapterAdapter.RecycleViewChapterHolder> {

    private Context context;
    private int chapterNumber;

    public RecycleViewChapterAdapter(Context context, int chapterNumber) {
        this.context = context;
        this.chapterNumber = chapterNumber;
    }

    @NonNull
    @Override
    public RecycleViewChapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.chapter_item, parent, false);
        return new RecycleViewChapterAdapter.RecycleViewChapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewChapterHolder holder, int position) {
        int chapter = position + 1;
        holder.textView.setText("Chapter " + chapter);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(chapter);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterNumber;
    }

    class RecycleViewChapterHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CardView cardView;

        public RecycleViewChapterHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.img_view);
            cardView = itemView.findViewById(R.id.chapter_card_view);
        }

    }
}
