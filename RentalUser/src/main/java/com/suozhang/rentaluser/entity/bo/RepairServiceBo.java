package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/15 11:10
 */
public class RepairServiceBo implements BaseEntity {
    private String repairDate;
    private int repairState;
    private String repairInfo;

    public RepairServiceBo(String repairDate, int repairState, String repairInfo) {
        this.repairDate = repairDate;
        this.repairState = repairState;
        this.repairInfo = repairInfo;
    }

    public RepairServiceBo() {
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public int getRepairState() {
        return repairState;
    }

    public void setRepairState(int repairState) {
        this.repairState = repairState;
    }

    public String getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(String repairInfo) {
        this.repairInfo = repairInfo;
    }

    @Override
    public String toString() {
        return "RepairServiceBo{" +
                "repairDate='" + repairDate + '\'' +
                ", repairState=" + repairState +
                ", repairInfo='" + repairInfo + '\'' +
                '}';
    }
}
