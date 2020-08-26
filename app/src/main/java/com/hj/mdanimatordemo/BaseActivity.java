package com.hj.mdanimatordemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    protected TextView tvBack;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforSetContentView();
        setContentView(R.layout.activity_base);

        tvBack = findViewById(R.id.tv_back);

        frameLayout = findViewById(R.id.fl_layout);
        frameLayout.addView(LayoutInflater.from(this).inflate(LayoutId(),frameLayout,false));
        initData();
    }


    protected void beforSetContentView(){

    }

    protected abstract void initData();

    protected abstract int LayoutId();


}
