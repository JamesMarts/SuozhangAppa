package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/1 15:24
 */
public class WxUserInfoBo implements BaseEntity {

    /**
     * accessToken : NbfybTHD6f4Xf6QOZ80k7EXkEBpI93kpBPtPjZ8hdODZsTZB67Lc7HmP0uv3MV8PcF1xyugEp3zUlncFxPlrTg
     * access_token : NbfybTHD6f4Xf6QOZ80k7EXkEBpI93kpBPtPjZ8hdODZsTZB67Lc7HmP0uv3MV8PcF1xyugEp3zUlncFxPlrTg
     * city :
     * country : 安道尔
     * expiration : 1504257762912
     * expires_in : 1504257762912
     * gender : 女
     * iconurl : http://wx.qlogo.cn/mmopen/vi_32/5kWojk6Mhc9EdZJFu6S6f3KiaplPT0aMVib63ympoawY6uib7zVvo9hvR0cSRPWiaJlfxXGQxrEeOrLp575uAvk9ng/0
     * language : zh_CN
     * name : 時空猎人
     * openid : oQO_mwxD2M-t457EeO2NZLplO9bw
     * profile_image_url : http://wx.qlogo.cn/mmopen/vi_32/5kWojk6Mhc9EdZJFu6S6f3KiaplPT0aMVib63ympoawY6uib7zVvo9hvR0cSRPWiaJlfxXGQxrEeOrLp575uAvk9ng/0
     * province :
     * refreshToken : KG50k1naxzhsQAAQQDUSjEaQdW_u2cTJ2Q36hIn8Ade2y8q6uCqYOxcWM93Q2u9LKcI9IY1p92ZpGTDK2RrqhA
     * screen_name : 時空猎人
     * uid : onkxow2WAVfIlG2iQT06TuhAFNkU
     * unionid : onkxow2WAVfIlG2iQT06TuhAFNkU
     */

    private String accessToken;
    private String access_token;
    private String city;
    private String country;
    private String expiration;
    private String expires_in;
    private String gender;
    private String iconurl;
    private String language;
    private String name;
    private String openid;
    private String profile_image_url;
    private String province;
    private String refreshToken;
    private String screen_name;
    private String uid;
    private String unionid;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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

    @Override
    public String toString() {
        return "WeChatBo{" +
                "accessToken='" + accessToken + '\'' +
                ", access_token='" + access_token + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", expiration='" + expiration + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", gender='" + gender + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", openid='" + openid + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", province='" + province + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", uid='" + uid + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
