package com.johnhao.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.demo.R;

public class RecycleViewDemoActivity extends BaseActivity {

    private static final String[] strs = new String[]{"RecycleView Vertical",
            "RecycleView Horizontal", "RecycleView Staggered", "UI Best Pratice"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_demo);
        setTitle("RecycleView Demo");
        lv = findViewById(R.id.recycle_view_demo);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent eight_intent = new Intent(RecycleViewDemoActivity.this, RecycleviewActivity.class);
                        startActivity(eight_intent);
                        break;
                    case 1:
                        Intent nine_intent = new Intent(RecycleViewDemoActivity.this, RecyclehorActivity.class);
                        startActivity(nine_intent);
                        break;
                    case 2:
                        Intent ten_intent = new Intent(RecycleViewDemoActivity.this, RecycleviewStagActivity.class);
                        startActivity(ten_intent);
                        break;
                    case 3:
                        Intent eve_intent = new Intent(RecycleViewDemoActivity.this, UIBestPraticeActivity.class);
                        startActivity(eve_intent);
                        break;
                }
            }
        });
    }
}
