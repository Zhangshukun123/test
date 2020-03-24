package com.example.myapplication.waller;

import android.annotation.SuppressLint;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

public class ImageLoader {


    @SuppressLint("CheckResult")
    public static void loadRoundImage(Object url, ImageView view, int imageRadius) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(imageRadius));//图片圆角为30
        options.error(R.mipmap.icon_error);
        options.centerCrop();
        Glide.with(view.getContext()).load(url)
                .apply(options)
                .into(view);
    }


    @SuppressLint("CheckResult")
    public static void loadImage(Object url, ImageView view) {
        RequestOptions options = new RequestOptions();
        options.error(R.drawable.icon_placeholder);
        options.centerCrop();
        Glide.with(view.getContext()).load(url)
                .apply(options)
                .into(view);
    }


}
