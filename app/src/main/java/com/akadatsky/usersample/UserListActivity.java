package com.akadatsky.usersample;

import android.content.Context;
import android.icu.lang.UScript;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.akadatsky.usersample.api.RetrofitClient;
import com.akadatsky.usersample.model.User;
import com.akadatsky.usersample.model.UserList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserListActivity extends AppCompatActivity {

    private ListView listView;
    private LayoutInflater mInflater;
    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

//        List<User> users = new ArrayList<>();
//        users.add(new User("Ivan"));
//        users.add(new User("Oleg"));
//        users.add(new User("Alex"));

        mInflater = LayoutInflater.from(this);

        listView = findViewById(R.id.listView);
        mAdapter = new UserAdapter(this);
        listView.setAdapter(mAdapter);


        fetchUsers();
    }

    private void fetchUsers() {
        Callback<UserList> callback = new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                fillList(response.body().getUsers());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.i("asdf", "test");

            }
        };
        RetrofitClient.getApiService().getUsers().enqueue(callback);
    }

    private void fillList(List<User> users) {
        mAdapter.clear();
        mAdapter.addAll(users);
    }

    private class UserAdapter extends ArrayAdapter<User> {

        private UserAdapter(@NonNull Context context) {
            super(context, 0);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.user, parent, false);
            }
            String item = getItem(position).getName();

            TextView text = convertView.findViewById(R.id.textView);
            text.setText(item);

            return convertView;
        }

    }

}
