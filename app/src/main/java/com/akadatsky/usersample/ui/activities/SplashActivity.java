package com.akadatsky.usersample.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.akadatsky.usersample.R;
import com.akadatsky.usersample.mvp.presenters.SplashPresenter;
import com.akadatsky.usersample.mvp.views.SplashView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SplashPresenter mSplashPresenter;

    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return new SplashPresenter(this.getApplicationContext());
    }

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
