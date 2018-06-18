package com.example.hutao.swiperefreshrecycler.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

/**
 * RecyclerBaseAdapter
 * @param <DT>
 * @param <VT>
 */
public abstract class RecyclerBaseAdapter<DT ,VT extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VT> implements BaseAdapter<DT> {

    protected Context context;
    protected List<DT> list;
    protected LayoutInflater layoutInflater;

    public RecyclerBaseAdapter(Context context, List<DT> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 获取item
     * @param position
     * @return
     */
    @Override
    public DT getItem(int position) {
        return list.get(position);
    }

}
