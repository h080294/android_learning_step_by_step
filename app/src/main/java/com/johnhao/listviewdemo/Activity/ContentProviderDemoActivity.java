package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.listviewdemo.R;

import java.util.List;

public class ContentProviderDemoActivity extends BaseActivity {

    private static final String[] strs = new String[]{"运行时权限", "访问其他应用程序中的数据"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_demo);
        setTitle("Content Provider");
        lv = findViewById(R.id.listview_content_provider_demo);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(ContentProviderDemoActivity.this, ContentProviderMakeCallActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
