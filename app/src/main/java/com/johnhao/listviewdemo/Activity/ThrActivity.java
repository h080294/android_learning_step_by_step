package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.johnhao.listviewdemo.Activity.BaseActivity;
import com.johnhao.listviewdemo.R;

public class ThrActivity extends BaseActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);
        setTitle("ThrdActivity");
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        tv = (TextView)findViewById(R.id.tv);
        if (null != data){
            tv.setText(data);
        }
    }
}
