package com.example.demo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class add_friend extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);
        final int[] imageid=new int[]{R.drawable.add,R.drawable.add__success};
        final String[] title=new String[]{"爸爸","妈妈","阿猫","阿狗"};
        final int[] image=new int[]{1,0,0,0};
        List<Map<String,Object>> Listitem=new ArrayList<Map<String,Object>>();
        for(int i=0;i<title.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",imageid[image[i]]);
            map.put("name",title[i]);
            Listitem.add(map);
        }
        SimpleAdapter adapter=new SimpleAdapter(this,Listitem,R.layout.friend_simple,new String[]{"name","image"},
                                             new int[]{R.id.tytle,R.id.pic});
        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map=(Map<String,Object> )parent.getItemAtPosition(position);
                if(imageid[image[position]]==0){
                    imageid[image[position]]=1;
                }
                if(imageid[image[position]]==1){
                    imageid[image[position]]=0;
                }
                Toast.makeText(add_friend.this,title[position],Toast.LENGTH_SHORT).show();


            }
        });



    }


}


