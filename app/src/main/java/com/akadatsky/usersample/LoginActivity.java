package com.akadatsky.usersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

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
                validate();
            }
        });


    }

    private void validate() {
        String login = loginView.getText().toString();
        String password = passwordView.getText().toString();

        if (login == null || login.isEmpty()) {
            loginView.setError(getString(R.string.empty_login));
            return;
        }

        if (password == null || password.isEmpty()) {
            passwordView.setError("Password can't be empty");
            return;
        }

        if (password.length() < 6) {
            passwordView.setError("Password should be 6+ char");
            return;
        }

        if (login.equals("admin") && password.equals("123456")) {
            openNext();
            finish();
        } else {
            Toast.makeText(this, "Wrong login/password", Toast.LENGTH_SHORT).show();
        }

    }

    private void openNext() {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

}
