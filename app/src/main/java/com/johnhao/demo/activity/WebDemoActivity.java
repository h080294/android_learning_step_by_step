package com.johnhao.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.demo.R;

public class WebDemoActivity extends BaseActivity {

    public static final String[] strs = new String[]{"Webview", "NetWork"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_demo);
        setTitle("Web技术");

        ListView lv = findViewById(R.id.web_listview);
        lv.setAdapter(new ArrayAdapter<String>(WebDemoActivity.this, android.R.layout.simple_list_item_1, strs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(WebDemoActivity.this, WebViewActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent network = new Intent(WebDemoActivity.this, WebNetworkActivity.class);
                        startActivity(network);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
