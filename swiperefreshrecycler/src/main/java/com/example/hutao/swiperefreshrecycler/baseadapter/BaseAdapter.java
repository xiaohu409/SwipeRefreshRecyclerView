package com.example.hutao.swiperefreshrecycler.baseadapter;

/**
 * BaseAdapter
 */
public interface BaseAdapter<T> {

    /**
     * 获取list item;
     * @param position
     * @return
     */
    T getItem(int position);
}
