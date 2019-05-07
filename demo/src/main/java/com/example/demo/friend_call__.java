package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class friend_call__ extends Activity {
    private MediaPlayer player;
    private MediaPlayer player1;
    private MediaPlayer player2;

    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.friend_call_);
        ImageButton Button1=findViewById(R.id.friend_call_exit);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        player=MediaPlayer.create( friend_call__.this,R.raw.boyfriend);
        player1=MediaPlayer.create( friend_call__.this,R.raw.friend_girl);
        player2=MediaPlayer.create( friend_call__.this,R.raw.friendly_girl);



        ImageButton bt1=(ImageButton)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player2.stop();
                player1.stop();
                player.stop();
                player=MediaPlayer.create( friend_call__.this,R.raw.boyfriend);
                player.start();
            }
        });

        ImageButton bt2=(ImageButton)findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player2.stop();
                player.stop();
                player1.stop();
                player1=MediaPlayer.create( friend_call__.this,R.raw.friend_girl);


                player1.start();

            }
        });

        ImageButton bt3=(ImageButton)findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player.stop();
                player1.stop();
                player2.stop();
                player2=MediaPlayer.create( friend_call__.this,R.raw.friendly_girl);

                player2.start();

            }
        });

        ImageButton bt4=(ImageButton)findViewById(R.id.luzhi);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(friend_call__.this, luzhi.class);
                startActivity(intent);
            }
        });

        Button bt33=(Button)findViewById(R.id.more);
        bt33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(friend_call__.this, more.class);
                startActivity(intent);
            }
        });






    }
}
