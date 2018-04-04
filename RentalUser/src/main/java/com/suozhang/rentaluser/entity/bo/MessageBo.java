package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.Date;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/3/7 9:18
 */
public class MessageBo implements BaseEntity {


    /**
     * businessId : 10dba375-adec-4e03-adf3-26f5ef2041db
     * type : null
     * isRead : false
     * content : 尊敬的00租户你好,您的月账单已出,请及时交租,账单周期:2018/3/1 0:00:00到2018/3/31 0:00:00
     * contentInfo : null
     * userId : null
     * title : 房租催租
     * image : null
     * pageUrl : null
     * iconUrl : null
     * id : a613e583-b44c-41c7-9471-10678d352873
     * name : null
     * createTime : 2018-03-06 15:08:42
     * version : null
     */

    private String businessId;
    private String type;
    private boolean isRead;
    private String content;
    private String contentInfo;
    private String userId;
    private String title;
    private String image;
    private String pageUrl;
    private String iconUrl;
    private String id;
    private String name;
    private Date createTime;
    private String version;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }


}
