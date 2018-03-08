package com.johnhao.listviewdemo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.johnhao.listviewdemo.Data.Fruit;
import com.johnhao.listviewdemo.R;

import java.util.List;

/**
 * Created by johnhao on 2018/3/6.
 */

public class FruitAdapterSta extends RecyclerView.Adapter<FruitAdapterSta.ViewHolder>{

    private List<Fruit> mfruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {

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

    public FruitAdapterSta(List<Fruit> fruitList) {
        mfruitList = fruitList;
    }

    @Override
    public FruitAdapterSta.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_stag, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(v.getContext(), "You clicked View: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.fruitImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mfruitList.get(position);
                Toast.makeText(v.getContext(), "You clicked Image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FruitAdapterSta.ViewHolder holder, int position) {
        Fruit fruit = mfruitList.get(position);
        holder.fruitImg.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mfruitList.size();
    }
}
