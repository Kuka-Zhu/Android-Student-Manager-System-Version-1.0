package com.sk.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;//用于加载Fragment的容器控件
    private MyAdapter myAdapter;//适配器
    private Fragment[] fragment = new Fragment[3];//数据源
    private static final int TIME_EXIT=2000;//双击退出
    private long mBackPressed;
    private PackageInfo info=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            info=getPackageManager().getPackageInfo(getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        CheckVersion();
    }
    public void CheckVersion(){
        int currentVersion = info.versionCode;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        int lastVersion = sp.getInt("VERSION_KEY", 0);

        if (currentVersion>lastVersion){
//            第一次启动将当前版本进行存储
            sp.edit().putInt("VERSION_KEY",currentVersion).commit();
            setContentView(R.layout.activity_main);
            InitView();
        }else {
//            非第一次启动直接跳转
            Intent intent=new Intent(this,doLoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void doLoginPage(View view) {
        Intent intent = new Intent(this,doLoginActivity.class);
        startActivity(intent);
    }

    private void InitView() {
        viewPager = findViewById(R.id.id_viewpage);
        fragment[0] = new OneFragment();
        fragment[1] = new TwoFragment();
        fragment[2] = new ThreeFragment();
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
    }

    public void MainExit(View view) {
        finish();
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragment[position];
        }

        @Override
        public int getCount() {
            return fragment.length;
        }
    }
}
