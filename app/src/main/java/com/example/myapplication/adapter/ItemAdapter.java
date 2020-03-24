package com.example.myapplication.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.event.HomeEvent;
import com.example.myapplication.waller.ImageLoader;

import java.util.List;

public class ItemAdapter extends BaseQuickAdapter<HomeEvent.DataBean, BaseViewHolder> {

    public ItemAdapter(List<HomeEvent.DataBean> data) {
        super(R.layout.item_home_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, HomeEvent.DataBean deadBean) {
        ImageView iv = holder.getView(R.id.imageView);
        ImageLoader.loadRoundImage(deadBean.imagePath, iv, 20);


    }


}
