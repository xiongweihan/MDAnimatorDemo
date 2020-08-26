package com.hj.mdanimatordemo.transitionManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.RelativeLayout;

import com.hj.mdanimatordemo.R;

public class ChangeBoundsActivity extends AppCompatActivity {

    private RelativeLayout mSceneRootView;
    private Scene sceneStart, sceneEnd;
    private boolean isinitialState;
    private int source;//来源，默认是ChangeBounds， 1--Fade， 2--Slide。 3--Explode :4--组合

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_bounds);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {
        source = getIntent().getIntExtra("source", 0);

        mSceneRootView = findViewById(R.id.fl_layout_seven);

        sceneStart = Scene.getSceneForLayout(mSceneRootView, R.layout.layout_login_one, this);
        sceneEnd = Scene.getSceneForLayout(mSceneRootView, R.layout.layout_login_two, this);
        /**
         * 切换到开始场景状态
         */
        TransitionManager.go(sceneStart);
        isinitialState = true;

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                initSence();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initSence() {
        switch (source) {// 1--Fade， 2--Slide。 3--Explode
            case 1:
                TransitionManager.go(isinitialState ? sceneEnd : sceneStart, new Fade());

                break;
            case 2:
                //实现方法1：直接new 出来
//                TransitionManager.go(isinitialState ? sceneEnd : sceneStart, new Slide());

                //方法2： 通过xml文件进行设置
                Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.transition_slide);
                TransitionManager.go(isinitialState ? sceneEnd : sceneStart, slide);
                break;
            case 3:
                TransitionManager.go(isinitialState ? sceneEnd : sceneStart, new Explode());
                break;
            case 4:
                // 通过xml文件进行设置
                Transition zuhe = TransitionInflater.from(this).inflateTransition(R.transition.zuhe);
                TransitionManager.go(isinitialState ? sceneEnd : sceneStart, zuhe);
                break;
            default:
                TransitionManager.go(isinitialState ? sceneEnd : sceneStart, new ChangeBounds());
                break;
        }
        isinitialState = !isinitialState;
    }
}
