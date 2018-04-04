package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/13 16:31
 */
public class PayTypeBo implements BaseEntity {

    private String name;
    private int image;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PayTypeBo(String name, int image, int type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public PayTypeBo() {
    }
}
