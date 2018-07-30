package com.akadatsky.usersample.ui.activities;

import android.os.Bundle;
import android.widget.ListView;

import com.akadatsky.usersample.R;
import com.akadatsky.usersample.model.User;
import com.akadatsky.usersample.mvp.presenters.UserListPresenter;
import com.akadatsky.usersample.mvp.views.UserListView;
import com.akadatsky.usersample.ui.adapters.UserAdapter;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

public class UserListActivity extends MvpAppCompatActivity implements UserListView {

    @InjectPresenter
    UserListPresenter mUserListPresenter;

    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ListView listView = findViewById(R.id.listView);
        mAdapter = new UserAdapter(this);
        listView.setAdapter(mAdapter);
    }

    @Override
    public void fillList(List<User> users) {
        mAdapter.clear();
        mAdapter.addAll(users);
    }

}
