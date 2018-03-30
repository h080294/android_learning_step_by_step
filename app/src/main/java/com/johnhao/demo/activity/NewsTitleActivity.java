package com.johnhao.demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.johnhao.demo.R;

public class NewsTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_title);
        setTitle("简易新闻APP");
    }
}
