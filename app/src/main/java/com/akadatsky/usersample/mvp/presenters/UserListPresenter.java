package com.akadatsky.usersample.mvp.presenters;

import android.annotation.SuppressLint;

import com.akadatsky.usersample.R;
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

    @SuppressLint("CheckResult")
    private void fetchUsers() {
        RetrofitClient.getApiService()
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> getViewState().fillList(response.getUsers()),
                        throwable -> getViewState().showError(R.string.request_failed));
    }

}
