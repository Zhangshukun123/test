package com.example.myapplication.adapter;

import android.app.Activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.event.HomeEvent;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<HomeEvent, BaseViewHolder> implements LoadMoreModule {

    private Activity activity;

    public HomeAdapter(List<HomeEvent> data, Activity activity) {
        super(R.layout.home_adapter, data);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder holder, HomeEvent homeEvent) {
        RecyclerView rl_item = holder.getView(R.id.rl_item);
        rl_item.setLayoutManager(new GridLayoutManager(activity, 2));
        rl_item.setAdapter(new ItemAdapter(homeEvent.getDeadBeans()));

    }
}
