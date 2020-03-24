package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.myapplication.leak.LoginManager;

import org.greenrobot.eventbus.EventBus;

public class LeakCanaryActivity extends AppCompatActivity {

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

    }
}
