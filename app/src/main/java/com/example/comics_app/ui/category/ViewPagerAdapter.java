package com.example.comics_app.ui.category;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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
            case 2: return new TabFragment("horror");
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
