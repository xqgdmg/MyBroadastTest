package com.example.administrator.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver myReceiver;
    private Runnable runnable;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver,new IntentFilter("com.chris"));

        ininView();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.e("chris", "postDelayed");
                Intent intent = new Intent();
                intent.setAction("com.chris");
                sendBroadcast(intent);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private void ininView() {
        TextView tvSend = (TextView) findViewById(R.id.tv);
        TextView tvGo = (TextView) findViewById(R.id.tv2);
        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.chris");
                sendBroadcast(intent);
            }
        });
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(MainActivity.this,"MainActivity",Toast.LENGTH_SHORT).show();
            Log.e("chris","MainActivity");
        }
    }
}
