package com.wjn.mystructdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mzule.activityrouter.router.Routers;
import com.wjn.lib_main.DemoActivity;

/**
 * Created by wjn on 2017/10/19.
 */

public class MainActivity extends AppCompatActivity {
    Button btnturntolibdemo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

    }

    private void initEvent() {
        btnturntolibdemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, DemoActivity.class));
              //  Routers.open(MainActivity.this, "myapp://demoactivity");
            }
        });
    }

    private void initView() {
        btnturntolibdemo = (Button) findViewById(R.id.btn_turn_to_lib_demo);
    }
}
