package com.veidy.mvp.demo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.veidy.mvp.demo.MainActivity;
import com.veidy.mvp.demo.R;
import com.veidy.mvp.demo.presenter.LoginPresenter;
import com.veidy.mvp.demo.view.LoginView;
import com.veidy.mvp.demo.view.Vu;

public class LoginClass implements Vu ,View.OnClickListener, LoginView {
    View view;
    private Activity mContext;
    private EditText et_name;
    private EditText et_password;
    private Button btn_login;
    private LoginPresenter loginPresenter;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container,Activity context) {
        view = inflater.inflate(R.layout.activity_login,null);
        mContext = context;
        initViews();
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public View getView() {
        return view;
    }

    private void initViews() {
        et_name = (EditText) view.findViewById(R.id.et_name);
        et_password = (EditText) view.findViewById(R.id.et_password);
        btn_login = (Button) view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        et_name.setText("dfdfdsggd");
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.btn_login:
//                loginPresenter.login();
                Log.d("wgw_btn_login","===============");
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
                break;
            default:
                break;

        }
    }


    @Override
    public void moveToIndex() {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }
}
