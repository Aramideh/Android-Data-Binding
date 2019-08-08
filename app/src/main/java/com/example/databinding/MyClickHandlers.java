package com.example.databinding;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;


public class MyClickHandlers extends BaseObservable {

    Context context;

    public void setOnFabClickedListener(com.example.databinding.OnFabClickedListener onFabClickedListener) {
        OnFabClickedListener = onFabClickedListener;
    }

    OnFabClickedListener OnFabClickedListener;

    public MyClickHandlers(Context context) {
        this.context = context;
    }

    public void onFabClicked(View view) {
        Toast.makeText( context, "FAB clicked!", Toast.LENGTH_SHORT).show();
        OnFabClickedListener.onClick();
    }

    public void onFabClicked2(View view , Student student) {
        Toast.makeText(context, "Passing  "+student.name+" "+student.family, Toast.LENGTH_SHORT).show();
        OnFabClickedListener.onClick();
    }

    public void onButtonClick(View view) {
        Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show();
    }


    public void onButtonClickWithParam(View view, Student student) {
        Toast.makeText( context, "Button clicked! Name: " + student.name, Toast.LENGTH_SHORT).show();
    }


    public boolean onButtonLongPressed(View view) {
        Toast.makeText( context, "Button long pressed!", Toast.LENGTH_SHORT).show();
        return false;
    }
}


