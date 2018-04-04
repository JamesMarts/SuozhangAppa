package com.suozhang.rentaluser.feature.rental.view.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/19 16:45
 */
public class RentalAdapter2 extends BaseQuickAdapter<HouseRoomBo, BaseViewHolder> {

    public RentalAdapter2() {
        super(R.layout.item_room2);
    }

    @Override
    protected void convert(BaseViewHolder helper, HouseRoomBo item) {
        helper.setText(R.id.tv_rent_item_name, "[" + item.getArea() + "]\t\t" +(TextUtils.isEmpty( item.getDescription())?"": item.getDescription()))
                .setText(R.id.tv_rent_item_type, (TextUtils.isEmpty( item.getRoomTypeName())?"户型未知": item.getRoomTypeName()) + "\t|\t" + (item.isRentType() ? "整租" : "分租"))
                .setText(R.id.tv_rent_item_community, item.getName())
                .setText(R.id.tv_rent_item_price, (int)item.getRentMoney() + "");


        if (item.getRoomImagePic()!=null){
            AM.image().bind(item.getRoomImagePic().getUrl(), (ImageView) helper.getView(R.id.iv_rent_item_logo));
        }else {
            AM.image().bind("", (ImageView) helper.getView(R.id.iv_rent_item_logo));
        }
    }
}
