package com.akadatsky.usersample.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface LoginView extends MvpView {

    void showFormError(String loginError, String passwordError);

    void openNext();

    @StateStrategyType(SkipStrategy.class)
    void loginFailed();
}
