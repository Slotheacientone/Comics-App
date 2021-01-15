package com.example.comics_app.ui.home.adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comics_app.R;
import com.example.comics_app.model.Comic;

import com.example.comics_app.ui.info.ComicInfoPage;
import com.squareup.picasso.Picasso;


import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Comic> items;

    public RecyclerViewAdapter(Context context, List<Comic> comics) {
        this.context = context;
        this.items = comics;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_comic_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        Picasso.get().load(items.get(position).getThumbnail()).into(holder.imgView);

        holder.cardView.setOnClickListener((view) -> {
            Intent intent = new Intent(context, ComicInfoPage.class);
            intent.putExtra("comic", items.get(position));
            context.startActivity(intent);
        });

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView title;
        private ImageView imgView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.recycle_card);
            title = itemView.findViewById(R.id.recycle_item_comic_title);
            imgView = itemView.findViewById(R.id.recycle_thumbnail);
        }

    }
}