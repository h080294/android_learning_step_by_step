package com.johnhao.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.demo.R;
import com.johnhao.demo.downloadPractice.DownloadPracticeActivity;

public class ServiceDemoActivity extends BaseActivity {

    private static final String[] strs = new String[]{"Android多线程", "Service", "ServicePracice"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
        setTitle("Service");
        ListView lv = findViewById(R.id.service_lv);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(ServiceDemoActivity.this, ServiceMulThreadActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent service = new Intent(ServiceDemoActivity.this, ServiceTestActivity.class);
                        startActivity(service);
                        break;
                    case 2:
                        Intent practice = new Intent(ServiceDemoActivity.this, DownloadPracticeActivity.class);
                        startActivity(practice);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
