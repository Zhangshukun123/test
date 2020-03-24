package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.example.myapplication.adapter.HomeAdapter;
import com.example.myapplication.adapter.ImageAdapter;
import com.example.myapplication.event.BannerDataBean;
import com.example.myapplication.event.HomeEvent;
import com.example.myapplication.waller.DepthPageTransformer;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout refreshLayout;

    private RecyclerView rl;


    private HomeAdapter adapter;
    private List<HomeEvent> data;
    private Banner banner1;
    private Banner banner2;

    //4.
    private Handler handler = new Handler();



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


        View inflate = getLayoutInflater().inflate(R.layout.home_header_layout, null);


        setBanner(inflate);

        adapter.addHeaderView(inflate);


        rl.setAdapter(adapter);

        BaseLoadMoreModule loadMoreModule = adapter.getLoadMoreModule();
        assert loadMoreModule != null;
        loadMoreModule.setAutoLoadMore(true);
        loadMoreModule.setOnLoadMoreListener(() -> {
            Log.i("loadMore", "onViewCreated: ");

            handler.postDelayed(() -> {
                for (int i = 0; i < 1; i++) {
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
                adapter.setNewData(data);
                loadMoreModule.loadMoreComplete();
            }, 2000);
        });


    }

    private void setBanner(View inflate) {
        banner1 = inflate.findViewById(R.id.banner_1);
        banner2 = inflate.findViewById(R.id.banner_2);
        List<BannerDataBean> dataBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dataBeans.add(new BannerDataBean());
        }
        banner1.setAdapter(new ImageAdapter(dataBeans))
                .setOrientation(Banner.HORIZONTAL)
                .setUserInputEnabled(true);
        banner1.setIndicator(new CircleIndicator(getActivity()));
        banner1.setPageTransformer(new DepthPageTransformer());
        banner1.start();

        List<BannerDataBean> dataBean1 = new ArrayList<>();
        dataBean1.add(new BannerDataBean());

        banner2.setAdapter(new ImageAdapter(dataBean1))
                .setOrientation(Banner.HORIZONTAL)
                .setUserInputEnabled(true);

        banner2.start();
    }


    @Override
    public void onStop() {
        super.onStop();

        if (banner1 != null) {
            banner1.stop();
        }
        if (banner2 != null) {
            banner2.stop();
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        if (banner1 != null) {
            banner1.start();
        }
        if (banner2 != null) {
            banner2.start();
        }

    }

    @Override
    public void onRefresh() {
        new Handler().postAtTime(() -> {
            if (refreshLayout.isRefreshing()) {
                refreshLayout.setRefreshing(false);//取消刷新
            }
        }, 3000);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if(handler!=null){
//            handler.removeCallbacksAndMessages(null);
//            handler = null;
//        }

    }
}
