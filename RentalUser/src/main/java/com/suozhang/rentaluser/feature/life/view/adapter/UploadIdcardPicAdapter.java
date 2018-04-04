/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.life.view.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.PicBo;

import java.io.File;


/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/7/26 10:41
 */

public class UploadIdcardPicAdapter extends BaseQuickAdapter<PicBo, BaseViewHolder> {

    private boolean isShowDelete = true;

    public UploadIdcardPicAdapter() {
        super(R.layout.item_upload_id_card_pic);
    }

    /**
     * 设置自动显示删除按钮
     * 根据有无添加按钮，自动显示删除按钮，有添加按钮，则显示删除按钮
     */
    public void setAtuoShowDelete() {
        setShowDelete(hasAdd());
    }

    /**
     * 设置显示删除按钮
     *
     * @param isShowDelete
     */
    public void setShowDelete(boolean isShowDelete) {
        this.isShowDelete = isShowDelete;
        notifyDataSetChanged();
    }


    /**
     * 是否包含添加按钮
     *
     * @return true:包含 false:不包含
     */
    public boolean hasAdd() {
        if (mData == null || mData.isEmpty()) {
            return false;
        }
        for (PicBo pic : mData) {
            if (pic.isAddBtn()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 增加添加按钮
     */
    public void addAddedPic() {
        if (mData == null) {
            return;
        }
        if (!hasAdd()) {
            mData.add(0, new PicBo(true));
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, PicBo item) {
        ImageView imgView = helper.getView(R.id.img_pic);

        boolean isAddBtn = item.isAddBtn();

        String url = item.getUrl();

        if (isAddBtn) {
            imgView.setImageResource(R.drawable.ic_repair_upload_img);
        } else {
            if (TextUtils.isEmpty(url)) {
                File file = item.getFile();
                AM.image().bind(file, imgView);
            } else {
                AM.image().bind(url, imgView);
            }
        }


        if (isShowDelete) {
            if (isAddBtn) {
                helper.setGone(R.id.btn_delete, false);
            } else {
                helper.setGone(R.id.btn_delete, true);
                helper.addOnClickListener(R.id.btn_delete);
            }
        } else {
            helper.setGone(R.id.btn_delete, false);
        }

    }
}
