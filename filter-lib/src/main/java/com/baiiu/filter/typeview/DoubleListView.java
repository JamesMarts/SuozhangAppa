package com.baiiu.filter.typeview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baiiu.filter.R;
import com.baiiu.filter.adapter.BaseBaseAdapter;
import com.baiiu.filter.adapter.SimpleTextAdapter;
import com.baiiu.filter.util.CommonUtil;

import java.util.List;

/**
 * Created by baiiu on 15/12/17.
 * 双列ListView
 */
public class DoubleListView<LEFTD, RIGHTD, END> extends LinearLayout implements AdapterView.OnItemClickListener {

    private BaseBaseAdapter<LEFTD> mLeftAdapter;
    private BaseBaseAdapter<RIGHTD> mRightAdapter;
    private BaseBaseAdapter<END> mEndAdapter;
    private ListView lv_left;
    private ListView lv_right;
    private ListView lv_end;

    public DoubleListView(Context context) {
        this(context, null);
    }

    public DoubleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DoubleListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        inflate(context, R.layout.merge_filter_list, this);

        lv_left = (ListView) findViewById(R.id.lv_left);

        lv_right = (ListView) findViewById(R.id.lv_right);
        lv_end = findViewById(R.id.lv_end);

        lv_left.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv_right.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv_end.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lv_left.setOnItemClickListener(this);
        lv_right.setOnItemClickListener(this);
        lv_end.setOnItemClickListener(this);
    }


    public DoubleListView<LEFTD, RIGHTD, END> leftAdapter(SimpleTextAdapter<LEFTD> leftAdapter) {
        mLeftAdapter = leftAdapter;
        lv_left.setAdapter(leftAdapter);
        return this;
    }

    public DoubleListView<LEFTD, RIGHTD, END> rightAdapter(SimpleTextAdapter<RIGHTD> rightAdapter) {
        mRightAdapter = rightAdapter;
        lv_right.setAdapter(rightAdapter);
        return this;
    }

    public DoubleListView<LEFTD, RIGHTD, END> endAdapter(SimpleTextAdapter<END> endAdapter) {
        mEndAdapter = endAdapter;
        lv_end.setAdapter(endAdapter);
        return this;
    }

    public void setLeftList(List<LEFTD> list, int checkedPosition) {
        mLeftAdapter.setList(list);

        if (checkedPosition != -1) {
//            lv_left.performItemClick(mLeftAdapter.getView(checkedPositoin, null, null), checkedPositoin, mLeftAdapter.getItemId(checkedPositoin));//调用此方法相当于点击.第一次进来时会触发重复加载.
            lv_left.setItemChecked(checkedPosition, true);
        }
    }


    public void setRightList(List<RIGHTD> list, int checkedPosition) {
        mRightAdapter.setList(list);
        if (checkedPosition != -1) {
            lv_right.setItemChecked(checkedPosition, true);
        }
    }

    public void setEndList(List<END> list, int checkedPosition) {
        mEndAdapter.setList(list);
        if (checkedPosition != -1) {
            lv_end.setItemChecked(checkedPosition, true);
        }
    }

    private OnLeftItemClickListener<LEFTD, RIGHTD, END> mOnLeftItemClickListener;
    private OnRightItemClickListener<LEFTD, RIGHTD, END> mOnRightItemClickListener;
    private OnEndItemClickListener<END> mOnEndItemClickListener;

    public interface OnLeftItemClickListener<LEFTD, RIGHTD, END> {
        List<RIGHTD> provideRightList(LEFTD leftAdapter, int position);
    }

    public interface OnRightItemClickListener<LEFTD, RIGHTD, END> {
        List<END> onRightItemClick(RIGHTD childItem, int position);
    }

    public interface OnEndItemClickListener<END> {
        void onEndItemClick(END endItem);
    }


    public DoubleListView<LEFTD, RIGHTD, END> onLeftItemClickListener(OnLeftItemClickListener<LEFTD, RIGHTD, END> onLeftItemClickListener) {
        this.mOnLeftItemClickListener = onLeftItemClickListener;
        return this;
    }

    public DoubleListView<LEFTD, RIGHTD, END> onRightItemClickListener(OnRightItemClickListener<LEFTD, RIGHTD, END> onRightItemClickListener) {
        this.mOnRightItemClickListener = onRightItemClickListener;
        return this;
    }

    public DoubleListView<LEFTD, RIGHTD, END> onEndItemClickListener(OnEndItemClickListener<END> mOnEndItemClickListener) {
        this.mOnEndItemClickListener = mOnEndItemClickListener;
        return this;
    }

    public ListView getLeftListView() {
        return lv_left;
    }

    public ListView getRightListView() {
        return lv_right;
    }

    public ListView getEndListView() {
        return lv_end;
    }

    //========================点击事件===================================
    private int mRightLastChecked;
    private int mLeftLastPosition;
    private int mLeftLastCheckedPosition;
    private int mEndLastPosition;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }

        if (mLeftAdapter == null || mRightAdapter == null || mEndAdapter == null) {
            return;
        }

        if (parent == lv_left) {
            mLeftLastPosition = position;

            if (mOnLeftItemClickListener != null) {
                LEFTD item = mLeftAdapter.getItem(position);


                List<RIGHTD> rightds = mOnLeftItemClickListener.provideRightList(item, position);
                mRightAdapter.setList(rightds);
                mEndAdapter.setList(null);

                if (CommonUtil.isEmpty(rightds)) {
                    //当前点的就是这个条目
                    mLeftLastCheckedPosition = -1;
                }
            }

            lv_right.setItemChecked(mRightLastChecked, mLeftLastCheckedPosition == position);
        } else if (parent == lv_right) {
            mLeftLastCheckedPosition = mLeftLastPosition;
            mRightLastChecked = position;
            RIGHTD item = mRightAdapter.getItem(position);
            List<END> endList = mOnRightItemClickListener.onRightItemClick(item, position);
            mEndAdapter.setList(endList);
            if (endList != null && endList.size() > 0) {
                getEndListView().setVisibility(View.VISIBLE);
            } else {
                getEndListView().setVisibility(View.GONE);
            }

            if (mOnRightItemClickListener != null) {
                mOnRightItemClickListener.onRightItemClick(mRightAdapter.getItem(mRightLastChecked), position);
            }
        } else if (parent == lv_end) {
            Log.e("--------------------->", "END" + position);
            mEndLastPosition = position;
            if (mOnEndItemClickListener != null) {
                mOnEndItemClickListener.onEndItemClick(mEndAdapter.getItem(mEndLastPosition));
            }
        }
    }


}
