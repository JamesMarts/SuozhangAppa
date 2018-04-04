/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/25 16:42
 */
public class BannerBo implements BaseEntity   {
    private String imageUrl ;
    private String name;
    private String id;
    private String src;
    private boolean isDefault;

    public BannerBo(String src) {
        this.src = src;
    }

    public BannerBo() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "BannerBo{" +
                "completeSrc='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", src='" + src + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
