package com.suozhang.rentaluser.feature.life.view.adapter;

import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.BaseBo;

import java.util.List;
import java.util.Vector;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/19 16:45
 */
public class RepairTimeAdapter extends BaseQuickAdapter<BaseBo, BaseViewHolder> {
    private int lastPosition = -1;                                //记录上一次选中的图片位置，-1表示未选中
    private Vector<Boolean> vector = new Vector<Boolean>();
    public RepairTimeAdapter(List<BaseBo> baseBos) {
        super(R.layout.item_repair_time,baseBos);
        for (int i = 0; i < baseBos.size(); i++) {
            vector.add(false);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBo item) {
        helper.setText(R.id.tv_item_time, TextUtils.isEmpty(item.getName())?"":item.getName());

        TextView bt_room_press=helper.getView(R.id.tv_item_time);
        if (vector.elementAt(helper.getPosition()) == true) {

            bt_room_press.setTextColor(AM.app().getResources().getColor(R.color.primary_highlight));

        } else {

            bt_room_press.setTextColor(AM.app().getResources().getColor(R.color.text_primary));
        }

    }


    public void changeState(int position) {
        if (lastPosition != -1)
            vector.setElementAt(false, lastPosition);                   //取消上一次的选中状态
        vector.setElementAt(!vector.elementAt(position), position);     //直接取反即可
        lastPosition = position;                                        //记录本次选中的位置
        notifyDataSetChanged();                                         //通知适配器进行更新
    }
}
