package com.example.hutao.swiperefreshrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.xiaohu409.swiperefreshrecycler.baseadapter.RecyclerBaseAdapter;
import com.example.hutao.swiperefreshrecyclerview.R;
import com.example.hutao.swiperefreshrecyclerview.bean.SampleBean;

import java.util.List;

public class SampleAdapter extends RecyclerBaseAdapter<SampleBean.DataBean.NewsBean, SampleAdapter.ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleView;
        TextView fromView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_iv_id);
            titleView = itemView.findViewById(R.id.title_tv_id);
            fromView = itemView.findViewById(R.id.from_tv_id);
        }
    }

    public SampleAdapter(Context context, List<SampleBean.DataBean.NewsBean> list) {
        super(context, list);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SampleBean.DataBean.NewsBean bean = getItem(position);
        if (bean.getImageurls() != null && bean.getImageurls().size() > 0) {
            Glide.with(context).load(bean.getImageurls().get(0).getUrl()).into(holder.imageView);
            holder.imageView.setVisibility(View.VISIBLE);
        }
        else {
            holder.imageView.setVisibility(View.GONE);
        }

        holder.titleView.setText(bean.getTitle());
        holder.fromView.setText(bean.getSite());
    }
}
