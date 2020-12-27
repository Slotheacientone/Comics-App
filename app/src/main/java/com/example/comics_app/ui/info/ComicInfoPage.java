package com.example.comics_app.ui.info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.example.comics_app.ui.info.adapter.ViewPagerInforAdapter;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class ComicInfoPage extends AppCompatActivity {

    private TextView title;
    private TextView category;
    private ImageView imageView;
    private MaterialToolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_info_page);
        title = findViewById(R.id.info_title);
        imageView = findViewById(R.id.infor_image);
        category = findViewById(R.id.info_category);
        toolbar = findViewById(R.id.infor_toolbar);
        tabLayout = findViewById(R.id.info_tab);
        viewPager = findViewById(R.id.info_view_pager);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        Comic comic = (Comic) intent.getSerializableExtra("comic");
        title.setText(comic.getTitle());
        category.setText(comic.getCategory());
        Picasso.get().load(comic.getThumbnail()).resize(250, 352).transform(new RoundedCornersTransformation(10, 0)).into(imageView);
        ViewPagerInforAdapter viewPagerInforAdapter = new ViewPagerInforAdapter(this, comic);
        viewPager.setAdapter(viewPagerInforAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Mô tả");
                    break;
                case 1:
                    tab.setText("Chương");
                    break;
            }
        }).attach();

    }
}