package com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity;

import com.baiiu.filter.BaseEntity;
import com.baiiu.filter.FilterBaseBo;

import java.util.List;

/**
 * author: baiiu
 * date: on 16/2/19 18:09
 * description:
 */
public class FilterType implements BaseEntity{
    public FilterBaseBo desc;
    public List<FilterBaseBo> child;

    public FilterType(FilterBaseBo desc, List<FilterBaseBo> child) {
        this.desc = desc;
        this.child = child;
    }

    public FilterType() {

    }
}
