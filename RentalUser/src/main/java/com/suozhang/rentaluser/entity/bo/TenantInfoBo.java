package com.suozhang.rentaluser.entity.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.suozhang.framework.entity.bo.BaseEntity;
import com.suozhang.rentaluser.entity.enums.CheckinPepoleType;

import java.util.List;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2018/1/15 17:31
 */

public class TenantInfoBo implements BaseEntity, Cloneable {
    /**
     * 入住人Id
     * old :checkInfoPepoleId
     */
    private String id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 是否确认，是否经过房东确认，确认后身份信息将不可修改
     */
    @JSONField(name = "isAffirm")
    private boolean isAffirm;

    /**
     * 承租人姓名
     */
    private String checkInfoPepoleName;

    /**
     * 入住人类别{@link }
     */
    private int checkInfoPepoleType;

    private String recordId;


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * 承租人手机号
     */
    private String phone;

    /**
     * 承租人性别  true：男，false:女
     */
    private boolean sex;

    /**
     * 证件类型Id
     */
    private String cardType;

    /**
     * 证件号
     */
    private String cardNumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * 证件图片路径
     */
    private List<String> listCardImageUrl;

    /**
     * 证件图片封装
     */
    @JSONField(serialize = false)
    private List<PicBo> cardImagePic;

    /**
     * 获取枚举类型的合同状态
     *
     * @return
     */
    @JSONField(serialize = false)
    public CheckinPepoleType getCheckInfoPepoleTypeEnum() {
        return CheckinPepoleType.typeOf(checkInfoPepoleType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isAffirm() {
        return isAffirm;
    }

    public void setAffirm(boolean affirm) {
        isAffirm = affirm;
    }

    public String getCheckInfoPepoleName() {
        return checkInfoPepoleName;
    }

    public void setCheckInfoPepoleName(String checkInfoPepoleName) {
        this.checkInfoPepoleName = checkInfoPepoleName;
    }

    public int getCheckInfoPepoleType() {
        return checkInfoPepoleType;
    }

    public void setCheckInfoPepoleType(int checkInfoPepoleType) {
        this.checkInfoPepoleType = checkInfoPepoleType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getListCardImageUrl() {
        return listCardImageUrl;
    }

    public void setListCardImageUrl(List<String> listCardImageUrl) {
        this.listCardImageUrl = listCardImageUrl;
    }

    public List<PicBo> getCardImagePic() {
        return cardImagePic;
    }

    public void setCardImagePic(List<PicBo> cardImagePic) {
        this.cardImagePic = cardImagePic;
    }

    @Override
    public TenantInfoBo clone() throws CloneNotSupportedException {
        return (TenantInfoBo) super.clone();
    }

    @Override
    public String toString() {
        return "TenantInfoBo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", isAffirm=" + isAffirm +
                ", checkInfoPepoleName='" + checkInfoPepoleName + '\'' +
                ", checkInfoPepoleType=" + checkInfoPepoleType +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", cardType='" + cardType + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", listCardImageUrl=" + listCardImageUrl +
                ", cardImagePic=" + cardImagePic +
                '}';
    }
}
