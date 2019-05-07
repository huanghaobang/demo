package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class startsave extends Activity {

    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.startsave);
        Button button =(Button) findViewById(R.id.exit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton imageButton1=(ImageButton)findViewById(R.id.setting);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(startsave.this,save_setting.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton2=(ImageButton)findViewById(R.id.fsave);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.setClass(startsave.this,saving.class);
                startActivity(intent1);
            }
        });


    }

}
