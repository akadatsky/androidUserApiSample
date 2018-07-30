package com.akadatsky.usersample.mvp.presenters;

import com.akadatsky.usersample.mvp.views.LoginView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    public LoginPresenter() {
    }

    public void validate(String login, String password) {

        String loginError = null;
        String passwordError = null;

        if (login == null || login.isEmpty()) {
            loginError = "Login can't be empty";
        }

        if (password == null || password.length() < 6) {
            passwordError = "Password should be 6+ char";
        }

        if (loginError != null || passwordError != null) {
            getViewState().showFormError(loginError, passwordError);
            return;
        }


        if (login.equals("admin") && password.equals("123456")) {
            getViewState().openNext();
        } else {
            getViewState().loginFailed();
        }
    }

}
