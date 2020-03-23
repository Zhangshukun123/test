package com.example.myapplication.waller;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

public class ImageLoader {


    public static void loadRoundImage(Object url, ImageView view, int imageRadius) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(imageRadius));//图片圆角为30

        Glide.with(view.getContext()).load(url)
                .apply(options)
                .into(view);

    }


}
