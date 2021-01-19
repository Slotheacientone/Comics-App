package com.example.comics_app.ui.info.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comics_app.model.Comic;
import com.example.comics_app.ui.category.TabFragment;
import com.example.comics_app.ui.info.ChapterFragment;
import com.example.comics_app.ui.info.DescriptionFragment;

public class ViewPagerInforAdapter extends FragmentStateAdapter {

    private Comic comic;

    public ViewPagerInforAdapter(FragmentActivity fragmentActivity, Comic comic) {
        super(fragmentActivity);
        this.comic = comic;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DescriptionFragment(comic.getDescription(),comic.getId());
            case 1:
                return new ChapterFragment(comic.getId());
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
