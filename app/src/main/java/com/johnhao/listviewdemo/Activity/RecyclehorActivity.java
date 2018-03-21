package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.johnhao.listviewdemo.Adapter.FruitAdapterHor;
import com.johnhao.listviewdemo.Data.Fruit;
import com.johnhao.listviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclehorActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    private RecyclerView rvh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclehor);
        setTitle("Recycle View Horizontal");
        initFruits();
        rvh = findViewById(R.id.recycle_view_hor);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvh.setLayoutManager(layoutManager);
        FruitAdapterHor fruitAdapterHor = new FruitAdapterHor(fruitList);
        rvh.setAdapter(fruitAdapterHor);
    }


    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);

            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);

            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);

            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);

            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);

            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);

            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);

            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);

        }

    }
}
