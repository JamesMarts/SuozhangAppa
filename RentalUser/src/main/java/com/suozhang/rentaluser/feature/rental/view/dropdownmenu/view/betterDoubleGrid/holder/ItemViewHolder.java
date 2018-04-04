package com.suozhang.rentaluser.feature.rental.view.dropdownmenu.view.betterDoubleGrid.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.baiiu.filter.FilterBaseBo;
import com.baiiu.filter.util.UIUtil;
import com.baiiu.filter.view.FilterCheckedTextView;
import com.suozhang.rentaluser.R;

/**
 * auther: baiiu
 * time: 16/6/5 05 23:35
 * description:
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final FilterCheckedTextView textView;
    private View.OnClickListener mListener;

    public ItemViewHolder(Context mContext, ViewGroup parent, View.OnClickListener mListener) {
        super(UIUtil.infalte(mContext, R.layout.holder_item2, parent));
        textView =itemView.findViewById(R.id.tv_item);
        this.mListener = mListener;
    }


    public void bind(FilterBaseBo s) {
        textView.setText(s.getName());
        textView.setTag(s);
        textView.setOnClickListener(mListener);
    }
}
