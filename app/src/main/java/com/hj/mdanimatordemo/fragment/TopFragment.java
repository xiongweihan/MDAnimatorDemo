package com.hj.mdanimatordemo.fragment;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hj.mdanimatordemo.R;


public class TopFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TopFragment() {

    }

    public static TopFragment newInstance() {
        TopFragment fragment = new TopFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);

        final ImageView imageView = view.findViewById(R.id.iv_5);

        view.findViewById(R.id.btn_next_1).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                addNextFragment(imageView, false);
            }
        });
        view.findViewById(R.id.btn_next_2).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                addNextFragment(imageView, true);

            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void addNextFragment(ImageView imageView, boolean overlap) {
        TopTwoFragment fragment2 = TopTwoFragment.newInstance();

        //给fragment2 定义入场动画1
        Fade fade = new Fade(Fade.MODE_IN);
        fade.setDuration(1000);
//        fragment2.setEnterTransition(fade);

        //给fragment2 定义入场动画2
        Explode explode = new Explode();
        explode.setDuration(1000);
        fragment2.setEnterTransition(explode);//入场动画
        fragment2.setReturnTransition(fade); //退场动画


        //这是共享动画
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(300);
        fragment2.setSharedElementEnterTransition(changeBounds);

        //可以通过设置setAllowEnterTransitionOverlap(overlap);
        // 中的overlap的值为true或者false来允许或者不允许进场动画和出场动画重叠。
        fragment2.setAllowEnterTransitionOverlap(overlap);
        fragment2.setAllowReturnTransitionOverlap(overlap);


        assert getFragmentManager() != null;
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, fragment2)
                .addToBackStack(null)
                .addSharedElement(imageView, imageView.getTransitionName())
                .commit();
    }


}
