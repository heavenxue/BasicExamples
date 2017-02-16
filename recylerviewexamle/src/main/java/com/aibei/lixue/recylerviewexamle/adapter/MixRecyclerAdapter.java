package com.aibei.lixue.recylerviewexamle.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aibei.lixue.recylerviewexamle.R;

import java.util.List;

/**
 * 奇偶行显示不一样的布局
 *
 * 作者：lixue on 2017/2/13 16:43
 */

public class MixRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    List<String> titles;

    public MixRecyclerAdapter(List<String> titles){
        this.titles = titles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == ITEM_TYPE.ITEM_TYPE_TEXT.ordinal()){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item,null);
            return new TitleRecyclerHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_mix_item,null);
            return new TitleRecyclerHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleRecyclerHolder){
            ((TitleRecyclerHolder) holder).textView.setText(titles.get(position));
        }else{
            ((MixRecylerHolder)holder).textView.setText(titles.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.size();
    }

    @Override
    public int getItemViewType(int position) {
        //偶数返回带图像的
        return  position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    final static class TitleRecyclerHolder extends RecyclerView.ViewHolder{
        protected TextView textView;
        public TitleRecyclerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recler_item_text);
        }
    }

    final static class MixRecylerHolder extends RecyclerView.ViewHolder{
        protected TextView textView;
        public MixRecylerHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recler_item_text);
        }
    }

}
