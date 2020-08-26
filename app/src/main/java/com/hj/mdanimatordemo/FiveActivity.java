package com.hj.mdanimatordemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;

import com.hj.mdanimatordemo.fragment.TopFragment;

public class FiveActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        setupWindowAnimations();
        addFragment();

    }

    /**
     * 这里设置的都是fragment1与fragment2之间的切换动画
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addFragment() {
        //位fragment1 定义动画
        Slide slide = new Slide(Gravity.LEFT);
        slide.setDuration(1000);
        //创建fragment1 ，并为他定义一些动画
        TopFragment fragment1 = TopFragment.newInstance();
        fragment1.setReenterTransition(slide);//重新返回该fragment1时的动画
        Explode explode = new Explode();
        fragment1.setExitTransition(explode);//fragment1跳到2时，1 的退场动画

        //为目标试图的布局边界的变化添加动画
        fragment1.setSharedElementEnterTransition(new ChangeBounds());
        // 为目标视图的裁剪边界的变化添加动画。
//         fragment1.setSharedElementEnterTransition(new ChangeClipBounds());
        // 为目标视图的缩放与旋转变化添加动画。
//         fragment1.setSharedElementEnterTransition(new ChangeTransform());
        // 为目标图像的大小与缩放变化添加动画。
        // fragment1.setSharedElementEnterTransition(new ChangeImageTransform());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment1).commit();

    }

    /**
     * 这里设置的是进入该activity 的页面切换动画
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        // 我们不想定义新的 Enter Transition。
        // 只更改默认的过渡持续时间
        getWindow().getEnterTransition().setDuration(500);

        //定义除了共享元素外的控件，从左侧划入
//        Slide slide = new Slide();
//        slide.setSlideEdge(Gravity.LEFT);
//        getWindow().setEnterTransition(slide);
        //定义除了共享元素外的控件，从四周向场景中心移入/（退出反向移出）
        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setEnterTransition(explode);//进入activity时的动画

        getWindow().setReturnTransition(new Fade());//退出activity时的动画
    }
}
