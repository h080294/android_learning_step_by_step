package com.johnhao.demo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.johnhao.demo.R;
import com.johnhao.demo.service.MyService;

public class ServiceTestActivity extends BaseActivity implements View.OnClickListener{

    private MyService.DownBinder downBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downBinder = (MyService.DownBinder) service;
            downBinder.startDownload();
            downBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        setTitle("Service Test");
        Button startService = findViewById(R.id.service_start);
        Button stopService = findViewById(R.id.service_stop);
        Button bindService = findViewById(R.id.service_bind);
        Button unbindService = findViewById(R.id.service_unbind);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.service_start:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.service_stop:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.service_bind:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.service_unbind:
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
