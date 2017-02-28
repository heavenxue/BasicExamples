package com.aibei.lixue.recylerviewexamle.customView;

/**
 * 作者：lixue on 2017/2/28 16:34
 */

public interface SwipeAdapterInterface {
    int getSwipeLayoutResourceId(int position);

    void notifyDatasetChanged();
}
