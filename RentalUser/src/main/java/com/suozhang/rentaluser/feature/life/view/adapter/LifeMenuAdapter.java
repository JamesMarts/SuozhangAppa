package com.suozhang.rentaluser.feature.life.view.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suozhang.framework.framework.AM;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.LifeMenuBo;
import com.suozhang.rentaluser.entity.bo.LifeMenuSection;

import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/12 15:37
 */
public class LifeMenuAdapter extends BaseSectionQuickAdapter<LifeMenuSection, BaseViewHolder> {


    public LifeMenuAdapter(List<LifeMenuSection> data) {
        super(R.layout.item_life_menu_content, R.layout.item_life_menu_head, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, LifeMenuSection item) {
        helper.setText(R.id.tv_life_menu_head_text, item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, LifeMenuSection item) {
        LifeMenuBo lifeMenuBo = item.t;
        helper.setText(R.id.tv_life_menu_content_text, lifeMenuBo.getName()).addOnClickListener(R.id.view_life_menu);
        AM.image().bind(lifeMenuBo.getImg(), (ImageView) helper.getView(R.id.iv_life_menu_content_img));
    }
}
