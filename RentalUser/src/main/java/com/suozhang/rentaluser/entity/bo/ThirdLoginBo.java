package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/5 15:17
 */
public class ThirdLoginBo implements BaseEntity {

    /**
     * subscribe : true
     * nickname : sample string 2
     * sex : 3
     * city : sample string 4
     * country : sample string 5
     * province : sample string 6
     * language : sample string 7
     * headimgurl : sample string 8
     * subscribe_Time : 2017-09-05 14:44:47
     * unionid : sample string 9
     * openId : sample string 10
     * hotelId : sample string 11
     * wxAccount : sample string 12
     * userSource : 0
     */

    private boolean subscribe;
    private String nickname;
    private int sex;
    private String city;
    private String country;
    private String province;
    private String language;
    private String headimgurl;
    private String subscribe_Time;
    private String unionid;
    private String openId;
    private String hotelId;
    private String wxAccount;
    private int userSource;

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getSubscribe_Time() {
        return subscribe_Time;
    }

    public void setSubscribe_Time(String subscribe_Time) {
        this.subscribe_Time = subscribe_Time;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    public int getUserSource() {
        return userSource;
    }

    public void setUserSource(int userSource) {
        this.userSource = userSource;
    }

    @Override
    public String toString() {
        return "ThirdLoginBo{" +
                "subscribe=" + subscribe +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", subscribe_Time='" + subscribe_Time + '\'' +
                ", unionid='" + unionid + '\'' +
                ", openId='" + openId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", wxAccount='" + wxAccount + '\'' +
                ", userSource=" + userSource +
                '}';
    }
}
