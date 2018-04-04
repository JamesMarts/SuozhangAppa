package com.baiiu.filter;

import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2018/1/9 15:14
 */
public class FilterBaseBo implements BaseEntity{


    /**
     * longitude : 0
     * latitude : 0
     * screeningInfo : []
     * id : 214b3d19-970d-4876-9577-af94e9702b2c
     * name : 热门搜索
     * createTime : 2018-01-05 16:36:08
     * version : null
     */

    private int longitude;
    private int latitude;
    private String id;
    private String name;
    private String createTime;
    private Object version;
    private List<FilterBaseBo> screeningInfo;

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

    public FilterBaseBo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public FilterBaseBo() {
    }


    @Override
    public String toString() {
        return "FilterBaseBo{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", version=" + version +
                ", screeningInfo=" + screeningInfo +
                '}';
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
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

    public List<FilterBaseBo> getScreeningInfo() {
        return screeningInfo;
    }

    public void setScreeningInfo(List<FilterBaseBo> screeningInfo) {
        this.screeningInfo = screeningInfo;
    }
}
