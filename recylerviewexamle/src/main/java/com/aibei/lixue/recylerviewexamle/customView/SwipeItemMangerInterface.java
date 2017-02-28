package com.aibei.lixue.recylerviewexamle.customView;

import java.util.List;

/**
 * 作者：lixue on 2017/2/28 16:35
 */

public interface SwipeItemMangerInterface {

    void openItem(int position);

    void closeItem(int position);

    void closeAllExcept(SwipeRevealLayout layout);

    void closeAllItems();

    List<Integer> getOpenItems();

    List<SwipeRevealLayout> getOpenLayouts();

    void removeShownLayouts(SwipeRevealLayout layout);

    boolean isOpen(int position);

    Attributes.Mode getMode();

    void setMode(Attributes.Mode mode);
}