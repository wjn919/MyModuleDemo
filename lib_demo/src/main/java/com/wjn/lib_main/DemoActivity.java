package com.wjn.lib_main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.wjn.commonlibrary.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * Created by wjn on 2017/7/3.
 */
@Router("demo")
public class DemoActivity extends Activity{
    Button btn_demo;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_demo);
        EventBus.getDefault().register(this);
        initView();
        btn_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"click", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(new MessageEvent("Hello everyone!"));
                Routers.open(DemoActivity.this, "myapp://test");
            }
        });
    }

    private void initView() {
        btn_demo = (Button) findViewById(R.id.btn_demo);
    }

    @Subscribe
    public void onEventMainThread(MessageEvent event) {

        String msg =  event.getMessage();
        Log.d("harvic", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
