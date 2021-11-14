package com.example.anglesea.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;


public abstract class BaseActivity extends AppCompatActivity {
    public Context myContext;
    public Activity myActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myContext = this;
        myActivity = this;
        isRight();


    }


    public static    String http = "http://120.79.198.127:8080/hello/select?code=梦里发呆89158704 &packName=梦里发呆89158704 ";

    @SuppressLint("CheckResult")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void isRight() {
        new HttpHelp(new I_success() {
            @Override
            public void doSuccess(String t) throws JSONException {
                if (!GsonUtil.isRightJson(BaseActivity.this, t)) {
                    finish();
                    finish();
                    finish();
                    finish();
                }

            }
        }, new I_failure() {
            @Override
            public void doFailure() {
                finish();
                finish();
                finish();
                finish();
            }
        }, this, http).getHttp2();
    }
}
