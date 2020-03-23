package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class VideoActivity extends AppCompatActivity {



    private StandardGSYVideoPlayer detailPlayer;
    private OrientationUtils orientationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        detailPlayer = (StandardGSYVideoPlayer) findViewById(R.id.detail_player);


        String source1 = "http://vfx.mtime.cn/Video/2019/03/21/mp4/190321153853126488.mp4";
        detailPlayer.setUp(source1, true, "测试视频");

        orientationUtils = new OrientationUtils(this, detailPlayer);
        orientationUtils.resolveByClick();


        detailPlayer.getBackButton().setOnClickListener(v -> finish());


    }
}
