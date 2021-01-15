package com.example.comics_app.ui.home.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.MyViewHolder> {
    private Context context;
    private List<Comic> items;

    public ComicAdapter(Context context, List<Comic> comics) {
        this.context = context;
        this.items = comics;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comic_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        Picasso.get().load(items.get(position).getThumbnail()).transform(new RoundedCornersTransformation(10, 0)).into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView imgView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_comic_title);
            imgView = itemView.findViewById(R.id.thumbnail);
        }
    }
}
