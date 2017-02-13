package com.aibei.lixue.recylerviewexamle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 正常的布局适配器
 *
 * 作者：lixue on 2017/2/13 15:52
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<String> listItems;

    public RecyclerAdapter(List<String> dateItems){
        this.listItems = (dateItems != null ? dateItems : new ArrayList<String>());
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.textView.setText(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return (this.listItems != null) ? this.listItems.size() : 0;
    }

    protected final static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        protected TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.recler_item_text);
        }
    }
}
