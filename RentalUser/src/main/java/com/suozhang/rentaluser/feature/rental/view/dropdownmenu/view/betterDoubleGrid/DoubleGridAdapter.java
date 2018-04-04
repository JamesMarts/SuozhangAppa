package com.suozhang.rentaluser.feature.rental.view.dropdownmenu.view.betterDoubleGrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.baiiu.filter.FilterBaseBo;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.view.betterDoubleGrid.holder.ItemViewHolder;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.view.betterDoubleGrid.holder.TitleViewHolder;

import java.util.List;

/**
 * auther: baiiu
 * time: 16/6/5 05 23:28
 * description:
 */
public class DoubleGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_TITLE = 0;
    private static final int TYPE_ITEM = 1;

    private Context mContext;
    private List<FilterBaseBo> topGridData;
    private List<FilterBaseBo> bottomGridData;
    private View.OnClickListener mListener;

    public DoubleGridAdapter(Context context, List<FilterBaseBo> topGridData, List<FilterBaseBo> bottomGridList, View.OnClickListener listener) {
        this.mContext = context;
        this.topGridData = topGridData;
        this.bottomGridData = bottomGridList;
        this.mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == topGridData.size() + 1) {
            return TYPE_TITLE;
        }

        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case TYPE_TITLE:
                holder = new TitleViewHolder(mContext, parent);
                break;
            case TYPE_ITEM:
                holder = new ItemViewHolder(mContext, parent, mListener);
                break;
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case TYPE_TITLE:
                TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
                if (position == 0) {
                    titleViewHolder.bind("出租方式");
                } else {
                    titleViewHolder.bind("房间朝向");
                }
                break;
            case TYPE_ITEM:
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                if (position < topGridData.size() + 1) {
                    itemViewHolder.bind(topGridData.get(position - 1));
                } else {
                    itemViewHolder.bind(bottomGridData.get(position - topGridData.size() - 2));
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return topGridData.size() + bottomGridData.size() + 2;
    }
}
