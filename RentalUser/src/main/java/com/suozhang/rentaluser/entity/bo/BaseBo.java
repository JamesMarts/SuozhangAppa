package com.suozhang.rentaluser.entity.bo;


import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/10/19 16:26
 */
public class BaseBo implements BaseEntity{

    /**
     * id : sample string 1
     * name : sample string 2
     * createTime : 2017-10-19 16:18:13
     * version : 1
     */

    private String id;
    private String name;
    private String createTime;
    private int version;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public BaseBo() {
    }

    public BaseBo(String name) {
        this.name = name;
    }

    public BaseBo(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
