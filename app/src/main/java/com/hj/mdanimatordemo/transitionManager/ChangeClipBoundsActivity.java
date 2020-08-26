package com.hj.mdanimatordemo.transitionManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeClipBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hj.mdanimatordemo.R;

public class ChangeClipBoundsActivity extends AppCompatActivity {
    private ViewGroup mSceneRootView;
    private Scene sceneStart, sceneEnd;
    private boolean isinitialState;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_clip_bounds);
        mSceneRootView = findViewById(R.id.fl_layout_seven);
        initData();

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                initSecen();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initSecen() {
/**
 * 不指定默认就是AutoTransition
 */
        TransitionManager.go(isinitialState ? sceneEnd : sceneStart, new ChangeClipBounds());
        isinitialState = !isinitialState;
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void initData() {
        View startView = LayoutInflater.from(this).inflate(R.layout.scene_change_clip_bounds_start, mSceneRootView, false);
        startView.findViewById(R.id.image_change_clip_bounds).setClipBounds(new Rect(100, 100, 300, 300));
        View endView = LayoutInflater.from(this).inflate(R.layout.scene_change_clip_bounds_end, mSceneRootView, false);
        endView.findViewById(R.id.image_change_clip_bounds).setClipBounds(new Rect(300,300,800,800));
        sceneStart = new Scene(mSceneRootView,startView);
        sceneEnd = new Scene(mSceneRootView, endView);

        TransitionManager.go(sceneStart);
        isinitialState = true;
    }
}
