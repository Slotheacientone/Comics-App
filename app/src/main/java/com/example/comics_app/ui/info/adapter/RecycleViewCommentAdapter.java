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
import com.example.comics_app.model.Comment;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class RecycleViewCommentAdapter extends RecyclerView.Adapter<RecycleViewCommentAdapter.RecycleViewCommentHolder> {

    private Context context;
    private List<Comment> commentList;

    public RecycleViewCommentAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public RecycleViewCommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.comment_item, parent, false);
        return new RecycleViewCommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewCommentHolder holder, int position) {
        holder.name.setText(commentList.get(position).getName());
        holder.comment.setText(commentList.get(position).getComment());
        holder.date.setText(commentList.get(position).getDate());
        Picasso.get().load(commentList.get(position).getAvatar()).transform(new CropCircleTransformation()).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class RecycleViewCommentHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView avatar;
        private TextView comment;
        private TextView date;

        public RecycleViewCommentHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.comment_name);
            avatar = itemView.findViewById(R.id.comment_avatar);
            comment = itemView.findViewById(R.id.comment);
            date = itemView.findViewById(R.id.comment_date);
        }

    }
}
