package com.hj.mdanimatordemo.transitionManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.RelativeLayout;

import com.hj.mdanimatordemo.R;

public class ChangeTransformActivity extends AppCompatActivity {
    private RelativeLayout mSceneRootView;
    private Scene sceneStart, sceneEnd;
    private boolean isinitialState;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_transform);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {
        mSceneRootView = findViewById(R.id.fl_layout_seven);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                initSence();
            }
        });


        sceneStart = Scene.getSceneForLayout(mSceneRootView, R.layout.layout_login_one, this);
        sceneEnd = Scene.getSceneForLayout(mSceneRootView, R.layout.layout_login_two, this);
        /**
         * 切换到开始场景状态
         */
        TransitionManager.go(sceneStart);
        isinitialState = true;

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initSence() {
        TransitionManager.go(isinitialState ? sceneEnd : sceneStart, new ChangeTransform());
        isinitialState = !isinitialState;
    }
}
