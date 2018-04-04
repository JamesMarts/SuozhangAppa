package com.suozhang.rentaluser.entity.bo;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/12 15:34
 */
public class LifeMenuSection extends SectionEntity<LifeMenuBo> {

    private boolean isMore;
    public LifeMenuSection(boolean isHeader, String header, boolean isMroe) {
        super(isHeader, header);
        this.isMore = isMroe;
    }

    public LifeMenuSection(LifeMenuBo t) {
        super(t);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean mroe) {
        isMore = mroe;
    }
}

