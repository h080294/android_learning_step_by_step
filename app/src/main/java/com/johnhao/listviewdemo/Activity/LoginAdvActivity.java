package com.johnhao.listviewdemo.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.johnhao.listviewdemo.R;

public class LoginAdvActivity extends AppCompatActivity {

    private Button btn;
    private EditText editUserName;
    private EditText editserPassword;
    private CheckBox rememberPass;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_adv);

        setTitle("登陆");
        btn = findViewById(R.id.btn_login);
        editUserName = findViewById(R.id.edit_name);
        editserPassword = findViewById(R.id.edit_password);
        rememberPass = findViewById(R.id.checkbox);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = prefs.getBoolean("remeber_password", false);

        if (isRemember) {
            String account = prefs.getString("account", "");
            String password = prefs.getString("password", "");
            editUserName.setText(account);
            editserPassword.setText(password);
            rememberPass.setChecked(true);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editUserName.getText().toString();
                String userPassword = editserPassword.getText().toString();

                if (userName.equals("tester") && userPassword.equals("123456")) {
                    editor = prefs.edit();
                    if (rememberPass.isChecked()) {
                        editor.putBoolean("remeber_password", true);
                        editor.putString("account", userName);
                        editor.putString("password", userPassword);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    // 登陆成功
                    Intent intent = new Intent(LoginAdvActivity.this, AfterLoginActivity.class);
                    startActivity(intent);
                    finish();
                } else if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userPassword)) {
                    // 用户名或密码为空
                    Toast.makeText(LoginAdvActivity.this, "请输入用户名或者密码", Toast.LENGTH_SHORT).show();
                } else {
                    // 用户名或密码不符合
                    Toast.makeText(LoginAdvActivity.this, "请输入正确的用户名和密码", Toast.LENGTH_SHORT).show();
                    editUserName.setText("");
                    editserPassword.setText("");
                }
            }
        });
    }
}
