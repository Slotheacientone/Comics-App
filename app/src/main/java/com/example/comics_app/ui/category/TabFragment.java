package com.example.comics_app.ui.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.example.comics_app.model.Comic;
import com.example.comics_app.model.Comment;
import com.example.comics_app.model.User;
import com.example.comics_app.ui.category.adapter.RecycleViewAdapter;
import com.example.comics_app.util.SharedPrefs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class TabFragment extends Fragment {

    private String title;
    private RecyclerView recyclerView;
    private List<Comic> comicList = new ArrayList<Comic>();

    public TabFragment(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
       // initializeComicList();
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this.getContext(), comicList);
        requestComicData(recycleViewAdapter);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    public void requestComicData(RecycleViewAdapter recycleViewAdapter) {
       // String email = SharedPrefs.getInstance().get("email", String.class);
        String token = SharedPrefs.getInstance().get("token", String.class);
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.1.22:8080/api/comic/" + title;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String utf8String = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(utf8String);
                    Type listType = new TypeToken<ArrayList<Comic>>() {
                    }.getType();
                    List<Comic> temp;
                    temp = new Gson().fromJson(utf8String, listType);
                    comicList.clear();
                    comicList.addAll(temp);
                    recycleViewAdapter.notifyDataSetChanged();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
              //  String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzbG92ZXJzaW9uMkBnbWFpbC5jb20iLCJpYXQiOjE2MTA5NTYyNjAsImV4cCI6MTYxMTA0MjY2MH0.RgW5acxGapHkb_KD57LlIPsMhhN9EsNYkSa6caDlF-wozF5NUtJqn7VvVB074H4ErV3LeWCG-IFRFqVq8Qr_8nTlToYxX8qCw-TILTyQ9BAUhOzxblZf-cp34ORo1X6VGbFCNfvubX1w0SGfyJmus8e9BZszwmAIDcFZlA5dUJgEDh4IXi5nVNil6C58PpXmVKH0XSRH01z-ufy_mOcTmA_AUd4fKfyx7Dtju07JMJ49TNt0oBYLB7Qt2VPBo7gUcq_PqWDDZ0CxQANUGGXXPanidWCuiCzXwumhUtnZDutAzgeTj0xkM6fR_FFZZVtJSIb9fQn0cL_LV5T6HDrjLA";
                Map<String, String> header = new HashMap<String, String>();
                header.put("Authorization", "Bearer " + token);
                return header;
            }
        };
        requestQueue.add(stringRequest);
    }

}