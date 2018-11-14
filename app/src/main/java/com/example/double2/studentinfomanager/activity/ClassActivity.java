package com.example.double2.studentinfomanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.double2.studentinfomanager.R;

public class ClassActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main0);
        Button button1= (Button) findViewById(R.id.spm);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(ClassActivity.this, MainActivity.class);
                // 开始Activity
                startActivity(intent);

            }
        });
    }
}
