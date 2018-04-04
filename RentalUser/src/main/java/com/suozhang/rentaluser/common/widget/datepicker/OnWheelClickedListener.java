/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.common.widget.datepicker;

/**
 * Wheel clicked listener interface.
 * <p>The onItemClicked() method is called whenever a wheel item is clicked
 * <li> New Wheel position is set
 * <li> Wheel view is scrolled
 */
public interface OnWheelClickedListener {
    /**
     * Callback method to be invoked when current item clicked
     * @param wheel the wheel view
     * @param itemIndex the index of clicked item
     */
    void onItemClicked(WheelView wheel, int itemIndex);
}
