package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/1 15:24
 */
public class WBUserInfoBo implements BaseEntity {


    /**
     * accessToken : 2.00rmOQVCcQK6eCef80cec1d8_jDSaB
     * access_token : 2.00rmOQVCcQK6eCef80cec1d8_jDSaB
     * description : 要一直一直在一起！
     * expiration : 1662369575152
     * expires_in : 1662369575152
     * gender : 男
     * iconurl : http://tvax2.sinaimg.cn/crop.0.0.1242.1242.50/88bebf3dly8fip14x2ad8j20yi0yigoq.jpg
     * id : 2294202173
     * idstr : 2294202173
     * insecurity : {"sexual_content":false}
     * lang : zh-cn
     * location : 广东 深圳
     * name : 我們不熟嘛
     * online_status : 0
     * pagefriends_count : 2
     * profile_image_url : http://tvax2.sinaimg.cn/crop.0.0.1242.1242.50/88bebf3dly8fip14x2ad8j20yi0yigoq.jpg
     * profile_url : u/2294202173
     * ptype : 0
     * refreshToken : 2.00rmOQVCcQK6eC0b617ab4148oVaAC
     * remark :
     * screen_name : 我們不熟嘛
     * star : 0
     * uid : 2294202173
     */

    private String accessToken;
    private String access_token;
    private String description;
    private String expiration;
    private String expires_in;
    private String gender;
    private String iconurl;
    private String id;
    private String idstr;
    private String insecurity;
    private String lang;
    private String location;
    private String name;
    private String online_status;
    private String pagefriends_count;
    private String profile_image_url;
    private String profile_url;
    private String ptype;
    private String refreshToken;
    private String remark;
    private String screen_name;
    private String star;
    private String uid;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getInsecurity() {
        return insecurity;
    }

    public void setInsecurity(String insecurity) {
        this.insecurity = insecurity;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnline_status() {
        return online_status;
    }

    public void setOnline_status(String online_status) {
        this.online_status = online_status;
    }

    public String getPagefriends_count() {
        return pagefriends_count;
    }

    public void setPagefriends_count(String pagefriends_count) {
        this.pagefriends_count = pagefriends_count;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "WBLoginInfoBo{" +
                "accessToken='" + accessToken + '\'' +
                ", access_token='" + access_token + '\'' +
                ", description='" + description + '\'' +
                ", expiration='" + expiration + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", gender='" + gender + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", id='" + id + '\'' +
                ", idstr='" + idstr + '\'' +
                ", insecurity='" + insecurity + '\'' +
                ", lang='" + lang + '\'' +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", online_status='" + online_status + '\'' +
                ", pagefriends_count='" + pagefriends_count + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                ", profile_url='" + profile_url + '\'' +
                ", ptype='" + ptype + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", remark='" + remark + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", star='" + star + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
