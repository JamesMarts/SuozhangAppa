package com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity;

import com.baiiu.filter.FilterBaseBo;

/**
 * 描述：
 */
public class FilterUrl {
    private volatile static FilterUrl filterUrl;

    private FilterUrl() {
    }

    public static FilterUrl instance() {
        if (filterUrl == null) {
            synchronized (FilterUrl.class) {
                if (filterUrl == null) {
                    filterUrl = new FilterUrl();
                }
            }
        }
        return filterUrl;
    }

    public FilterBaseBo singleListPosition;
    public FilterBaseBo doubleListLeft;
    public FilterBaseBo doubleListRight;
    public FilterBaseBo doubleListEnd;
    public FilterBaseBo singleGridPosition;
    public FilterBaseBo doubleGridTop;
    public FilterBaseBo doubleGridBottom;

    public int position;
    public FilterBaseBo positionTitle;

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (singleListPosition!=null) {
            buffer.append("singleListPosition=");
            buffer.append(singleListPosition);
            buffer.append("\n");
        }


        if (doubleListLeft!=null) {
            buffer.append("doubleListLeft=");
            buffer.append(doubleListLeft);
            buffer.append("\n");
        }

        if (doubleListRight!=null) {
            buffer.append("doubleListRight=");
            buffer.append(doubleListRight);
            buffer.append("\n");
        }

        if (doubleListEnd!=null) {
            buffer.append("doubleListEnd=");
            buffer.append(doubleListEnd);
            buffer.append("\n");
        }

        if (singleGridPosition!=null) {
            buffer.append("singleGridPosition=");
            buffer.append(singleGridPosition);
            buffer.append("\n");
        }

        if (doubleGridTop!=null) {
            buffer.append("doubleGridTop=");
            buffer.append(doubleGridTop);
            buffer.append("\n");
        }

        if (doubleGridBottom!=null) {
            buffer.append("doubleGridBottom=");
            buffer.append(doubleGridBottom);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public void clear() {
        filterUrl = null;
    }


}