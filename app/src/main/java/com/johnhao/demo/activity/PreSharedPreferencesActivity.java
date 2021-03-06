package com.johnhao.demo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.johnhao.demo.R;

public class PreSharedPreferencesActivity extends BaseActivity {

    private Button btn;
    private Button btn_load;
    private Button btn_pratice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_shared_preferences);
        setTitle("SharedPreferences");
        btn = findViewById(R.id.btn_save_sharedprefs);
        btn_load = findViewById(R.id.btn_load_sharedprefs);
        btn_pratice = findViewById(R.id.btn_sharedprefs_practice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "John");
                editor.putInt("age", 30);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);
                String name = prefs.getString("name", "null");
                int age = prefs.getInt("age", 0);
                boolean married = prefs.getBoolean("married", false);
                Log.d("SharedPreferences", "name: "+ name);
                Log.d("SharedPreferences", "age: " + age);
                Log.d("SharedPreferences", "married: " + married);
            }
        });

        btn_pratice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreSharedPreferencesActivity.this, LoginAdvActivity.class);
                startActivity(intent);
            }
        });
    }
}
