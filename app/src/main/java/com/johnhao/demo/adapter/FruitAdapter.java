package com.johnhao.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johnhao.demo.data.Fruit;
import com.johnhao.demo.R;

import java.util.List;

/**
 * Created by johnhao on 2018/3/5.
 */

public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int reourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        reourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Fruit fruit = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(reourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }



     class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
