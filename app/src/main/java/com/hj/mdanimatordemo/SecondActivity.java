package com.hj.mdanimatordemo;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import android.os.Build;
import android.view.View;

public class SecondActivity extends BaseActivity {


    @Override
    protected int LayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initData() {


//        tvBack.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onClick(View v) {
//                finish();
//                finishAfterTransition();
//
//            }
//        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAfterTransition(this);
    }
}
