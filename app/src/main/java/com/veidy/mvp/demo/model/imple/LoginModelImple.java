package com.veidy.mvp.demo.model.imple;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.veidy.mvp.demo.http.HttpUtil;
import com.veidy.mvp.demo.model.LoginModel;
import com.veidy.mvp.demo.model.OnLoginListener;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Description: 登录Model实现，这里主要是网络请求的操作。
 * Author:veidy
 * Date: 2015-03-02
 * Time: 11:42
 */
public class LoginModelImple implements LoginModel {

    @Override
    public void login(String name, String password, final OnLoginListener onLoginListener) {
        String url = "";
        RequestParams requestParams = new RequestParams();
        requestParams.put("name", name);
        requestParams.put("password", password);
        //网络请求
        HttpUtil.post(url, requestParams, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //登录成功
                String json = new String(responseBody);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    int code = 0;
                    code = jsonObject.getJSONObject("data").getInt("code");
                    //code=0 表示登录成功，code=1表示用户名错误，code=2表示密码错误
                    if (code == 0) {
                        onLoginListener.onSuccess();
                    } else if (code == 1) {
                        onLoginListener.onUsernameError();
                    } else if (code == 2) {
                        onLoginListener.onPasswordError();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                onLoginListener.onFailure();
            }
        });
    }
}
