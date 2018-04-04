package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/12 15:35
 */
public class LifeMenuBo implements BaseEntity {
    private int img;
    private String name;
    private int clickType;

    public int getClickType() {
        return clickType;
    }

    public void setClickType(int clickType) {
        this.clickType = clickType;
    }

    public LifeMenuBo(int img, String name, int clickType) {
        this.img = img;
        this.name = name;
        this.clickType = clickType;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
