package com.example.comics_app.ui.category.adapter;

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
import com.example.comics_app.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>{

    private List<Comic> comicList;
    private Context context;

    public RecycleViewAdapter(Context context, List<Comic> comicList) {
        this.comicList = comicList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_item, parent, false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        Picasso.get().load(comicList.get(position).getThumbnail()).resize(250, 352).transform(new RoundedCornersTransformation(10, 0)).into(holder.avatar);
        holder.title.setText(comicList.get(position).getTitle());
        holder.category.setText(comicList.get(position).getCategory());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Click on: " + position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    /*@Override
    public void onClick(int position) {
        System.out.println("Click on: " + position);
    }*/

    public class RecycleViewHolder extends RecyclerView.ViewHolder{

        private ImageView avatar;
        private TextView title;
        private TextView category;
        private CardView cardView;
       // private OnNoteListener onNoteListener;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
           /* itemView.setOnClickListener(this);
           this.onNoteListener = onNoteListener;*/
            cardView = itemView.findViewById(R.id.card_view);
            avatar = itemView.findViewById(R.id.item_avatar);
            title = itemView.findViewById(R.id.item_title);
            category = itemView.findViewById(R.id.item_category);

        }

       /* @Override
        public void onClick(View v) {
            onNoteListener.onClick(getAdapterPosition());
        }*/
    }
}
