package com.aibei.lixue.recylerviewexamle.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aibei.lixue.recylerviewexamle.R;

import java.util.List;

/**
 * 为RecyclerView添加头部，脚
 * 作者：lixue on 2017/2/17 15:24
 */

public class HeaderBootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> datas;
    private int mHeaderCount;
    private int mBottomCount;


    private enum LIST_TYPE{
        HEADER,
        BODY,
        BOOT
    }

    public HeaderBootAdapter(List<String> lists){
        this.datas = lists;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderCount > 0 && position < mHeaderCount){
            return LIST_TYPE.HEADER.ordinal();
        }else if (mBottomCount > 0 && position >= mHeaderCount + datas.size() ){
            return LIST_TYPE.BOOT.ordinal();
        }else return LIST_TYPE.BODY.ordinal();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        if (viewType == LIST_TYPE.HEADER.ordinal()){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_header,null);
            return new HeaderRecyclerHolder(v);
        }else if (viewType == LIST_TYPE.BOOT.ordinal()){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_boot,null);
            return new BootRecylerHolder(v);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item,null);
            return new BodyRecyclerHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       if (holder instanceof BodyRecyclerHolder){
           ((BodyRecyclerHolder)holder).textView.setText(datas.get(position - mHeaderCount));
        }else if(holder instanceof BootRecylerHolder){
           ((BootRecylerHolder) holder).textView.setText("加载更多...");
       }
    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount() + mBottomCount;
    }

    static class HeaderRecyclerHolder extends RecyclerView.ViewHolder{

        public HeaderRecyclerHolder(View itemView) {
            super(itemView);
        }
    }

    static class BootRecylerHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public BootRecylerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.boot_item);
        }
    }

    static class BodyRecyclerHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public BodyRecyclerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recler_item_text);
        }
    }

    private int getContentItemCount(){
        return datas != null ? datas.size() : 0;
    }

    public void setmHeaderCount(int mHeaderCount) {
        this.mHeaderCount = mHeaderCount;
    }

    public void setmBottomCount(int mBottomCount) {
        this.mBottomCount = mBottomCount;
    }
}
