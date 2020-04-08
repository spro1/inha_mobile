package com.example.yundol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText etID;
    public EditText etPassword;
    public Button btLogin;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Lifecycle","MainActivity onDestory() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = (EditText)findViewById(R.id.editTextID);
        etPassword = (EditText)findViewById(R.id.editTextPassword);
        btLogin = (Button)findViewById(R.id.buttonLogin);

        btLogin.setOnClickListener(this);
        Log.d("Activity Lifecycle","MainActivity onCreate() called");
    }


    @Override
    public void onClick(View view) {
            String id = etID.getText().toString();
            String pw = etPassword.getText().toString();

            Intent intent = new Intent(this, subActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("pw",pw);
            startActivity(intent);
            Log.d("ID", id);
            Log.d("PW",pw);
            Log.d("Activity Lifecycle","MainActivity onClick() called");
    }
}
