package com.aibei.lixue.recylerviewexamle.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：lixue on 2017/2/16 14:17
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected final String TAG = BaseRecyclerAdapter.class.getSimpleName();
    protected List<T> mDataList = new ArrayList<>();

    @Override
    public int getItemCount() {
        return mDataList != null ? mDataList.size() : 0;
    }

    /**
     * 移除某条记录
     * @param position
     */
    public void removeItem(int position){
        if (mDataList != null && mDataList.size() > 0 && position < mDataList.size()){
            mDataList.remove(position);
            notifyItemRemoved(position);
        }
    }

    /**
     * 添加一条记录
     * @param data 需要加入的数据结构
     * @param position 插入位置
     */
    public void addItem(T data,int position){
        if (position < mDataList.size()){
            mDataList.add(position,data);
            notifyItemInserted(position);
        }
    }

    /**
     * 移除所有记录
     */
    public void clearItems() {
        int size = mDataList.size();
        if (size > 0) {
            mDataList.clear();
            notifyItemRangeRemoved(0, size);
        }
    }
    /**
     * 批量添加记录
     *
     * @param data 需要加入的数据结构
     * @param position 插入位置
     */
    public void addItems(List<T> data, int position) {
        if (position <= mDataList.size() && data != null && data.size() > 0) {
            mDataList.addAll(position, data);
            notifyItemRangeChanged(position, data.size());
        }
    }
    /**
     * 批量添加记录
     *
     * @param data 需要加入的数据结构
     */
    public void addItems(List<T> data) {
        addItems(data, mDataList.size());
    }

    public List<T> getDataList() {
        return mDataList;
    }
    public T getItemData(int position) {
        return position < mDataList.size() ? mDataList.get(position) : null;
    }
}
