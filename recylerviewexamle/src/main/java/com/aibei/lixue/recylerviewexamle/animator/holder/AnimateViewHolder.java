package com.aibei.lixue.recylerviewexamle.animator.holder;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView;

/**
 * 作者：lixue on 2017/2/21 15:24
 */

public interface AnimateViewHolder {
    void preAnimateAddImpl(final RecyclerView.ViewHolder holder);

    void preAnimateRemoveImpl(final RecyclerView.ViewHolder holder);

    void animateAddImpl(final RecyclerView.ViewHolder holder, ViewPropertyAnimatorListener listener);

    void animateRemoveImpl(final RecyclerView.ViewHolder holder, ViewPropertyAnimatorListener listener);
}
