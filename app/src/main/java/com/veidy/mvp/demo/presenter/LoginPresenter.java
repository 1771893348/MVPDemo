package com.veidy.mvp.demo.presenter;

import com.veidy.mvp.demo.model.LoginModel;
import com.veidy.mvp.demo.model.OnLoginListener;
import com.veidy.mvp.demo.model.imple.LoginModelImple;
import com.veidy.mvp.demo.view.LoginView;

/**
 * Description: 主导器处理model的view
 * Author:veidy
 * Date: 2015-03-02
 * Time: 11:39
 */
public class LoginPresenter implements OnLoginListener {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImple();
    }


    public void login() {
        String name = loginView.getName();
        String password = loginView.getPassword();
        loginModel.login(name, password, this);
    }

    @Override
    public void onUsernameError() {
        loginView.showToast("用户名错误");
    }

    @Override
    public void onPasswordError() {
        loginView.showToast("密码错误");
    }

    @Override
    public void onSuccess() {
        loginView.moveToIndex();
    }

    @Override
    public void onFailure() {
        loginView.showToast("请求失败");
    }
}
