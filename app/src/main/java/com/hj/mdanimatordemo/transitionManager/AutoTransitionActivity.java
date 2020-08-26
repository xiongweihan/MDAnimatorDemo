package com.hj.mdanimatordemo.transitionManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hj.mdanimatordemo.R;

public class AutoTransitionActivity extends AppCompatActivity {
    private Button btnLogin;
    private ViewGroup mSceneRootView;
    private Scene sceneStart;
    private Scene sceneEnd;
    private boolean isinitialState;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_transition);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {
        btnLogin = findViewById(R.id.btn_login);
        mSceneRootView = findViewById(R.id.fl_layout_seven);


        sceneStart = Scene.getSceneForLayout(mSceneRootView, R.layout.layout_login_one, this);
        sceneEnd = Scene.getSceneForLayout(mSceneRootView, R.layout.layout_login_two, this);
        /**
         * 切换到开始场景状态
         */
        TransitionManager.go(sceneStart);
        isinitialState = true;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                initScene();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initScene() {
        TransitionManager.go(isinitialState ? sceneEnd : sceneStart);
//        TransitionManager.go(isinitialState ? sceneEnd : sceneStart,new ChangeBounds());
//        TransitionManager.go(isinitialState ? sceneEnd : sceneStart,new ChangeClipBounds());
        isinitialState = !isinitialState;
    }
}
