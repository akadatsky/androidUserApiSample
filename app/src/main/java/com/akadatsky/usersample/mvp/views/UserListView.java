package com.akadatsky.usersample.mvp.views;

import com.akadatsky.usersample.model.User;
import com.arellomobile.mvp.MvpView;

import java.util.List;

public interface UserListView extends MvpView {

    void fillList(List<User> users);

    void showError(int textId);

}
