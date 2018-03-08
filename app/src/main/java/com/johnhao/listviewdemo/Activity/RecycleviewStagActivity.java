package com.johnhao.listviewdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.johnhao.listviewdemo.Adapter.FruitAdapterSta;
import com.johnhao.listviewdemo.Data.Fruit;
import com.johnhao.listviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewStagActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    private RecyclerView rvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_stag);
        setTitle("Recycle View Staggered");
        initFruits();
        rvs = findViewById(R.id.recycle_view_stag);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvs.setLayoutManager(staggeredGridLayoutManager);
        FruitAdapterSta fruitAdapterSta = new FruitAdapterSta(fruitList);
        rvs.setAdapter(fruitAdapterSta);
    }

    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            Fruit apple = new Fruit("Apple Apple Apple Apple Apple Apple Apple Apple", R.drawable.apple_pic);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);

            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);

            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);

            Fruit mango = new Fruit("Mango Mango Mango Mango Mango Mango", R.drawable.mango_pic);
            fruitList.add(mango);

            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);

            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);

            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit("Strawberry Strawberry Strawberry Strawberry Strawberry Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);

            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);

        }

    }
}
