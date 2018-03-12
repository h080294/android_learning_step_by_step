package com.johnhao.listviewdemo.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.johnhao.listviewdemo.ActivityCollector;

/**
 * Created by johnhao on 2018/3/2.
 */

public class BaseActivity extends AppCompatActivity{

    private OfflineBroadcastReceiver offlineBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("baseAvtivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class OfflineBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            Log.d("Offline", "onReceive: ");
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle("警告");
            dialog.setMessage("账号在美国洛杉矶地区另一台设备上登陆，您已被强制下线。如果非本人操作，请尽快修改登陆密码");
            dialog.setCancelable(false);
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    Intent intent = new Intent(context, LoginAdvActivity.class);
                    startActivity(intent);
                }
            });
            dialog.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.johnhao.listviewdemo.FORCE_OFFLINE");
        offlineBroadcastReceiver = new OfflineBroadcastReceiver();
        registerReceiver(offlineBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineBroadcastReceiver != null) {
            unregisterReceiver(offlineBroadcastReceiver);
            offlineBroadcastReceiver = null;
        }
    }
}
