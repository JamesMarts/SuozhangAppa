package com.suozhang.rentaluser.feature.rental.view.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.RoomConfigBo;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/7 14:19
 */
public class RoomConfigurationAdapter extends BaseQuickAdapter<RoomConfigBo, BaseViewHolder> {
    public RoomConfigurationAdapter() {
        super(R.layout.item_room_configuration);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoomConfigBo item) {
        helper.setText(R.id.tv_room_configuration_name, TextUtils.isEmpty(item.getName()) ? "" : item.getName());
        AM.image().bind(item.getIcon(), (ImageView) helper.getView(R.id.iv_room_configuration_image));
    }
}
