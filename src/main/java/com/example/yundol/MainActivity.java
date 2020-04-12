package com.example.yundol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText etID;
    public EditText etPassword;
    public Button btLogin;
    Button btn;
    private AssetFileDescriptor descriptor;
    private Button btPlayer;
    private Button btStop;
    private Button btRawPlayer;
    private Button btRawStop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Lifecycle","MainActivity onDestory() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 3주차 log
        etID = (EditText)findViewById(R.id.editTextID);
        etPassword = (EditText)findViewById(R.id.editTextPassword);
        btLogin = (Button)findViewById(R.id.buttonLogin);

        btLogin.setOnClickListener(this);
        Log.d("Activity Lifecycle","MainActivity onCreate() called");

        */
        /*
        4주차 url open
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        */
        AssetManager am = getAssets();
        try{
            descriptor = am.openFd("twice_likey.mp3");
        }catch(IOException e){
            Log.e("tag", "IOException : ");
            e.toString();
            e.printStackTrace();
        }

        btPlayer = (Button)findViewById(R.id.buttonPlay);
        btStop = (Button)findViewById(R.id.buttonStop);
        btPlayer.setOnClickListener(this);
        btStop.setOnClickListener(this);

        btRawPlayer = (Button)findViewById(R.id.buttonRawPlay);
        btRawStop = (Button)findViewById(R.id.buttonRawStop);
        btRawPlayer.setOnClickListener(this);
        btRawStop.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        /* 3주차
            String id = etID.getText().toString();
            String pw = etPassword.getText().toString();

            Intent intent = new Intent(this, subActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("pw",pw);
            startActivity(intent);
            Log.d("ID", id);
            Log.d("PW",pw);
            Log.d("Activity Lifecycle","MainActivity onClick() called");
        */
        /* 4주차
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inha.ac.kr"));
        startActivity(intent);
        */

        if(view.getId()==R.id.buttonPlay){
            try{
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(),
                        descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();
                mediaPlayer.prepare();
                mediaPlayer.start();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else if(view.getId() == R.id.buttonRawPlay) {
            mediaPlayer = MediaPlayer.create(this, R.raw.heart_shaker);
            mediaPlayer.start();
        }else if(view.getId() == R.id.buttonStop || view.getId() == R.id.buttonRawStop){
            if(mediaPlayer != null)
                mediaPlayer.stop();
        }

    }
}
