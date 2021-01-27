package com.example.comics_app.ui.info.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.example.comics_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewChapterImageApdater extends RecyclerView.Adapter<RecycleViewChapterImageApdater.RecycleViewChapterImageHolder> {

    private List<String> url;
    Context context;

    public RecycleViewChapterImageApdater(Context context, List<String> url) {
        this.context = context;
        this.url = url;
    }

    @NonNull
    @Override
    public RecycleViewChapterImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.img_view, parent, false);
        return new RecycleViewChapterImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewChapterImageHolder holder, int position) {
        System.out.println("Size: " + url.size());
        System.out.println(url.get(position));
        Picasso.get().load(url.get(position)).resize(200, 200).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return url.size();
    }

    class RecycleViewChapterImageHolder extends RecyclerView.ViewHolder {

        private ImageView img;


        public RecycleViewChapterImageHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_view1);
            System.out.println("contructor");
        }
    }
}
