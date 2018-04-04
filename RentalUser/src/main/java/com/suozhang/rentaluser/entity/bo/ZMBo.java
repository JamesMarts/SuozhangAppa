package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/2/28 16:01
 */
public class ZMBo implements BaseEntity {

    private boolean hasZhimaOpenId;

    private int score;

    private String redirectUrl;

    public boolean isHasZhimaOpenId() {
        return hasZhimaOpenId;
    }

    public void setHasZhimaOpenId(boolean hasZhimaOpenId) {
        this.hasZhimaOpenId = hasZhimaOpenId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
