package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Chris on 2017/7/23.
 * 动态注册的广播，没有在这个页面是收不到的
 */

public class MyActivity extends Activity{

    private MyReceiver myReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         //这里不设置布局也是可以的，默认有个白屏的页面

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver,new IntentFilter("com.chris"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
             //广播中弹Toast是没有任何问题的
//            Toast.makeText(MyActivity.this,"MyActivity",Toast.LENGTH_SHORT).show();
            Log.e("chris","MyActivity");
        }
    }
}
