package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.johnhao.listviewdemo.R;

public class LoginActivity extends BaseActivity {

    private Button btn;
    private EditText editUserName;
    private EditText editserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("登陆");
        btn = findViewById(R.id.btn_login);
        editUserName = findViewById(R.id.edit_name);
        editserPassword = findViewById(R.id.edit_password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editUserName.getText().toString();
                String userPassword = editserPassword.getText().toString();

                if (userName.equals("tester") && userPassword.equals("123456")) {
                    // 登陆成功
                    Intent intent = new Intent(LoginActivity.this, AfterLoginActivity.class);
                    startActivity(intent);
                    finish();
                } else if (userName.equals("") || userPassword.equals("")) {
                    // 用户名或密码为空
                    Toast.makeText(LoginActivity.this, "请输入用户名或者密码", Toast.LENGTH_SHORT).show();
                } else {
                    // 用户名或密码不符合
                    Toast.makeText(LoginActivity.this, "请输入正确的用户名和密码", Toast.LENGTH_SHORT).show();
                    editUserName.setText("");
                    editserPassword.setText("");
                }
            }
        });
    }
}
