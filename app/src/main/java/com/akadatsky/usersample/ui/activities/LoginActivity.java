package com.akadatsky.usersample.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akadatsky.usersample.R;
import com.akadatsky.usersample.mvp.presenters.LoginPresenter;
import com.akadatsky.usersample.mvp.views.LoginView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class LoginActivity extends MvpAppCompatActivity implements LoginView {

    @InjectPresenter
    LoginPresenter mLoginPresenter;

    private EditText loginView;
    private EditText passwordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginView = findViewById(R.id.loginView);
        passwordView = findViewById(R.id.passwordView);

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = loginView.getText().toString();
                String password = passwordView.getText().toString();
                mLoginPresenter.validate(login, password);
            }
        });
    }

    @Override
    public void openNext() {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Wrong login/password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFormError(String loginError, String passwordError) {
        loginView.setError(loginError);
        passwordView.setError(passwordError);
    }

}
