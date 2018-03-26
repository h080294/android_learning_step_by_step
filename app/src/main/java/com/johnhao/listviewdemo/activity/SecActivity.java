package com.johnhao.listviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.johnhao.listviewdemo.R;

public class SecActivity extends BaseActivity {
    private Button btn;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        setTitle("Sec Activity");
        btn = (Button)findViewById(R.id.btn);
        btn2 = (Button)findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "message from SecActivity";
                Intent intent = new Intent();
                intent.putExtra("Extra_data", data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
