package com.johnhao.demo.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.johnhao.demo.R;

public class ServiceMulThreadActivity extends BaseActivity implements View.OnClickListener{

    public static final int UPDATE_TEXT = 1;
    private TextView tv;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    tv.setText(R.string.change_text);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_mul_thread);
        setTitle("多线程编程");
        Button crash = findViewById(R.id.service_multhread_crash);
        Button btn_handler = findViewById(R.id.service_multhread_handle);
        tv = findViewById(R.id.service_tv);
        crash.setOnClickListener(this);
        btn_handler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.service_multhread_crash:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(R.string.change_text);
                    }
                }).start();
                break;
            case R.id.service_multhread_handle:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
