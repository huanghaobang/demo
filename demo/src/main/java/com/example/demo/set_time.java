package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class set_time extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.set_time);
        ImageButton imageButton1, imageButton2;
        imageButton1 = (ImageButton) findViewById(R.id.startsave);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(set_time.this, saving1.class);
                startActivity(intent);
            }
        });



        Button button;
        button=(Button)findViewById(R.id.add_friend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(set_time.this, add_friend.class);
                startActivity(intent);
            }
        });

    }
}
