package com.example.comics_app.ui.category.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.comics_app.ui.category.TabFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new TabFragment("action");
            case 1: return new TabFragment("comedy");
            case 2: return new TabFragment("school life");
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
