package com.johnhao.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.demo.R;

public class FragmentDemoActivity extends BaseActivity {

    private static final String[] strs = new String[]{"Fragment 入门", "动态添加Fragment", "Fragment Practice 简易新闻"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        lv = findViewById(R.id.fragment_demo);

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(FragmentDemoActivity.this, FragmentSimActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent one_intent = new Intent(FragmentDemoActivity.this, FragmentAddActivity.class);
                        startActivity(one_intent);
                        break;
                    case 2:
                        Intent two_intent = new Intent(FragmentDemoActivity.this, NewsTitleActivity.class);
                        startActivity(two_intent);
                        break;
                }
            }
        });
    }
}
