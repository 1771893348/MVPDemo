package com.veidy.mvp.demo.activity;import android.app.Activity;import android.os.Bundle;import com.veidy.mvp.demo.view.Vu;public abstract class BasePresenterActivity<V extends Vu> extends Activity{    private V vu;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        try {            vu = getVuClass().newInstance();            vu.init(getLayoutInflater(),null,this);            setContentView(vu.getView());            onBindVu();        }catch (Exception e){            e.printStackTrace();        }    }    @Override    protected void onStart() {        super.onStart();    }    @Override    protected void onPause() {        super.onPause();    }    @Override    protected void onStop() {        super.onStop();    }    @Override    protected void onDestroy() {        super.onDestroy();    }    protected abstract Class<V> getVuClass();    protected void onBindVu(){};    protected void onDestroyVu() {};}