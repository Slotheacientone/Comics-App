package com.example.comics_app.ui.info;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.comics_app.R;
import com.example.comics_app.model.Comic;
import com.example.comics_app.model.Comment;
import com.example.comics_app.model.User;
import com.example.comics_app.ui.info.adapter.RecycleViewCommentAdapter;
import com.example.comics_app.util.SharedPrefs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class DescriptionFragment extends Fragment {

    private String description;
    private TextView textView;
    private RecyclerView commentList;
    private ImageView avatar;
    private EditText comment;
    private ImageButton sendButton;
    private List<Comment> listOfComment = new ArrayList<Comment>();
    private long comicId;

    public DescriptionFragment(String description, long comicId) {
        this.description = description;
        this.comicId= comicId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String email = SharedPrefs.getInstance().get("email", String.class);
        textView = view.findViewById(R.id.description);
        commentList = view.findViewById(R.id.comment_list);
        avatar = view.findViewById(R.id.comment_avatar);
        comment = view.findViewById(R.id.comment_edit_text);
        sendButton = view.findViewById(R.id.send_button);
        requestAvatar();
        textView.setText(description);
        RecycleViewCommentAdapter adapter = new RecycleViewCommentAdapter(this.getContext(), listOfComment);
        requestComment(adapter);
        commentList.setAdapter(adapter);
        commentList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentString = comment.getText().toString();
                try {
                    createComment(commentString, email, comicId, adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                comment.setText("");
            }
        });
    }

    public void requestAvatar() {
        String email = SharedPrefs.getInstance().get("email", String.class);
        String token = SharedPrefs.getInstance().get("token", String.class);
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.43.52:8080/api/profile/" + email;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                User user = new Gson().fromJson(response, User.class);
                Picasso.get().load(user.getAvatar()).transform(new CropCircleTransformation()).into(avatar);
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

    private void createComment(String comment, String email, long comicId, RecycleViewCommentAdapter adapter) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        String token = SharedPrefs.getInstance().get("token", String.class);
        jsonObject.put("comment", comment);
        jsonObject.put("email", email);
        jsonObject.put("comic_id", comicId);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://192.168.43.52:8080/api/comment", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                requestComment(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
             //   String accessToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJzbG92ZXJzaW9uMkBnbWFpbC5jb20iLCJpYXQiOjE2MTA5NTQzOTcsImV4cCI6MTYxMTA0MDc5N30.GW47VExgU0AsQE2FEGwyclLJzr0j4tClkMRvkVVWgdbdXfs-ND6VJ2ElbnDnT9X7gMtO6QjucAhk1VqLOgO4wr6dJwA_nA8GNJrkiap3AwmDgPMzHIvoz61twZaK3_Y_tAOx9Ka-tTDu8k-yUlj4tdd2Gg0Ch_j9iou-Z_LoukqzMwgk03-Vwy1Lt9TFSWAg3FZqg8P2HNrDKOzKTa1wyfGyT9Z6CsLeDuzbGl7ucNBk0ZfmDoeGkvjI4v_fw2qb6Fw8KqYFmwTqbyYs1BewafMymf_Wn4a2Vd6pBynKkaKgVUURWcjPRFtw0Ec5X3hczdAmP62yCA_9XMbvqGEvgw";
                Map<String, String> header = new HashMap<String, String>();
                header.put("Authorization", "Bearer " + token);
                return header;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(jsonObjectRequest);
    }

    private void requestComment(RecycleViewCommentAdapter adapter) {
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.43.52:8080/api/comment/1";
        String token = SharedPrefs.getInstance().get("token", String.class);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Type listType = new TypeToken<ArrayList<Comment>>() {
                }.getType();
                List<Comment> temp;
                temp = new Gson().fromJson(response, listType);
                listOfComment.clear();
                listOfComment.addAll(temp);
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        }) {
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