package com.example.double2.studentinfomanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.double2.studentinfomanager.R;

public class LogInActivity extends Activity {

    //控件
    private Button btnLogIn;
    private EditText etPassword;
    //数据存储
    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_log_in);

        initView();
    }

    private void initView() {

        mSharedPreferences = this.getSharedPreferences("student", MODE_PRIVATE);

        etPassword = (EditText) findViewById(R.id.et_login_password);
        btnLogIn = (Button) findViewById(R.id.btn_login_log_in);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从本地获取到密码，如果没有设置过密码，就默认为1
                String oldPassword = mSharedPreferences.getString("password", "1");

                if (oldPassword.equals(etPassword.getText().toString())) {
                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LogInActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogInActivity.this, "登录失败，密码错误。", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
