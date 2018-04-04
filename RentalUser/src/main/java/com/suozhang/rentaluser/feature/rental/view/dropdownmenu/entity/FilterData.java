package com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity;

import com.baiiu.filter.FilterBaseBo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/1/5 14:19
 */
public class FilterData {
    public static List<FilterBaseBo> getRentMoney() {
        List<FilterBaseBo> list = new ArrayList<>();
        list.add(new FilterBaseBo("","不限"));
        list.add(new FilterBaseBo("0,1500","1500以下"));
        list.add(new FilterBaseBo("1500,2500","1500-2500"));
        list.add(new FilterBaseBo("2500,3500","2500-3500"));
        list.add(new FilterBaseBo("3500,4500","3500-4500"));
        list.add(new FilterBaseBo("4500,100000000","4500以上"));
        return list;
    }
    public static List<String> getRentType() {
        List<String> list = new ArrayList<>();
        list.add("不限");
        list.add("一室");
        list.add("两室");
        list.add("三室");
        list.add("三室以上");
        return list;
    }
    public static List<FilterBaseBo> getTypes() {
        List<FilterBaseBo> list = new ArrayList<>();
        list.add(new FilterBaseBo("0","整租"));
        list.add(new FilterBaseBo("1","合租"));

        return list;
    }
    public static List<String> getFX() {
        List<String> list = new ArrayList<>();
        list.add("东");
        list.add("南");
        list.add("西");
        list.add("北");

        return list;
    }
}
