package com.aibei.lixue.recylerviewexamle.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 多选适配器
 * 作者：lixue on 2017/2/16 11:10
 */

public abstract class BaseMultiSelectAdapter<T> extends BaseRecyclerAdapter<T> {
    protected List<Integer> mutiSelectedPPsitions = new ArrayList<>();
    protected boolean isSelectedEnable = true;

       public List<Integer> getMutiSelectedPPsitions() {
        return mutiSelectedPPsitions;
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    public boolean isSelectedData(){
        return mutiSelectedPPsitions.size() > 0;
    }
    /**
     * 添加选中项
     *
     * @param data 选中项数据
     */
    public void addSelectPosition(Integer data) {
        if (!mutiSelectedPPsitions.contains(data)) {
            mutiSelectedPPsitions.add(data);
        }
    }

    /**
     * 删除选中项
     *
     * @param data 选中项数据
     */
    public void removeSelectPosition(Integer data) {
        if (mutiSelectedPPsitions.contains(data)) {
            mutiSelectedPPsitions.remove(data);
        }
    }

    /**
     * 清除所有选中项
     */
    public void clearAllSelect() {
        mutiSelectedPPsitions.clear();
        notifyDataSetChanged();
    }

    /**
     * 选中所有选择项
     */
    public void selectAllPositions() {
        mutiSelectedPPsitions.clear();
        for (int i = 0; i < getItemCount(); i++) {
            mutiSelectedPPsitions.add(i);
        }
        notifyDataSetChanged();
    }

    /**
     * 是否选中项
     *
     * @param data 数据
     * @return true:是   false:不是
     */
    public boolean isSelected(Integer data) {
        return mutiSelectedPPsitions.contains(data);
    }
}
