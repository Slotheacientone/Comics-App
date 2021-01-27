package com.example.comics_app.ui.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comics_app.R;
import com.example.comics_app.model.Chapter;
import com.example.comics_app.model.Comment;
import com.example.comics_app.model.User;
import com.example.comics_app.ui.info.adapter.RecycleViewChapterAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ChapterFragment extends Fragment {

    private long comicId;
    private RecyclerView recyclerView;
    private List<Chapter> chapterList = new ArrayList<>();

    public ChapterFragment(long comicId) {
        this.comicId = comicId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chapter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.chapter_recycle_view);
        RecycleViewChapterAdapter recycleViewChapterAdapter = new RecycleViewChapterAdapter(this.getContext(), chapterList);
        requestProfileData(recycleViewChapterAdapter);
        recyclerView.setAdapter(recycleViewChapterAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.requireContext(), linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.divider, requireContext().getTheme())));
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void requestProfileData(RecycleViewChapterAdapter recycleViewChapterAdapter) {
        //String email = SharedPrefs.getInstance().get("email", String.class);
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.1.22:8080/api/chapter/" + comicId;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Type listType = new TypeToken<ArrayList<Chapter>>() {
                }.getType();
                List<Chapter> temp;
                temp = new Gson().fromJson(response, listType);
                chapterList.clear();
                chapterList.addAll(temp);
                recycleViewChapterAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzbG92ZXJzaW9uMkBnbWFpbC5jb20iLCJpYXQiOjE2MTA5NTYyNjAsImV4cCI6MTYxMTA0MjY2MH0.RgW5acxGapHkb_KD57LlIPsMhhN9EsNYkSa6caDlF-wozF5NUtJqn7VvVB074H4ErV3LeWCG-IFRFqVq8Qr_8nTlToYxX8qCw-TILTyQ9BAUhOzxblZf-cp34ORo1X6VGbFCNfvubX1w0SGfyJmus8e9BZszwmAIDcFZlA5dUJgEDh4IXi5nVNil6C58PpXmVKH0XSRH01z-ufy_mOcTmA_AUd4fKfyx7Dtju07JMJ49TNt0oBYLB7Qt2VPBo7gUcq_PqWDDZ0CxQANUGGXXPanidWCuiCzXwumhUtnZDutAzgeTj0xkM6fR_FFZZVtJSIb9fQn0cL_LV5T6HDrjLA";
                Map<String, String> header = new HashMap<String, String>();
                header.put("Authorization", "Bearer " + accessToken);
                return header;
            }
        };
        requestQueue.add(stringRequest);
    }
}