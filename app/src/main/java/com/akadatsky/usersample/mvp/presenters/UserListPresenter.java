package com.akadatsky.usersample.mvp.presenters;

import android.util.Log;

import com.akadatsky.usersample.api.RetrofitClient;
import com.akadatsky.usersample.model.User;
import com.akadatsky.usersample.model.UserList;
import com.akadatsky.usersample.mvp.views.UserListView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class UserListPresenter extends MvpPresenter<UserListView> {

    public UserListPresenter() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan"));
        users.add(new User("Oleg"));
        users.add(new User("Alex"));

        //fetchUsers();
        getViewState().fillList(users);
    }

    private void fetchUsers() {
        Callback<UserList> callback = new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                getViewState().fillList(response.body().getUsers());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.i("asdf", "test");

            }
        };
        RetrofitClient.getApiService().getUsers().enqueue(callback);
    }

}
