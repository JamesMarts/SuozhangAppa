package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.Date;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/20 13:37
 */
public class ContractBo implements BaseEntity {

    /**
     * contractState : 0
     * startDate : 2017-12-20 13:35:01
     * endDate : 2017-12-20 13:35:01
     * roomName : sample string 3
     * id : sample string 4
     * name : sample string 5
     * createTime : 2017-12-20 13:35:01
     * version : 1
     */

    private int contractState;
    private Date startDate;
    private Date endDate;
    private String roomName;
    private String id;
    private String name;
    private Date createTime;
    private int version;

    public int getContractState() {
        return contractState;
    }

    public void setContractState(int contractState) {
        this.contractState = contractState;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
