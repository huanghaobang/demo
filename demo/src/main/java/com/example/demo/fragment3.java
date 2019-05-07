package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

/**
 * Created by WangChang on 2016/5/15.
 */
public class fragment3 extends Fragment {
    /*MapView mapView=null;*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*SDKInitializer.initialize(getActivity().getApplicationContext());*/
        View view = inflater.inflate(R.layout.set_time, container, false);
        /*mapView=(MapView)view.findViewById(R.id.bmapView);*/



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton imageButton1, imageButton2;

        ImageButton save1 = (ImageButton) getActivity().findViewById(R.id.startsave);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), saving1.class);
                startActivity(intent);
            }
        });



        Button button;
        button=(Button)getActivity().findViewById(R.id.add_friend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), add_friend.class);
                startActivity(intent);
            }
        });


    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        tv.setText(getArguments().getString("ARGS"));
    }

    public static fragment3 newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        fragment3 fragment = new fragment3();
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}