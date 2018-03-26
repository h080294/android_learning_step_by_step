package com.johnhao.listviewdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.johnhao.listviewdemo.adapter.MsgAdapter;
import com.johnhao.listviewdemo.data.Msg;
import com.johnhao.listviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class UIBestPraticeActivity extends BaseActivity {

    private List<Msg> msgList = new ArrayList<>();

    private RecyclerView msgView;
    private EditText input_text;
    private Button btn_send;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uibest_pratice);
        initMsgs();
        msgView = findViewById(R.id.msg_recycle_view);
        input_text = findViewById(R.id.input_text);
        btn_send = findViewById(R.id.btn_send);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        msgView.setAdapter(msgAdapter);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = input_text.getText().toString();
                if (!"".equals(input)) {
                    Msg msg = new Msg(input, Msg.TYPE_SENT);
                    msgList.add(msg);
                    // 当有新消息是，刷新ListView页面中的显示
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
                    // 滚动页面到ListView的最后一行
                    msgView.scrollToPosition(msgList.size() - 1);
                    // 将输入框置为空
                    input_text.setText("");
                }
            }
        });

    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello, guy", Msg.TYPE_RECEIVED);
        msgList.add(msg1);

        Msg msg2 = new Msg("How are you", Msg.TYPE_RECEIVED);
        msgList.add(msg2);

        Msg msg3 = new Msg("fine thank you, and you?", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

}
