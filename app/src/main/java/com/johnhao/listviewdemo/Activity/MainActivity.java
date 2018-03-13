package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.johnhao.listviewdemo.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private static final String[] strs = new String[]{"基本的控件练习", "RecycleView 练习",
            "Fragment 练习", "BroadCast 练习", "持久化技术", "Content Provider"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            Log.d(TAG, "onCreate: 恢复onSaveInstanceState数据");
        }
        setTitle("Demo");
        lv = (ListView)findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, ListViewDemoActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent eight_intent = new Intent(MainActivity.this, RecycleViewDemoActivity.class);
                        startActivity(eight_intent);
                        break;
                    case 2:
                        Intent nine_intent = new Intent(MainActivity.this, FragmentDemoActivity.class);
                        startActivity(nine_intent);
                        break;
                    case 3:
                        Intent ten_intent = new Intent(MainActivity.this, BroadcastDemoActivity.class);
                        startActivity(ten_intent);
                        break;
                    case 4:
                        Intent eve_intent = new Intent(MainActivity.this, PersistenceDemoActivity.class);
                        startActivity(eve_intent);
                        break;
                    case 5:
                        Intent five_intent = new Intent(MainActivity.this, ContentProviderDemoActivity.class);
                        startActivity(five_intent);
                        break;
                    default:
                        setTitle("点击第" + (i + 1) + "行");
                        Toast.makeText(MainActivity.this, "点击了这行", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onItemClick: " + (i + 1));
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String back_data = data.getStringExtra("Extra_data");
                    Log.d(TAG, "onActivityResult: " + back_data);
                    Toast.makeText(MainActivity.this, back_data, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_menu:
                Toast.makeText(MainActivity.this, "点击了add menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_menu:
                Toast.makeText(MainActivity.this, "点击了remove menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_app:
                finish();
            default:
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String temp_data = "Something here to save";
        outState.putString("Extra_data", temp_data);
    }
}
