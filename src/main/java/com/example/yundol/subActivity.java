package com.example.yundol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String pw = intent.getStringExtra("pw");
        TextView tvid = (TextView) findViewById(R.id.textViewSubId);
        TextView tvpw = (TextView) findViewById(R.id.textViewSubPw);
        tvid.setText(id);
        tvpw.setText(pw);
        Log.d("Activity Lifecycle","subActivity onCreate() called");
    }
}