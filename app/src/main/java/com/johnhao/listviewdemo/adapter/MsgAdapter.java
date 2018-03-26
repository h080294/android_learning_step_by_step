package com.johnhao.listviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.johnhao.listviewdemo.data.Msg;
import com.johnhao.listviewdemo.R;

import java.util.List;

/**
 * Created by johnhao on 2018/3/6.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{

    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
            leftMsg = itemView.findViewById(R.id.msg_left);
            rightMsg = itemView.findViewById(R.id.msg_right);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }
        else {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
