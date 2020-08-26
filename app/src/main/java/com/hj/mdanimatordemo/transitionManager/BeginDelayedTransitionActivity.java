package com.hj.mdanimatordemo.transitionManager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hj.mdanimatordemo.R;

public class BeginDelayedTransitionActivity extends AppCompatActivity {

    private RelativeLayout rlRootView;
    private ImageView imageView;
    private boolean sizeChange, positionChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_delayed_transition);

        initView();

    }

    private void initView() {
        imageView = findViewById(R.id.begin_image);
        rlRootView = findViewById(R.id.rl_begin_change_layout);
        findViewById(R.id.btn_change_size).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                chagneSize();
            }
        });

        findViewById(R.id.btn_change_position).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                changePosition();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changePosition() {
        TransitionManager.beginDelayedTransition(rlRootView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        if(positionChange){
            layoutParams.gravity = Gravity.LEFT;
        } else {
            layoutParams.gravity = Gravity.RIGHT;
        }
        positionChange = !positionChange;
        imageView.setLayoutParams(layoutParams);


    }

    private int saveWidth;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void chagneSize() {
//        sizeChange
        TransitionManager.beginDelayedTransition(rlRootView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (sizeChange) {
            layoutParams.width = saveWidth;
        } else {
            saveWidth = layoutParams.width;
            layoutParams.width = 200;
        }
        sizeChange = !sizeChange;
        imageView.setLayoutParams(layoutParams);
    }
}
