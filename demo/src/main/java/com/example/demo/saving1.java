package com.example.demo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class saving1 extends Activity {
    private TextView mTvShow;
    public LocationClient mLocationClient;
    private MapView mMapView=null;

    private BaiduMap baiduMap;
    private boolean firstLocation;
    private BitmapDescriptor mCurrentMarker;
    private MyLocationConfiguration config;

    private TextView positionText;//dizhi
    @Override
    protected  void onCreate(Bundle saveInstanceState){
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate(saveInstanceState);


        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.saving);
        positionText = (TextView) findViewById(R.id.position_text_view);
        List<String> permissionList = new ArrayList<>();
        /*if (ContextCompat.checkSelfPermission(saving1.this, Manifest.
                permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(saving1.this,Manifest.
                permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(saving1.this,Manifest.
                permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()){
            String [] permissions = permissionList.toArray(new String[permissionList.
                    size()]);
            ActivityCompat.requestPermissions(saving1.this,permissions,1);
        } else {
            requestLocation();
        }*/
        requestLocation();

        ImageButton imageButton2;
        imageButton2=(ImageButton) findViewById(R.id.stop_save);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*System.exit(0);*/
                timer.cancel();
                finish();
            }
        });

        Button Button2;
        Button2=(Button) findViewById(R.id.now_nervious);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*System.exit(0);*/
                sos();
            }
        });

        mTvShow = (TextView) findViewById(R.id.showtime);
        timer.start();



        mMapView = (MapView) findViewById(R.id.bmapView);
        baiduMap=mMapView.getMap();
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15f);
        baiduMap.setMapStatus(msu);
        // 定位初始化
        mLocationClient = new LocationClient(getApplicationContext());
        firstLocation =true;
        // 设置定位的相关配置
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setOpenGps(true);
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        mLocationClient.setLocOption(option);
        // 设置自定义图标
        /*BitmapDescriptor myMarker = BitmapDescriptorFactory
                .fromResource(R.drawable.p2);*/
        /*MyLocationConfiguration config = new MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.FOLLOWING, true,);*/


        mLocationClient.registerLocationListener(new BDAbstractLocationListener(){
            @Override
            public void onReceiveLocation(BDLocation location) {
                // map view 销毁后不在处理新接收的位置
                if (location == null || mMapView == null)
                    return;
                // 构造定位数据
                MyLocationData locData = new MyLocationData.Builder()
                        .accuracy(location.getRadius())
                        // 此处设置开发者获取到的方向信息，顺时针0-360
                        .direction(100).latitude(location.getLatitude())
                        .longitude(location.getLongitude()).build();
                // 设置定位数据
                baiduMap.setMyLocationData(locData);

                // 第一次定位时，将地图位置移动到当前位置
                if (firstLocation)
                {
                    firstLocation = false;
                    LatLng xy = new LatLng(location.getLatitude(),
                            location.getLongitude());
                    MapStatusUpdate status = MapStatusUpdateFactory.newLatLng(xy);
                    baiduMap.animateMapStatus(status);
                }
            }
        });





    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Bundle bundle =data.getExtras();
        int i=bundle.getInt("safe");
        if(i==1){
            finish();
        }
        if(i==0){
            sos();
        }

    }

//计时
    private void sos(){
        SmsManager sm = SmsManager.getDefault();
        List<String> sms = sm.divideMessage(positionText.getText().toString());
        for (String smslist :sms){
            sm.sendTextMessage("17376567177",null,smslist,null,null);
        }
    }

    private CountDownTimer timer = new CountDownTimer(15000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            mTvShow.setText((millisUntilFinished / 1000) + "");
        }

        @Override
        public void onFinish() {
            mTvShow.setEnabled(true);
            /*mTvShow.setText(positionText.getText());*/
            Intent intent = new Intent();
            intent.setClass(saving1.this, are_you_ok.class);
            intent.putExtra("data",positionText.getText());

            startActivity(intent);
        }
    };


    private void requestLocation(){
        initLocation();
        mLocationClient.start();
    }

    private void  initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        mLocationClient.setLocOption(option);
    }

    protected  void onDestory(){
        super.onDestroy();
        mLocationClient.stop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case 1:
                if (grantResults.length > 0){
                    for(int result : grantResults){
                        if (result != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"必须同意所有权限才能使用本程序",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                }else {
                    Toast.makeText(this,"发生未知错误",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }





    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    StringBuilder currentPosition = new StringBuilder();

                    currentPosition.append("您好，您的伙伴牟雨函正在使用安全感平台，向您发出求助，TA现在的位置是：\n");
                    /*currentPosition.append("纬度：").append(location.getLatitude()).
                            append("\n");
                    currentPosition.append("经线：").append(location.getLongitude()).
                            append("\n");*/

                    currentPosition.append(location.getAddrStr()).
                            append("\n");


                    /*currentPosition.append("定位方式：");
                    if (location.getLocType() == BDLocation.TypeCacheLocation){
                        currentPosition.append("GPS");
                    } else if (location.getLocType()==
                            BDLocation.TypeNetWorkLocation){
                        currentPosition.append("网络");
                    }*/
                    positionText.setText(currentPosition);

                }
            });



        }

        public void onConnectHotSpotMessage(String s,int i){

        }
    }




    @Override
    public void onStart()
    {
        // 如果要显示位置图标,必须先开启图层定位
        baiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted())
        {
            mLocationClient.start();
        }
        super.onStart();
    }

    @Override
    public void onStop()
    {
        // 关闭图层定位
        baiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在Fragment执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在<span style="font-family: 微软雅黑, 'Microsoft YaHei', sans-serif;">Fragment</span>执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        //在Fragment执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mMapView=null;
    }

}
