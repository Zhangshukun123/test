package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.myapplication.leak.LoginManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LeakCanaryActivity extends AppCompatActivity {

    private static Test test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);


        //1.
        EventBus.getDefault().register(this);


        // 2.
        WebView webView = findViewById(R.id.mWebView);
        String data = "<img src=\\\"https://ss0.bdstatic.com/-0U0bnSm1A5BphGlnYG/tam-ogel/dd9d1d686cdc814db9653b254e00402e_259_194.jpg\\\" alt=\\\"\\\" /> \\r<p style=\\\"text-align:right;\\\">\\r\\t品类定位的思考\\r</p>\\r<h3>\\r\\t<strong><span style=\\\"color:#00D5FF;\\\">品类定";
        webView.loadDataWithBaseURL(null, data, "text/html", "utf-8", null);

        // 3.
        LoginManager.getInstance(this).dealData();


        // 7.
        test();


        // 8
        if (test == null) {
            test = new Test();
        }

    }

    private void test() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private class Test {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Message(String mes) {

    }

}
