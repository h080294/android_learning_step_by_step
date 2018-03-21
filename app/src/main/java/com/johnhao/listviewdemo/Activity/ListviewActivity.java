package com.johnhao.listviewdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.johnhao.listviewdemo.Adapter.FruitAdapter;
import com.johnhao.listviewdemo.Data.Fruit;
import com.johnhao.listviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends BaseActivity {

    private ListView lv;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv = findViewById(R.id.List_view);
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(ListviewActivity.this, R.layout.fruits, fruitList);
        lv.setAdapter(fruitAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListviewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 10; i++) {
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
