package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void video(View view) {
        startActivity(new Intent(this, VideoActivity.class));
    }

    public void videoList(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    public void leak(View view) {
        startActivity(new Intent(this, LeakCanaryActivity.class));
    }
}
