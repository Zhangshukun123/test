package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.adapter.HomeAdapter;
import com.example.myapplication.event.HomeEvent;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout refreshLayout;

    private RecyclerView rl;


    private HomeAdapter adapter;
    private List<HomeEvent> data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, null);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refreshLayout = view.findViewById(R.id.swipe);
        refreshLayout.setColorSchemeResources(android.R.color.holo_red_light);
        //设置下拉刷新的背景颜色为白色
        refreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        refreshLayout.setOnRefreshListener(this);

        rl = view.findViewById(R.id.rl);
        rl.setLayoutManager(new LinearLayoutManager(getActivity()));
        data = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            HomeEvent event = new HomeEvent();
            List<HomeEvent.DataBean> dataBeans = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                HomeEvent.DataBean dataBean = new HomeEvent.DataBean();
                dataBeans.add(dataBean);
            }
            event.setName_type("电视");
            event.setDeadBeans(dataBeans);
            data.add(event);
        }
        adapter = new HomeAdapter(data, getActivity());
    }

    @Override
    public void onRefresh() {
        new Handler().postAtTime(() -> {
            if (refreshLayout.isRefreshing()) {
                refreshLayout.setRefreshing(false);//取消刷新
            }
        }, 3000);

    }
}
