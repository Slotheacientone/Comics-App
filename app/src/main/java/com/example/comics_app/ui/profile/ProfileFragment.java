package com.example.comics_app.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comics_app.LoginActivity;
import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.example.comics_app.model.User;
import com.example.comics_app.util.SharedPrefs;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ProfileFragment extends Fragment {

    private ImageView avatar;
    private TextView name;
    private TextView currency;
    private TextView level;
    private Button logout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        avatar = view.findViewById(R.id.profile_avatar);
        name = view.findViewById(R.id.profile_name);
        currency = view.findViewById(R.id.currency);
        level = view.findViewById(R.id.level);
        logout = view.findViewById(R.id.logout);
        requestProfileData();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefs.getInstance().clear();
                startActivity(new Intent(view.getContext(), LoginActivity.class));
            }
        });
    }

    public void requestProfileData() {
        String email = SharedPrefs.getInstance().get("email", String.class);
        String token = SharedPrefs.getInstance().get("token", String.class);
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.1.22:8080/api/profile/" + email;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                User user = new Gson().fromJson(response, User.class);
                Picasso.get().load(user.getAvatar()).transform(new CropCircleTransformation()).into(avatar);
                name.setText(user.getName());
                currency.setText(user.getCash()+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
               // String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzbG92ZXJzaW9uMkBnbWFpbC5jb20iLCJpYXQiOjE2MTA5NTYyNjAsImV4cCI6MTYxMTA0MjY2MH0.RgW5acxGapHkb_KD57LlIPsMhhN9EsNYkSa6caDlF-wozF5NUtJqn7VvVB074H4ErV3LeWCG-IFRFqVq8Qr_8nTlToYxX8qCw-TILTyQ9BAUhOzxblZf-cp34ORo1X6VGbFCNfvubX1w0SGfyJmus8e9BZszwmAIDcFZlA5dUJgEDh4IXi5nVNil6C58PpXmVKH0XSRH01z-ufy_mOcTmA_AUd4fKfyx7Dtju07JMJ49TNt0oBYLB7Qt2VPBo7gUcq_PqWDDZ0CxQANUGGXXPanidWCuiCzXwumhUtnZDutAzgeTj0xkM6fR_FFZZVtJSIb9fQn0cL_LV5T6HDrjLA";
                Map<String, String> header = new HashMap<String, String>();
                header.put("Authorization", "Bearer " + token);
                return header;
            }
        };
        requestQueue.add(stringRequest);
    }
}