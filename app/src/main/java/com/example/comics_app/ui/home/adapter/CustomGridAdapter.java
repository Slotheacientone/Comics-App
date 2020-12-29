package com.example.comics_app.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomGridAdapter extends BaseAdapter {
    private List<Comic> items;
    private Context context;

    public CustomGridAdapter(List<Comic> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.comic_item, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.item_comic_title);
            holder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Comic comic = items.get(position);
        holder.title.setText(comic.getTitle());
        Picasso.get().load(comic.getThumbnail()).into(holder.thumbnail);

        return convertView;
    }


    static class ViewHolder {
        TextView title;
        ImageView thumbnail;
    }
}
