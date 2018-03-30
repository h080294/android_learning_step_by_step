package com.johnhao.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.demo.R;

public class PersistenceDemoActivity extends BaseActivity {

    public static final String[] strs = new String[]{"数据存储到文件中", "SharedPreferences", "SQLite数据库存储"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistence_demo);
        setTitle("持久化技术");
        lv = findViewById(R.id.persistence_listview);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(PersistenceDemoActivity.this, PersSaveFileActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent one_intent = new Intent(PersistenceDemoActivity.this, PreSharedPreferencesActivity.class);
                        startActivity(one_intent);
                        break;
                    case 2:
                        Intent two_intent = new Intent(PersistenceDemoActivity.this, SQLiteActivity.class);
                        startActivity(two_intent);
                        break;
                }
            }
        });

    }


}
