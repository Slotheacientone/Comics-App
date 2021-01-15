package com.example.comics_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.example.comics_app.ui.home.adapter.BannerSliderAdapter;
import com.example.comics_app.ui.home.adapter.RecycleComicAdapter;
import com.example.comics_app.ui.home.adapter.RecyclerViewAdapter;
import com.example.comics_app.util.PicassoImageLoadingService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.Slider;

public class HomeFragment extends Fragment {

    private Slider slider;
    private RecyclerView bigUpdate, radomComic, topComic;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //prepare data
        List<Comic> items = new ArrayList<Comic>();
        items.add(new Comic("Võ Luyện Đỉnh Phong", "http://st.truyenchon.com/data/comics/32/vo-luyen-dinh-phong.jpg"));
        items.add(new Comic("Thần hào chi tiền môn hệ thống", "http://st.truyenchon.com/data/comics/22/than-hao-chi-thien-hang-he-thong.jpeg"));
        items.add(new Comic("Trọng sinh đô thị tu tiên", "http://st.truyenchon.com/data/comics/213/trong-sinh-do-thi-tu-tien.jpg"));
        items.add(new Comic("Nghịch thiên kiếm thần", "http://st.truyenchon.com/data/comics/121/nghich-thien-kiem-than.jpg"));
        items.add(new Comic("Trở Về Địa Cầu Làm Thần Côn", "http://st.truyenchon.com/data/comics/17/tro-ve-dia-cau-lam-than-con.jpg"));
        items.add(new Comic("Tối Cường Thăng Cấp", "http://st.truyenchon.com/data/comics/24/toi-cuong-thang-cap.jpg"));

//        //banner slider
        Slider.init(new PicassoImageLoadingService(root.getContext()));
        slider = root.findViewById(R.id.banner_slider);
        slider.setAdapter(new BannerSliderAdapter(items));
        slider.setOnSlideClickListener(position -> {
            //complete code here
            System.out.println(position);
        });

        //Big update !!!
        bigUpdate = root.findViewById(R.id.Rv_BigUpdate);
        RecycleComicAdapter comicAdapter = new RecycleComicAdapter(root.getContext(), items);
        bigUpdate.setAdapter(comicAdapter);
        bigUpdate.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerViewAdapter viewAdapter;
        GridLayoutManager manager;

        //random
        RecyclerView topComic = (RecyclerView) root.findViewById(R.id.top_comic);
        viewAdapter = new RecyclerViewAdapter(root.getContext(), items);
        manager = new GridLayoutManager(root.getContext(), 3, GridLayoutManager.VERTICAL, false);
        topComic.setLayoutManager(manager);
        topComic.setAdapter(viewAdapter);


        //random
        RecyclerView randomComic = (RecyclerView) root.findViewById(R.id.random_comic);
        viewAdapter = new RecyclerViewAdapter(root.getContext(), items);
        manager = new GridLayoutManager(root.getContext(), 3, GridLayoutManager.VERTICAL, false);
        randomComic.setLayoutManager(manager);
        randomComic.setAdapter(viewAdapter);

        return root;
    }
}