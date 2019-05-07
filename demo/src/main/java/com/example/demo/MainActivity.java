package com.example.demo;




import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*import com.ashokvarma.bottomnavigation.BadgeItem;*/
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );

       

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.first, "首页").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.look, "发现").setActiveColorResource(R.color.purple))
                .addItem(new BottomNavigationItem(R.drawable.keep22, "同伴在旁").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.buy, "社交圈").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.my, "我的").setActiveColorResource(R.color.green))
                .setFirstSelectedPosition(0)
                .initialise();

        /*fragments = getFragments();*/
        replace(new fragment1());
        /*bottomNavigationBar.setTabSelectedListener(this);*/
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        replace(new fragment1());
                        break;
                    case 1:
                        replace(new fragment2());
                        break;
                    case 2:
                        replace(new fragment3());
                        break;
                    case 3:
                        replace(new fragment4());
                        break;
                    case 4:
                        replace(new fragment5());
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, fragment);
        transaction.commit();
    }

    /**
     * 设置默认的
     */
    /*private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, fragment2.newInstance("Books"));
        transaction.commit();
    }*/

    /*private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(fragment1.newInstance("Home"));
        fragments.add(fragment2.newInstance("Books"));
        fragments.add(fragment3.newInstance("Music"));
        fragments.add(fragment4.newInstance("Movies & TV"));
        fragments.add(fragment5.newInstance("Games"));
        return fragments;
    }*/


    /*@Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.layFrame, fragment);
                } else {
                    ft.add(R.id.layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }*/

       /* FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f = null;
        switch (tabId) {
            case R.id.bmapView:
                f = new fragment1();
                break;
            case R.id.t2:
                f = new fragment2();
                break;
            case R.id.t3:
                f = new fragment3();
                break;
            case R.id.t4:
                f = new fragment4();
                break;
            default:
                break;
            }
            ft.replace(R.id.layFrame, f);
            ft.commitAllowingStateLoss();
        }*/
    /*}*/

   /* @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }


    }*/

    /*@Override
    public void onTabReselected(int position) {

    }*/
}
