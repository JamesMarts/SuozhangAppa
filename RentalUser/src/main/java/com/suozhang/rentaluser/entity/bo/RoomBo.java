package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/10/25 17:04
 */
public class RoomBo implements BaseEntity {
    private  String logoUrl;
    private  String title;
    private  String type;
    private  String community;
    private  int price;

    public RoomBo(String logoUrl, String title, String type, String community, int price) {

        this.logoUrl = logoUrl;
        this.title = title;
        this.type = type;
        this.community = community;
        this.price = price;
    }

    public RoomBo() {
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
