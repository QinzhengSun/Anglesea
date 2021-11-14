package com.example.anglesea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.anglesea.util.BaseActivity;
import com.example.anglesea.util.EventBus_Tag;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Timer;
import java.util.TimerTask;

public class WelActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        registerEventBus();


        new Timer().schedule(new TimerTask() {
            public void run() {
                EventBus.getDefault().post(new EventBus_Tag(1));
            }
        }, 2000);// 这里百毫秒

        findViewById(R.id.icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventBus_Tag(1));
            }
        });

    }
    public void registerEventBus() {
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventBus_Tag event) {
        switch (event.getTag()) {
            case 1:
                startActivity(new Intent( WelActivity.this, LoginActivity.class));
                break;
        }
    }
}
