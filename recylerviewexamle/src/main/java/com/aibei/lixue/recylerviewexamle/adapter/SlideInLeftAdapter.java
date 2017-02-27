package com.aibei.lixue.recylerviewexamle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aibei.lixue.recylerviewexamle.R;
import com.aibei.lixue.recylerviewexamle.customView.SwipeLayout;
import com.aibei.lixue.recylerviewexamle.customView.ViewBinderHelper;

import java.util.List;

/**
 * 作者：lixue on 2017/2/21 18:24
 */

public class SlideInLeftAdapter extends RecyclerView.Adapter<SlideInLeftAdapter.SlideInLeftHolder> {
    private List<String> mDatas;
    private Context context;
    private final ViewBinderHelper binderHelper = new ViewBinderHelper();

    public SlideInLeftAdapter(Context context,List<String> datalist){
        this.context = context;
        this.mDatas = datalist;
    }

    @Override
    public SlideInLeftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_sliding_delete,null);
        return new SlideInLeftHolder(v);
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    @Override
    public void onBindViewHolder(final SlideInLeftHolder holder, int position) {
        if (mDatas != null && 0 <= position && position < mDatas.size()) {
            final String data = mDatas.get(position);
            // Use ViewBindHelper to restore and save the open/close state of the SwipeRevealView
            // put an unique string id as value, can be any string which uniquely define the data
//            binderHelper.bind(holder.swipeLayout, data);

            holder.textView.setText(mDatas.get(position));

            holder.layout_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int n = holder.getLayoutPosition();
                    Toast.makeText(context,"我点击了:" + n ,Toast.LENGTH_SHORT).show();
                }
            });
            holder.btn_Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int n = holder.getLayoutPosition();
                    mDatas.remove(n);
                    notifyDataSetChanged();
                }
            });
        }


    }

    protected static class SlideInLeftHolder extends RecyclerView.ViewHolder{
        public FrameLayout btn_Delete;
        public TextView textView;
        public ViewGroup layout_content;
        public SwipeLayout swipeLayout;

        public SlideInLeftHolder(View itemView) {
            super(itemView);
            btn_Delete = (FrameLayout) itemView.findViewById(R.id.delete_layout);
            textView = (TextView) itemView.findViewById(R.id.text);
            layout_content = (ViewGroup) itemView.findViewById(R.id.framelayout_content);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe_layout);
        }
    }
}
