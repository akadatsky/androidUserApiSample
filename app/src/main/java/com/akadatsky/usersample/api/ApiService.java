package com.akadatsky.usersample.api;

import com.akadatsky.usersample.model.UserList;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("user")
    Single<UserList> getUsers();

}