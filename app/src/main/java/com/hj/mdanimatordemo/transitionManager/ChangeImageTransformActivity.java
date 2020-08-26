package com.hj.mdanimatordemo.transitionManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.hj.mdanimatordemo.R;

public class ChangeImageTransformActivity extends AppCompatActivity {


    private ViewGroup mSceneRootView;
    private Scene sceneStart,sceneEnd;
    private boolean isinitialState;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_image_transform);

        mSceneRootView = findViewById(R.id.fl_layout_seven);

        initData();

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                initScene();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initData() {
        sceneStart = Scene.getSceneForLayout(mSceneRootView,R.layout.item_change_image_transform_start,this);
        sceneEnd = Scene.getSceneForLayout(mSceneRootView,R.layout.item_change_image_transform_end,this);

        TransitionManager.go(sceneStart);
        isinitialState = true;

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initScene() {
        TransitionManager.go(isinitialState? sceneEnd: sceneStart,new ChangeImageTransform());
        isinitialState = !isinitialState;

    }
}
