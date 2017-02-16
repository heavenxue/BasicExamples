package com.aibei.lixue.recylerviewexamle.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aibei.lixue.recylerviewexamle.R;
import com.aibei.lixue.recylerviewexamle.utils.Res;

import java.util.List;

/**
 * 作者：lixue on 2017/2/16 14:48
 */

public class MultiSeletedAdapter extends BaseMultiSelectAdapter<String> {
    private OnActionModeCallBack onActionModeCallBack;
    private boolean isActionModeShow = true;

    public MultiSeletedAdapter(List<String> list){
        mDataList = list;
    }

    public void setOnActionModeCallBack(OnActionModeCallBack onActionModeCallBack){
        this.onActionModeCallBack = onActionModeCallBack;
    }

    public void setIsActionModeShow(boolean isActionModeShow){
        this.isActionModeShow = isActionModeShow;
        if (!isActionModeShow){
            clearAllSelect();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_multi_selected_item,parent,false);
        return new MultiViewHolder(v,this,mDataList);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  MultiViewHolder){
            ((MultiViewHolder) holder).bindViewData(getItemData(position), position);
        }
    }

    static class MultiViewHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;
        private LinearLayout ll_multi;
        private ImageView image_item;
        private MultiSeletedAdapter mAdapter;
        private View view;
        private List<String> datalist;
        public MultiViewHolder(View itemView,MultiSeletedAdapter adapter,List<String> dataList) {
            super(itemView);
            view = itemView;
            this.datalist = dataList;
            ll_multi = (LinearLayout) itemView.findViewById(R.id.ll_multi);
            mTextView = (TextView) itemView.findViewById(R.id.muti_item_text);
            image_item = (ImageView) itemView.findViewById(R.id.image_item);
            this.mAdapter = adapter;
            ll_multi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mAdapter.isSelectedEnable && mAdapter.isActionModeShow) {
                        if (mAdapter.isSelected(getPosition())) {//已选中
                            mAdapter.removeSelectPosition(getPosition());
                        } else {//未选中
                            mAdapter.addSelectPosition(getPosition());
                        }
                        mAdapter.notifyItemChanged(getPosition());
                    }
                }
            });
        }

        public void bindViewData(String name,int position){
            ll_multi.setBackgroundColor((mAdapter.isSelected(position)) ? view.getResources().getColor(R.color.colorAccent) : view.getResources().getColor(R.color.colorWhite));
            image_item.setBackgroundResource(Res.drawable(view.getContext(),"icon_paytype_" + (position % 8)));
            mTextView.setText(name);
        }

//        public void onSelected(){
//            if (mAdapter.isSelectedEnable && mAdapter.isActionModeShow){
//                if (mAdapter.isSelected(getPosition())) {//已选中
//                    mAdapter.removeSelectPosition(getPosition());
//                } else {//未选中
//                    mAdapter.addSelectPosition(getPosition());
//                }
//                mAdapter.notifyItemChanged(getPosition());
//            }
//        }


    }

    public interface OnActionModeCallBack {
        public void showActionMode();
    }
}
