package com.yiqi.lottery.feature.mine.view.adapter;

import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.BaseBo;

import java.util.List;
import java.util.Vector;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/19 16:45
 */
public class RechargeMoneyAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    private int lastPosition = -1;                                //记录上一次选中的图片位置，-1表示未选中
    private Vector<Boolean> vector = new Vector<Boolean>();
    public RechargeMoneyAdapter(List<Integer> baseBos) {
        super(R.layout.item_user_money,baseBos);
        for (int i = 0; i < baseBos.size(); i++) {
            vector.add(false);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setText(R.id.tv_user_money, item+"");

        TextView bt_room_press=helper.getView(R.id.tv_user_money);
        if (vector.elementAt(helper.getPosition()) == true) {
            bt_room_press.setBackground(AM.app().getResources().getDrawable(R.drawable.user_recharge_selected));
            bt_room_press.setTextColor(AM.app().getResources().getColor(R.color.primary_comparison));

        } else {
            bt_room_press.setBackground(AM.app().getResources().getDrawable(R.drawable.user_recharge_normal));
            bt_room_press.setTextColor(AM.app().getResources().getColor(R.color.colorBlack));
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
