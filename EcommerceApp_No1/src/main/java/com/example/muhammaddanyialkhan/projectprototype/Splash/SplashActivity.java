package com.example.muhammaddanyialkhan.projectprototype.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.muhammaddanyialkhan.projectprototype.R;
import com.example.muhammaddanyialkhan.projectprototype.Utility.SharedPereferenceUtils;
import com.example.muhammaddanyialkhan.projectprototype.home.HomeActivity;
import com.example.muhammaddanyialkhan.projectprototype.login.SigninActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    public void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //if user id registered then redirect to home screen
                //else redirect to login screen
                if(SharedPereferenceUtils.getInstance().getString("hello").equalsIgnoreCase("")){
                    Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
                    startActivity(intent);
                }else
                {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 3000);
    }
}
