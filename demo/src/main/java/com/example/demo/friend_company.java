package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class friend_company extends Activity {

    int i1=0;
    ImageButton imageButton1;
    ImageButton imageButton2;

    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friend_company);
        imageButton1=(ImageButton) findViewById(R.id.set_time);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(friend_company.this,set_time.class);
                startActivity(intent);
            }
        });
        imageButton2=(ImageButton) findViewById(R.id.set_friend);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*System.exit(0);*/
                finish();
            }
        });





    }
}
