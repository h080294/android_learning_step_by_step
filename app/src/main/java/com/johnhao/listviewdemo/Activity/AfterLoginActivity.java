package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.johnhao.listviewdemo.R;

public class AfterLoginActivity extends BaseActivity {

    private Button btn_offline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        setTitle("登陆后的页面");
        btn_offline = findViewById(R.id.btn_offline);

        btn_offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btn_offline", "onClick: ");
                Intent intent = new Intent("com.johnhao.listviewdemo.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
