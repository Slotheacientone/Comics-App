package com.example.comics_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.comics_app.model.LoginRequest;
import com.example.comics_app.model.LoginResponse;
import com.example.comics_app.service.ApiClient;
import com.example.comics_app.util.SharedPrefs;


import org.json.JSONException;

import java.util.concurrent.ExecutionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
        txtEmail = findViewById(R.id.editTextEmail);
        txtPassword = findViewById(R.id.editTextPassword);

    }

    public void onLogin(View view) throws ExecutionException, InterruptedException, JSONException {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();


        if (validate(email, password)) {
            submit(email, password);
        } else {
            Toast.makeText(this, "Email or password invalid!", Toast.LENGTH_LONG).show();
        }
    }


    private void submit(String email, String password) throws InterruptedException, JSONException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (response.isSuccessful()) {
                    new Handler().postDelayed(() -> {
                        SharedPrefs.getInstance().put("token", loginResponse.getToken());
                        SharedPrefs.getInstance().put("email", loginResponse.getEmail());
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }, 500);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Email or password invalid!", Toast.LENGTH_LONG).show();
            }
        });
    }


    public boolean validate(String email, String password) {
        if (email == null || password == null || password.length() < 6)
            return false;

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public void onRegisterClick(View View) {
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.fade_in);
    }


}




