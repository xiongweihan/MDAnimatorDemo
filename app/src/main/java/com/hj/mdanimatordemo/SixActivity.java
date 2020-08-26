package com.hj.mdanimatordemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SixActivity extends AppCompatActivity {

    private ImageView iv_1_six,iv_2_six;
    private LinearLayout ll_1_six,ll_2_six;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        iv_1_six = findViewById(R.id.iv_1_six);
        iv_2_six = findViewById(R.id.iv_2_six);
        ll_1_six = findViewById(R.id.ll_1_six);
        ll_2_six = findViewById(R.id.ll_2_six);

//这个是通过资源文件指定过渡动画
//        getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_slide));
//        getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_slide));

        //这个是通过Java代码设置过渡动画
        final TransitionSet transitionSet = new TransitionSet();
        //Slide动画
        @SuppressLint("RtlHardcoded") Slide slide = new Slide(Gravity.LEFT);//从左侧进入
        slide.addTarget(R.id.iv_1_six);
        transitionSet.addTransition(slide);
//        //fade
//        Fade fade = new Fade();
//        fade.addTarget(R.id.iv_2_six);
//        fade.excludeChildren(android.R.id.statusBarBackground,true);
//        fade.excludeChildren(android.R.id.navigationBarBackground,true);
//        fade.excludeChildren(R.id.iv_1_six,true);
//        transitionSet.addTransition(fade);

        //Explode
        Explode explode = new Explode();
        explode.excludeTarget(android.R.id.statusBarBackground, true);
        explode.excludeTarget(android.R.id.navigationBarBackground, true);
        explode.excludeTarget(R.id.iv_1_six, true);
        transitionSet.addTransition(explode);

        transitionSet.setDuration(500);
        transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);//动画执行顺序:ORDERING_SEQUENTIAL--顺序执行；ORDERING_TOGETHER--一起执行
        getWindow().setEnterTransition(transitionSet);

        //监听
        transitionSet.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                ll_1_six.setVisibility(View.GONE);
                ll_2_six.setVisibility(View.GONE);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                ll_1_six.setVisibility(View.VISIBLE);
                ll_2_six.setVisibility(View.VISIBLE);
//                Animator topAnimator = ViewAnimationUtils.createCircularReveal(ll_1_six, ll_1_six.getWidth() / 2, ll_1_six.getHeight() / 2, 0,
//                        Math.max(ll_1_six.getWidth() / 2, ll_1_six.getHeight() / 2));
                Animator bottomAnimator = ViewAnimationUtils.createCircularReveal(ll_2_six,ll_2_six.getWidth() /2,ll_2_six.getHeight()/2,0,
                        Math.max(ll_2_six.getWidth() /2,ll_2_six.getHeight() /2));

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(bottomAnimator);//只有一个view时用这个
//                animatorSet.playTogether(topAnimator,bottomAnimator);
                animatorSet.setDuration(1000);
                animatorSet.start();

                ll_1_six.animate().alpha(1).setDuration(1000).start();//


                transitionSet.removeListener(this);

            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }
}
