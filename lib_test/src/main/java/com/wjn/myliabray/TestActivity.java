package com.wjn.myliabray;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mzule.activityrouter.annotation.Router;
import com.wjn.commonlibrary.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


/**
 * Created by wjn on 2017/7/3.
 */
@Router("test")
public class TestActivity extends Activity {
    TextView tvmy;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_test_activity_my);
        //注册EventBus
        EventBus.getDefault().register(this);
        initView();
        tvmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("我是从MyActivity回调的！"));
                finish();
            }
        });
    }
    @Subscribe(sticky =true)
    public void onEventMainThread(MessageEvent event) {

        String msg =  event.getMessage();
        Log.d("harvic", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy()
    {
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void initView() {
        tvmy = (TextView) findViewById(R.id.tv_my);
    }
}
