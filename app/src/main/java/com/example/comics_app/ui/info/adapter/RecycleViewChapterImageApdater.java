package com.example.comics_app.ui.info.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comics_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewChapterImageApdater extends RecyclerView.Adapter<RecycleViewChapterImageApdater.RecycleViewChapterImageHolder> {

    private List<String> url;
    Context context;

    public RecycleViewChapterImageApdater(Context context) {
        url = new ArrayList<>();
        url.add("http://i.boxtruyen.net/data/images/17545/357579/001-fix.jpg");
        url.add("http://i.boxtruyen.net/data/images/17545/357579/002-fix.jpg");
        url.add("http://i.boxtruyen.net/data/images/17545/357579/003-fix.jpg");
    }

    @NonNull
    @Override
    public RecycleViewChapterImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.img_view,parent,false);
        return new RecycleViewChapterImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewChapterImageHolder holder, int position) {
        Picasso.get().load(url.get(position)).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return url.size();
    }

    class RecycleViewChapterImageHolder extends RecyclerView.ViewHolder {

        private ImageView img;


        public RecycleViewChapterImageHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_view);

        }
    }
}
