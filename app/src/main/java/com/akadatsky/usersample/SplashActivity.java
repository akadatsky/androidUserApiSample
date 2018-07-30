package com.akadatsky.usersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akadatsky.usersample.mvp.presenters.SplashPresenter;
import com.akadatsky.usersample.mvp.views.SplashView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void openNext() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
