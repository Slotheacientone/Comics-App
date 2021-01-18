package com.example.comics_app.service;

import com.example.comics_app.model.LoginRequest;
import com.example.comics_app.model.LoginResponse;
import com.example.comics_app.model.RegisterRequest;
import com.example.comics_app.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {


    @POST("api/auth/signin")
    Call<LoginResponse> userLogin(@Body LoginRequest request);

    @POST("api/auth/signup")
    Call<RegisterResponse> userRegister(@Body RegisterRequest request);


}
