package com.mvvmstudy.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvvmstudy.R;
import com.mvvmstudy.bean.Userss;
import com.mvvmstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        /*User user = new User();
        user.setName("张飞");
        user.setAge(29);
        dataBinding.setUser(user);*/
        dataBinding.setUser(new Userss("张飞","https://ps.ssl.qhimg.com/dr/_110_100/t0116cc8e28aa9ee82d.jpg#1510639062#1510639062"));
    }
}
