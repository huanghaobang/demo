package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class are_you_ok extends Activity {

    private TextView mTvShow;
    @Override
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.are_you_ok);
        ImageButton iButton1=(ImageButton) findViewById(R.id.yes);
        iButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("safe",1);
                timer.cancel();
                finish();
            }
        });

        mTvShow = (TextView) findViewById(R.id.showtime1);
        timer.start();








    }

    private CountDownTimer timer = new CountDownTimer(10000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            mTvShow.setText((millisUntilFinished / 1000) + "秒");
        }

        @Override
        public void onFinish() {
            mTvShow.setEnabled(true);
            /*mTvShow.setText(positionText.getText());*/
            SmsManager sm = SmsManager.getDefault();
            Intent i=getIntent();
            Intent intent=new Intent();
            intent.putExtra("safe",0);

            List<String> sms = sm.divideMessage(i.getStringExtra("data"));
            for (String smslist :sms){
                sm.sendTextMessage("17376567177",null,smslist,null,null);
            }
        }
    };
}
