package com.johnhao.listviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.johnhao.listviewdemo.data.Fruit;
import com.johnhao.listviewdemo.R;

import java.util.List;

/**
 * Created by johnhao on 2018/3/6.
 */

public class FruitAdapterHor extends RecyclerView.Adapter<FruitAdapterHor.ViewHolder>{

    private List<Fruit> mfruitList;

    public FruitAdapterHor(List<Fruit> fruitList) {
        mfruitList = fruitList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View fruitView;
        ImageView fruitImg;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImg = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_hor, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(v.getContext(), "You click View: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.fruitImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(v.getContext(), "You click Image: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mfruitList.get(position);
        holder.fruitImg.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mfruitList.size();
    }




}
