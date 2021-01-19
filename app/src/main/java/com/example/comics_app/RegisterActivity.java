package com.example.comics_app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comics_app.model.LoginResponse;
import com.example.comics_app.model.RegisterRequest;
import com.example.comics_app.model.RegisterResponse;
import com.example.comics_app.service.ApiClient;

import org.json.JSONException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtName, txtEmail, txtPassword, txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        changeStatusBarColor();


        txtName = findViewById(R.id.editTextName);
        txtEmail = findViewById(R.id.editTextEmail);
        txtPassword = findViewById(R.id.editTextPassword);
        txtPhoneNumber = findViewById(R.id.editTextMobile);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    public void onRegister(View v) throws JSONException, InterruptedException {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String name = txtName.getText().toString();
        String phoneNumber = txtPhoneNumber.getText().toString();


        if (validate(email, password)) {
            submit(email, password, name, phoneNumber);
        } else {
            Toast.makeText(this, "Email invalid!", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validate(String email, String password) {
        if (email == null || password == null || password.length() < 6)
            return false;

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private void submit(String email, String password, String name, String phoneNumber) throws InterruptedException, JSONException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(email);
        registerRequest.setPassword(password);
        registerRequest.setName(name);
        registerRequest.setPhoneNumber(name);

        Call<RegisterResponse> registerResponseCall = ApiClient.getUserService().userRegister(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                RegisterResponse registerResponse = response.body();

                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, registerResponse.getFoo(), Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(() -> {
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }, 1000);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Register failed!", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(()->{
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }, 1000);
            }
        });
    }

}
