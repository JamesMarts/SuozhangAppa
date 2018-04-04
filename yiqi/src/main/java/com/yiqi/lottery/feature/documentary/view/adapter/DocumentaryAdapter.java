package com.yiqi.lottery.feature.documentary.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yiqi.lottery.R;
import com.yiqi.lottery.entity.bo.DocumentaryBo;

import java.util.List;

public class DocumentaryAdapter extends BaseQuickAdapter<DocumentaryBo,BaseViewHolder>{
    public DocumentaryAdapter() {
        super(R.layout.item_documentary_list);
    }

    @Override
    protected void convert(BaseViewHolder helper, DocumentaryBo item) {
        helper.setText(R.id.tv_documentary_name,item.getName())
        .addOnClickListener(R.id.btn_to_personalinfo);
    }
}
