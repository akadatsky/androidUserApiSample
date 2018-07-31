package com.akadatsky.usersample.mvp.presenters;

import android.util.Log;

import com.akadatsky.usersample.api.RetrofitClient;
import com.akadatsky.usersample.mvp.views.UserListView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class UserListPresenter extends MvpPresenter<UserListView> {

    public UserListPresenter() {
        fetchUsers();
    }

    private void fetchUsers() {
        RetrofitClient.getApiService()
                .getUsers()
                .doOnSuccess(response -> getViewState().fillList(response.getUsers()))
                .doOnError(throwable -> Log.i("asdf", "fail", throwable))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}