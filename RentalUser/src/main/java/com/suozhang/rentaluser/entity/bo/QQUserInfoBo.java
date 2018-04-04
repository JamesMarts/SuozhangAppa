package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/1 15:24
 */
public class QQUserInfoBo implements BaseEntity {

    /**
     * accessToken : 54E467578244FC707A4C7AD3197B1422
     * access_token : 54E467578244FC707A4C7AD3197B1422
     * city :
     * expiration : 1512371252383
     * expires_in : 1512371252383
     * gender : 女
     * iconurl : http://q.qlogo.cn/qqapp/1106026809/27087B8CAD8392BE26B9FFD2E4F80672/100
     * is_yellow_vip : 0
     * is_yellow_year_vip : 0
     * level : 0
     * msg :
     * name : Base
     * openid : 27087B8CAD8392BE26B9FFD2E4F80672
     * profile_image_url : http://q.qlogo.cn/qqapp/1106026809/27087B8CAD8392BE26B9FFD2E4F80672/100
     * province :
     * ret : 0
     * screen_name : Base
     * uid : 27087B8CAD8392BE26B9FFD2E4F80672
     * unionid :
     * vip : 0
     * yellow_vip_level : 0
     */

    private String accessToken;
    private String access_token;
    private String city;
    private String expiration;
    private String expires_in;
    private String gender;
    private String iconurl;
    private String is_yellow_vip;
    private String is_yellow_year_vip;
    private String level;
    private String msg;
    private String name;
    private String openid;
    private String profile_image_url;
    private String province;
    private String ret;
    private String screen_name;
    private String uid;
    private String unionid;
    private String vip;
    private String yellow_vip_level;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public void setIs_yellow_vip(String is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
    }

    public String getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }

    public void setIs_yellow_year_vip(String is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getYellow_vip_level() {
        return yellow_vip_level;
    }

    public void setYellow_vip_level(String yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
    }

    @Override
    public String toString() {
        return "QQUserInfoBo{" +
                "accessToken='" + accessToken + '\'' +
                ", access_token='" + access_token + '\'' +
                ", city='" + city + '\'' +
                ", expiration='" + expiration + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", gender='" + gender + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", is_yellow_vip='" + is_yellow_vip + '\'' +
                ", is_yellow_year_vip='" + is_yellow_year_vip + '\'' +
                ", level='" + level + '\'' +
                ", msg='" + msg + '\'' +
                ", name='" + name + '\'' +
                ", openid='" + openid + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", province='" + province + '\'' +
                ", ret='" + ret + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", uid='" + uid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", vip='" + vip + '\'' +
                ", yellow_vip_level='" + yellow_vip_level + '\'' +
                '}';
    }
}
