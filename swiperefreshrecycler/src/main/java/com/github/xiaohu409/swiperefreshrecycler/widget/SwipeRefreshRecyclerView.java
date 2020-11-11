package com.github.xiaohu409.swiperefreshrecycler.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.github.xiaohu409.swiperefreshrecycler.R;


/**
 * 下拉刷新的Recycler View
 */
public class SwipeRefreshRecyclerView extends LinearLayout
        implements SwipeRefreshLayout.OnRefreshListener, NestedScrollView.OnScrollChangeListener {

    //加载动画默认颜色
    private int defaultColor = android.R.color.holo_red_light;
    //下拉控件
    private SwipeRefreshLayout refreshLayout;
    //列表
    private RecyclerView recyclerView;
    //布局管理
    private RecyclerView.LayoutManager mLayoutManager;
    //回调
    private LoadDataCallback loadDataCallback;

    public SwipeRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public SwipeRefreshRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwipeRefreshRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化
     */
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.swiper_refersh_recycler_view, this);
        refreshLayout = findViewById(R.id.swipe_refresh_layout_id);
        refreshLayout.setColorSchemeResources(defaultColor);
        refreshLayout.setOnRefreshListener(this);
        NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_view_id);
        nestedScrollView.setOnScrollChangeListener(this);
        recyclerView = findViewById(R.id.recycler_view_id);
        recyclerView.setNestedScrollingEnabled(false);
        View footView = LayoutInflater.from(context).inflate(R.layout.foot_view, null);
        footView.setVisibility(View.GONE);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (refreshLayout.isRefreshing()) {
//                    return;
//                }
//                //当前列表最后一个条记录的索引
//                int lastIndex = ((LinearLayoutManager) mLayoutManager).findLastCompletelyVisibleItemPosition();
//                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastIndex == mLayoutManager.getItemCount() - 1) {
//                    if (loadDataCallback != null) {
//                        loadDataCallback.onPullUpData();
//                    }
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//            }
//        });
    }

    /**
     * 下拉回调
     */
    @Override
    public void onRefresh() {
        if (loadDataCallback != null) {
            loadDataCallback.onPullDownData();
        }
    }

    /**
     * 滑动监听
     * @param v
     * @param scrollX
     * @param scrollY
     * @param oldScrollX
     * @param oldScrollY
     */
    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY > oldScrollY) {
            // 向下滑动
        }

        if (scrollY < oldScrollY) {
            // 向上滑动
        }

        if (scrollY == 0) {
            // 顶部
        }

        if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
            // 底部
            if (loadDataCallback != null) {
                loadDataCallback.onPullUpData();
            }
        }
    }

    /**
     * 下拉加载完成
     */
    public void onLoadComplete() {
        refreshLayout.setRefreshing(false);
    }

    /**
     * 获取layout manager
     * @return
     */
    public RecyclerView.LayoutManager getLayoutManager() {
        return mLayoutManager;
    }

    /**
     * 设置layout manager
     */
    public void setLayoutManager(RecyclerView.LayoutManager layoutManger) {
        mLayoutManager = layoutManger;
        recyclerView.setLayoutManager(layoutManger);
    }

    /**
     * 设置adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    /**
     * 滑动到指定位置
     * @param position
     */
    public void scrollToPosition(int position) {
        recyclerView.scrollToPosition(position);
    }

    /**
     * 数据加载回调
     */
    public interface LoadDataCallback {
        /**
         * 下拉加载数据
         */
        void onPullDownData();

        /**
         * 上拉加载数据
         */
        void onPullUpData();
    }

    /**
     * 设置回调
     * @param loadDataCallback
     */
    public void setLoadDataCallback(LoadDataCallback loadDataCallback) {
        this.loadDataCallback = loadDataCallback;
    }
}
