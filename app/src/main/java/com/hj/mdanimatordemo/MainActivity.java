package com.hj.mdanimatordemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 这个项目是为了学习activity 跳转风格动画的学习德莫，学习链接如下
 * https://www.jianshu.com/p/6c42a7157781
 * <p>
 * ActivityOptionsCompat--新的activity过度机制
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private View iv_1, iv_2, iv_3, iv_4, iv_5,iv_6;
    private View tv_v5_title;
    private Button btn_sence_1;

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void initData() {
//        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_slide));
//        getWindow().setReenterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_slide));
        iv_1 = findViewById(R.id.iv_1);
        iv_1.setOnClickListener(this);
        iv_2 = findViewById(R.id.iv_2);
        iv_2.setOnClickListener(this);
        iv_3 = findViewById(R.id.iv_3);
        iv_3.setOnClickListener(this);
        iv_4 = findViewById(R.id.iv_4);
        iv_4.setOnClickListener(this);
        iv_5 = findViewById(R.id.iv_5);
        iv_5.setOnClickListener(this);
        tv_v5_title = findViewById(R.id.tv_v5_title);
        tv_v5_title.setOnClickListener(this);

        iv_6 = findViewById(R.id.iv_6);
        iv_6.setOnClickListener(this);

        btn_sence_1 = findViewById(R.id.btn_sence_1);
        btn_sence_1.setOnClickListener(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.iv_1:
//                intent = new Intent(this, SecondActivity.class);
//                startActivity(intent);
                /**
                 * 三个参数，第一个是指当前activity，第二个和第三个参数分别是进入动画和退出动画，
                 * 需要注意的是我们启动activity的方式是使用ActivityCompat.startActivity，
                 * 最后一个参数我们使用compat.toBundle。
                 */
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.activity_in_anim, R.anim.activity_out_anim);
                intent = new Intent(this, SecondActivity.class);
                ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());

                break;
            case R.id.iv_2:
                /**
                 * 第1个参数是scale哪个view的大小，
                 * 第2和3个参数是以view为基点，从哪开始动画，这里是该view的中心，
                 * 4和5参数是新的activity从多大开始放大，这里是从无到有的过程。
                 */
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeScaleUpAnimation(iv_2, iv_2.getWidth() / 2, iv_2.getHeight() / 2, 0, 1);
                intent = new Intent(MainActivity.this, ThirdActivity.class);
                ActivityCompat.startActivity(MainActivity.this, intent, compat.toBundle());
                break;
            case R.id.iv_3:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_head_2);
                ActivityOptionsCompat compat1 = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(iv_3, bitmap, iv_3.getWidth() / 2, iv_3.getHeight() / 2);
                intent = new Intent(MainActivity.this, ThirdActivity.class);
                ActivityCompat.startActivity(MainActivity.this, intent, compat1.toBundle());

                break;
            case R.id.iv_4:
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeClipRevealAnimation(iv_4, iv_4.getWidth() / 2, iv_4.getHeight() / 2, 50, 50);
                intent = new Intent(MainActivity.this, FourthActivity.class);
                ActivityCompat.startActivity(this, intent, activityOptionsCompat.toBundle());

                break;
            case   R.id.iv_5:
                //  单个共享view
                ActivityOptionsCompat optionsCompat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                        iv_5,iv_5.getTransitionName());
                intent = new Intent(MainActivity.this, FiveActivity.class);
                ActivityCompat.startActivity(MainActivity.this, intent,optionsCompat1.toBundle());
                break;
            case R.id.tv_v5_title:
//                //多个共享View联动
                Pair<View, String> pair1 = Pair.create(iv_5, getResources().getString(R.string.transitionName));
                Pair<View, String> pair2 = Pair.create(tv_v5_title, getResources().getString(R.string.text_transitionName));
                ActivityOptionsCompat optionsCompat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pair1, pair2);
                intent = new Intent(MainActivity.this, FiveActivity.class);
                ActivityCompat.startActivity(MainActivity.this, intent, optionsCompat2.toBundle());
                break;

            case R.id.iv_6:
                intent = new Intent(MainActivity.this,SixActivity.class);
                ActivityCompat.startActivity(MainActivity.this,intent,  ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btn_sence_1:
                intent = new Intent(MainActivity.this,SevenActivity.class);
                startActivity(intent);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
