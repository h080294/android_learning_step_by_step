package com.johnhao.listviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.johnhao.listviewdemo.R;

public class MyBroadcastReceiverActivity extends BaseActivity {

    private Button btn;
    private Button btn_ordered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broadcast_receiver);
        setTitle("MyBroadcast Receiver");
        btn = findViewById(R.id.btn_send_mybroadcast);
        btn_ordered = findViewById(R.id.btn_send_mybroadcast_ordered);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.johnhao.listviewdemo.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
        btn_ordered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ordered_intent = new Intent("com.johnhao.listviewdemo.MY_BROADCAST");
                sendOrderedBroadcast(ordered_intent, null);
            }
        });
    }
}
