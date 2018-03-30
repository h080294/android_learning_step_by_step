package com.johnhao.demo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.demo.R;

public class BroadcastDemoActivity extends AppCompatActivity {

    private ListView lv;
    private static final String[] strs = new String[]{"Network change Broadcast Receiver", "My BroadcastReceiver", "LocalBroadcast", "Broadcast应用 - 强制下线"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_demo);
        lv = findViewById(R.id.broadcast_demo_listlist);
        setTitle("Broadcast Demo");
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(BroadcastDemoActivity.this, NewworkChangeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent one_intent = new Intent(BroadcastDemoActivity.this, MyBroadcastReceiverActivity.class);
                        startActivity(one_intent);
                        break;
                    case 2:
                        Intent two_intent = new Intent(BroadcastDemoActivity.this, LocalBroadcastActivity.class);
                        startActivity(two_intent);
                        break;
                    case 3:
                        Intent thr_intent = new Intent(BroadcastDemoActivity.this, LoginActivity.class);
                        startActivity(thr_intent);
                        break;
                    default:
                }
            }
        });

    }

}
