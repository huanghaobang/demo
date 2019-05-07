package com.example.demo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Timer;
import java.util.TimerTask;

public class friend_call_phone extends Activity {
    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friend_call_phone);

        final MediaPlayer mediaPlayer =MediaPlayer.create(this,R.raw.a1);
        final MediaPlayer mediaPlayer1 =MediaPlayer.create(getApplicationContext(),R.raw.boyfriend);
        mediaPlayer.start();




        ImageButton imageButton1=(ImageButton)findViewById(R.id.im_exit_call);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer1.stop();
                finish();
            }
        });

        ImageButton imageButton2=(ImageButton)findViewById(R.id.callll);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();

                mediaPlayer1.start();
            }
        });




    }
}

