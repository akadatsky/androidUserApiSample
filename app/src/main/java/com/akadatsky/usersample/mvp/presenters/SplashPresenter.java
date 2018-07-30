package com.akadatsky.usersample.mvp.presenters;

import android.content.Context;
import android.content.Intent;

import com.akadatsky.usersample.LoginActivity;
import com.akadatsky.usersample.mvp.views.SplashView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    private Context mContext;

    public SplashPresenter(Context context) {
        mContext = context;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //getViewState().openNext();
                openNext();
            }
        }).start();
    }

    private void openNext() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

}
