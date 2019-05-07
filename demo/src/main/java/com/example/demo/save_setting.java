package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class save_setting extends Activity {
    int i1=0;
    ImageButton imageButton1;
    Button button;

    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.save_setting);
        ImageButton imageButton0=(ImageButton) findViewById(R.id.re_set);
        imageButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*System.exit(0);*/
                finish();
            }
        });
        final ImageButton ib1,ib2,ib3,ib4,ib5,ib6;
        ib1=(ImageButton)findViewById(R.id.ibt1);
        ib1.setOnClickListener(new View.OnClickListener() {
            boolean isChanged = true;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isChanged){
                    ib1.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }else {
                    ib1.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                    isChanged = !isChanged;

                }
            });

        ib2=(ImageButton)findViewById(R.id.ibt2);
        ib2.setOnClickListener(new View.OnClickListener() {
            boolean isChanged = true;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isChanged){
                    ib2.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }else {
                    ib2.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                isChanged = !isChanged;

            }
        });

        ib3=(ImageButton)findViewById(R.id.ibt3);
        ib3.setOnClickListener(new View.OnClickListener() {
            boolean isChanged = true;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isChanged){
                    ib3.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }else {
                    ib3.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                isChanged = !isChanged;

            }
        });

        ib4=(ImageButton)findViewById(R.id.ibt4);
        ib4.setOnClickListener(new View.OnClickListener() {
            boolean isChanged = true;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isChanged){
                    ib4.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }else {
                    ib4.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                isChanged = !isChanged;

            }
        });

        ib5=(ImageButton)findViewById(R.id.ibt5);
        ib5.setOnClickListener(new View.OnClickListener() {
            boolean isChanged = true;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isChanged){
                    ib5.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }else {
                    ib5.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                isChanged = !isChanged;

            }
        });

        ib6=(ImageButton)findViewById(R.id.ibt6);
        ib6.setOnClickListener(new View.OnClickListener() {
            boolean isChanged = true;
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(isChanged){
                    ib6.setImageDrawable(getResources().getDrawable(R.drawable.off));
                }else {
                    ib6.setImageDrawable(getResources().getDrawable(R.drawable.on));
                }
                isChanged = !isChanged;

            }
        });
    }







}
