package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/9/1 15:24
 */
public class WxLoginInfoBo implements BaseEntity {


    /**
     * access_token : I-UyF9U9KSSZ-kESvn4D7SVrbvoQwJzQYr_wl4NfIMSh10V3aJ6DZolts8IshpE5kXvGK9hCX56uWHUrc6_tGg
     * expires_in : 7200
     * openid : oQO_mwxD2M-t457EeO2NZLplO9bw
     * refresh_token : LTVVC_o83dJnc5ma0Jg4X-6rRus-0oEE6sgox7hSOgITvEXDhVmoIKUPOhEGkpvDaeWvzBrgu9Afzp9hmIyqUw
     * scope : snsapi_userinfo
     * unionid : onkxow2WAVfIlG2iQT06TuhAFNkU
     */

    private String access_token;
    private String expires_in;
    private String openid;
    private String refresh_token;
    private String scope;
    private String unionid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Override
    public String toString() {
        return "WxLoginInfoBo{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", openid='" + openid + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", scope='" + scope + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
