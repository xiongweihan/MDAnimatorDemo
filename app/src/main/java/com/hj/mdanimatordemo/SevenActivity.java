package com.hj.mdanimatordemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.hj.mdanimatordemo.transitionManager.AutoTransitionActivity;
import com.hj.mdanimatordemo.transitionManager.BeginDelayedTransitionActivity;
import com.hj.mdanimatordemo.transitionManager.ChangeBoundsActivity;
import com.hj.mdanimatordemo.transitionManager.ChangeClipBoundsActivity;
import com.hj.mdanimatordemo.transitionManager.ChangeImageTransformActivity;
import com.hj.mdanimatordemo.transitionManager.ChangeTransformActivity;

/**
 * 使用 TransitionManager.go(); 方法进行view的动画过渡，
 * ps:所选的view 必须id一致 。切记
 */
public class SevenActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        initView();
    }

    private void initView() {
        findViewById(R.id.AutoTransition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivity.this, AutoTransitionActivity.class));
            }
        });

        findViewById(R.id.ChangeBounds).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivity.this, ChangeBoundsActivity.class));
            }
        });

        findViewById(R.id.ChangeTransform).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivity.this, ChangeTransformActivity.class));
            }
        });
        findViewById(R.id.ChangeClipBounds).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivity.this, ChangeClipBoundsActivity.class));
            }
        });
        findViewById(R.id.ChangeImageTransform).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivity.this, ChangeImageTransformActivity.class));

            }
        });
        findViewById(R.id.Fade).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fadeIntent = new Intent(SevenActivity.this, ChangeBoundsActivity.class);
                fadeIntent.putExtra("source",1);
                startActivity(fadeIntent);
            }
        });
        findViewById(R.id.Slide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent slideIntent = new Intent(SevenActivity.this, ChangeBoundsActivity.class);
                slideIntent.putExtra("source",2);
                startActivity(slideIntent);


            }
        });
        findViewById(R.id.Explode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explodeIntent = new Intent(SevenActivity.this, ChangeBoundsActivity.class);
                explodeIntent.putExtra("source",3);
                startActivity(explodeIntent);

            }
        });
        findViewById(R.id.more_aninor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explodeIntent = new Intent(SevenActivity.this, ChangeBoundsActivity.class);
                explodeIntent.putExtra("source",4);
                startActivity(explodeIntent);
            }
        });

        findViewById(R.id.tv_begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SevenActivity.this, BeginDelayedTransitionActivity.class));
            }
        });
    }



}
