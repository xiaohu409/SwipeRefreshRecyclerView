package com.example.hutao.swiperefreshrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.github.xiaohu409.swiperefreshrecycler.widget.SwipeRefreshRecyclerView;
import com.example.hutao.swiperefreshrecyclerview.adapter.SampleAdapter;
import com.example.hutao.swiperefreshrecyclerview.bean.SampleBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity implements SwipeRefreshRecyclerView.LoadDataCallback{

    private SwipeRefreshRecyclerView recyclerView;
    private List<SampleBean.DataBean.NewsBean> newsBeanList;
    private SampleAdapter sampleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        initUI();
        bindData();
    }

    private void initUI() {
        //实例化控件
        recyclerView = findViewById(R.id.swipe_refresh_recycler_view_id);
        //设置回调
        recyclerView.setLoadDataCallback(this);
        //设置布局
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        newsBeanList = new ArrayList<>();
        sampleAdapter = new SampleAdapter(this, newsBeanList);
        recyclerView.setAdapter(sampleAdapter);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onPullDownData() {
        newsBeanList.clear();
        bindData();
        sampleAdapter.notifyDataSetChanged();
        recyclerView.onLoadComplete();
    }

    /**
     * 上拉加载
     */
    @Override
    public void onPullUpData() {
        bindData();
        sampleAdapter.notifyDataSetChanged();
    }

    /**
     * 数据
     */
    private void bindData() {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader addressJsonStream = new BufferedReader(new InputStreamReader(getAssets().open("data.json")));
            String line;
            while ((line = addressJsonStream.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        SampleBean sampleBean = gson.fromJson(json.toString(), SampleBean.class);
        newsBeanList.addAll(sampleBean.getData().getNews());
    }
}
