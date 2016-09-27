package com.veidy.mvp.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.veidy.mvp.demo.MainActivity;
import com.veidy.mvp.demo.R;
import com.veidy.mvp.demo.presenter.LoginPresenter;
import com.veidy.mvp.demo.view.LoginView;

public class LoginActivity extends BasePresenterActivity<LoginClass> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Class<LoginClass> getVuClass() {
        return LoginClass.class;
    }


}
