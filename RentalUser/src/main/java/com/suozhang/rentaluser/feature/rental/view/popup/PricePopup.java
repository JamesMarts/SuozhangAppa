package com.suozhang.rentaluser.feature.rental.view.popup;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;
import com.suozhang.rentaluser.entity.enums.SearchType;
import com.suozhang.rentaluser.feature.rental.view.HouseActivity;
import com.suozhang.rentaluser.feature.rental.view.RentalListActivity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/1/2 15:59
 */
public class PricePopup extends PopupWindow {


    TextView mTvPopupRentName;
    ImageView mIvRentItemLogo;
    TextView mTvRentItemName;
    TextView mTvRentItemType;
    TextView mTvRentItemCommunity;
    TextView mTvRentItemPrice;
    private LinearLayout mBtnToInfo;
    private ImageView mBtnToList;
    private Context context;
    RentParamsBo mRentParamsBo;

    private View view;
    private HouseRoomBo mData;

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public PricePopup(final Context mContext, HouseRoomBo houseRoomBo, RentParamsBo rentParamsBo) {

        this.view = LayoutInflater.from(mContext).inflate(R.layout.popup_map_rent, null);
        this.context = mContext;
        this.mData = houseRoomBo;
        this.mRentParamsBo = rentParamsBo;
        this.setFocusable(false);
        this.setOutsideTouchable(true);
    /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        mTvPopupRentName = view.findViewById(R.id.tv_popup_rent_name);
        mIvRentItemLogo = view.findViewById(R.id.iv_rent_item_logo);
        mTvRentItemPrice = view.findViewById(R.id.tv_rent_item_price);
        mTvRentItemType = view.findViewById(R.id.tv_rent_item_type);
        mTvRentItemCommunity = view.findViewById(R.id.tv_rent_item_community);
        mTvRentItemName = view.findViewById(R.id.tv_rent_item_name);
        mBtnToInfo = view.findViewById(R.id.btn_map_info);
        mBtnToList = view.findViewById(R.id.btn_map_list);
        mBtnToInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HouseActivity.class);
                intent.putExtra("id", mData.getId());
                mContext.startActivity(intent);
                dismiss();
            }
        });
        mBtnToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RentalListActivity.class);
                intent.putExtra("rentType", SearchType.NEAR.type);
                intent.putExtra("areaId", mRentParamsBo.getAreaId());
                mContext.startActivity(intent);
                dismiss();
            }
        });


        AM.image().bind(mData.getRoomImagePic().getUrl(), mIvRentItemLogo);
        mTvPopupRentName.setText(mData.getArea() + "-" + mData.getName());
        mTvRentItemPrice.setText(mData.getRentMoney() + "");
        mTvRentItemType.setText((TextUtils.isEmpty(mData.getRoomTypeName()) ? "户型未知" : mData.getRoomTypeName()) + "\t|\t" + (mData.isRentType() ? "整租" : "分租"));
        mTvRentItemCommunity.setText(mData.getName());
        mTvRentItemName.setText("[" + mData.getArea() + "]\t\t" + (TextUtils.isEmpty(mData.getDescription()) ? "" : mData.getDescription()));

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);

        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.take_photo_anim);

    }
}
