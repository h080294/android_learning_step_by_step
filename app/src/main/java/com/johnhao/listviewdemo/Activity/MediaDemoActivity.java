package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.johnhao.listviewdemo.R;

public class MediaDemoActivity extends BaseActivity {

    private ListView lv;
    private static String[] strs = new String[]{"Camera && Album"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_demo);

        setTitle("Media");
        lv = findViewById(R.id.listview_media_demo);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent camera_intent = new Intent(MediaDemoActivity.this, CameraAlbumActivity.class);
                        startActivity(camera_intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
