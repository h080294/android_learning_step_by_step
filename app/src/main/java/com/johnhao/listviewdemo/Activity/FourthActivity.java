package com.johnhao.listviewdemo.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.johnhao.listviewdemo.R;

public class FourthActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv;
    private EditText editText;
    private Button btn_show;
    private Button btn_hide;
    private Button btn_geteditText;
    private ProgressBar progressBar;
    private Button btn_alert;
    private Button btn_prodia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        setTitle("UI空间布局练习");
        tv = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.editTextView);
        btn_geteditText = (Button) findViewById(R.id.btn_getEditText);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_hide = (Button)findViewById(R.id.btn_hide);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        btn_alert = (Button) findViewById(R.id.btn_alret);
        btn_prodia = findViewById(R.id.btn_progress);
        btn_show.setOnClickListener(this);
        btn_hide.setOnClickListener(this);
        btn_geteditText.setOnClickListener(this);
        btn_alert.setOnClickListener(this);
        btn_prodia.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show:
                if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_hide:
                if (progressBar.getVisibility() == View.VISIBLE){
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_getEditText:
                String str = editText.getText().toString();
                Toast.makeText(FourthActivity.this, "Text is: " + str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_alret:
                AlertDialog.Builder dialog = new AlertDialog.Builder(FourthActivity.this);
                dialog.setTitle("警告");
                dialog.setMessage("Alert dialog Demo");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(FourthActivity.this, "居然敢点确定", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(FourthActivity.this, "居然敢点取消", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case R.id.btn_progress:
                ProgressDialog progressDialog = new ProgressDialog(FourthActivity.this);
                progressDialog.setTitle("ProgressDialog Demo");
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
        }
    }
}
