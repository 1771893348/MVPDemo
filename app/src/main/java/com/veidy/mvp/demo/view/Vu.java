package com.veidy.mvp.demo.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface Vu {
    void init(LayoutInflater inflater,ViewGroup container,Activity context);
//    void init(LayoutInflater inflater,ViewGroup container);
    View getView();
}
