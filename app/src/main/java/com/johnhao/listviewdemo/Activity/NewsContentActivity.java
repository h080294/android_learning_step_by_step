package com.johnhao.listviewdemo.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.johnhao.listviewdemo.Fragment.NewsContentFragment;
import com.johnhao.listviewdemo.R;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitile, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news Title", newsTitile);
        intent.putExtra("news Content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String newsTitle = getIntent().getStringExtra("news Title");
        String newsContent = getIntent().getStringExtra("news Content");
        setTitle(newsTitle);
        NewsContentFragment newsContentFragment = (NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle, newsContent);
    }
}
