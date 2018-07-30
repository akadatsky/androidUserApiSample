package com.akadatsky.usersample.mvp.presenters;

import com.akadatsky.usersample.mvp.views.SplashView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {

    public SplashPresenter() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getViewState().openNext();
            }
        }).start();
    }

}
