package com.example.myapplication.event;

import java.util.List;

public class HomeEvent {
    public String name_type;
    private List<DataBean> deadBeans;


    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public List<DataBean> getDeadBeans() {
        return deadBeans;
    }

    public void setDeadBeans(List<DataBean> deadBeans) {
        this.deadBeans = deadBeans;
    }

    public static class DataBean {

        public String imagePath;


    }


}
