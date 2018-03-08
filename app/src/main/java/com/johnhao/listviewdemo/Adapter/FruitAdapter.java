package com.johnhao.listviewdemo.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johnhao.listviewdemo.Data.Fruit;
import com.johnhao.listviewdemo.R;

import org.w3c.dom.Text;

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
