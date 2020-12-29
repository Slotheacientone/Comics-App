package com.example.comics_app.ui.home.adapter;

import android.widget.ImageView;

import com.example.comics_app.model.Comic;
import com.example.comics_app.util.PicassoImageLoadingService;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class BannerSliderAdapter extends SliderAdapter {
    private List<Comic> items;

    public BannerSliderAdapter(List<Comic> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        viewHolder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.get().load(items.get(position).getThumbnail()).into(viewHolder.imageView);
    }
}
