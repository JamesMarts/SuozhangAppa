package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/1/5 16:40
 */
public class NearInfoBo implements BaseEntity {


    /**
     * longitude : 0.0
     * latitude : 0.0
     * screeningInfo : []
     * id : 214b3d19-970d-4876-9577-af94e9702b2c
     * name : 热门搜索
     * createTime : 2018-01-05 16:36:08
     * version : null
     */

    private double longitude;
    private double latitude;
    private String id;
    private String name;
    private String createTime;
    private Object version;
    private NearInfoBo screeningInfo;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public NearInfoBo getScreeningInfo() {
        return screeningInfo;
    }

    public void setScreeningInfo(NearInfoBo screeningInfo) {
        this.screeningInfo = screeningInfo;
    }
}
