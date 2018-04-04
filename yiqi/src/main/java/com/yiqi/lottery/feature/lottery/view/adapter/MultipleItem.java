package com.yiqi.lottery.feature.lottery.view.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultipleItem implements MultiItemEntity {
    public static final int ITEM_BANNER = 1;
    public static final int ITEM_MSG = 2;
    public static final int ITEM_TYPE = 3;
    public static final int ITEM_TYPE2 = 4;
    public static final int ITEM_ADV = 5;
    public static final int ITEM_LUCKY_NUMBER = 6;
    public static final int ITEM_FOCUS_EVENT = 7;
    public static final int ITEM_WINNING_COLUMN = 8;

    public static final int IMG_SPAN_SIZE=1;

    private int itemType;

    public MultipleItem() {
    }

    private int spanSize;

    public MultipleItem(int itemType, int spanSize) {
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public MultipleItem(int itemType, int spanSize, String content) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.content = content;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

}
