package com.johnhao.listviewdemo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.johnhao.listviewdemo.R;

public class ListViewDemoActivity extends BaseActivity {

    private static final String[] strs = new String[]{"显式intent：Sec Activity", "隐式intent：Sec Activity",
            "打开百度", "选择响应对象", "Intent传递数据", "startActivityForResult", "跳转控件练习页面", "定制List View"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        lv = findViewById(R.id.list_view_demo);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(ListViewDemoActivity.this, SecActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent hide_intent = new Intent("com.johnhao.listviewdemo.ACTION_START");
                        hide_intent.addCategory("android.intent.category.MY_CATEGROY");
                        startActivity(hide_intent);
                        break;
                    case 2:
                        Intent web_intent = new Intent(Intent.ACTION_VIEW);
                        web_intent.setData(Uri.parse("http://www.baidu.com"));
                        startActivity(web_intent);
                        break;
                    case 3:
                        Intent cho_intent = new Intent(Intent.ACTION_VIEW);
                        cho_intent.setData(Uri.parse("http://www.baidu.com"));
                        startActivity(cho_intent);
                        break;
                    case 4:
                        String data = "Hello, new Activity, this is message in Intent";
                        Intent data_intent = new Intent(ListViewDemoActivity.this, ThrActivity.class);
                        data_intent.putExtra("extra_data", data);
                        startActivity(data_intent);
                        break;
                    case 5:
                        Intent back_data = new Intent(ListViewDemoActivity.this, SecActivity.class);
                        startActivityForResult(back_data, 1);
                        break;
                    case 6:
                        Intent six_intent = new Intent(ListViewDemoActivity.this, FourthActivity.class);
                        startActivity(six_intent);
                        break;
                    case 7:
                        Intent seven_intent = new Intent(ListViewDemoActivity.this, ListviewActivity.class);
                        startActivity(seven_intent);
                        break;
                    default:
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String data_back = data.getStringExtra("Extra_data");
                    Toast.makeText(this, data_back, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
