package com.suozhang.rentaluser.entity.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.suozhang.framework.entity.bo.BaseEntity;
import com.suozhang.rentaluser.entity.enums.ContractState2;

import java.util.List;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/13 11:04
 */

public class LeaseContractBo implements BaseEntity, Cloneable {


    private String id;
    /**
     * 房源名称
     */
    private String housingResourceName;
    /**
     * 房间名称
     */
    private String roomName;
    /**
     * 房间Id
     */
    private String roomId;
    /**
     * 出租类型 true：整租，false:分租{@link RentType}
     */
    private boolean rentType;

    /**
     * 起租日期
     */
    private String startDate;
    /**
     * 结束日期
     */
    private String endDate;
    /**
     * 租期
     */
    private int tenancy;
    /**
     * 押付方式 id
     */
    private String depositType;

    /**
     * 租金
     */
    private double rentMoney;
    /**
     * 押金
     */
    private double depositMoney;

    /**
     * 需付租金=租金*支付倍数
     */
    private double payRentMoney;

    /**
     * 备注
     */
    private String remark;
    /**
     * 费用类型Id
     */
    private String costType;
    /**
     * 杂费详情
     */
    private List<CostTypeBo> costTypeInfo;

    /**
     * 合同状态{@link ContractState2}
     */
    private int contractState;
    /**
     * 是否为当前合约
     */
    @JSONField(name = "isCurrentContract")
    private boolean isCurrentContract;
    /**
     * 拒绝原因
     */
    private String refusalCause;

    /**
     * 原始抄表数据
     */
    private List<MeterReadingBo> appMeter;

    /**
     * 入住人信息
     */
    private TenantInfoBo appCheckInfo;


    public LeaseContractBo() {
    }

    public LeaseContractBo(ContractState2 state) {
        this.contractState = state.state();
    }


    /**
     * 获取枚举类型的合同状态
     *
     * @return
     */
    @JSONField(serialize = false)
    public ContractState2 getContractStateEnum() {
        return ContractState2.stateOf(contractState);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHousingResourceName() {
        return housingResourceName;
    }

    public void setHousingResourceName(String housingResourceName) {
        this.housingResourceName = housingResourceName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public boolean isRentType() {
        return rentType;
    }

    public void setRentType(boolean rentType) {
        this.rentType = rentType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTenancy() {
        return tenancy;
    }

    public void setTenancy(int tenancy) {
        this.tenancy = tenancy;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public double getPayRentMoney() {
        return payRentMoney;
    }

    public void setPayRentMoney(double payRentMoney) {
        this.payRentMoney = payRentMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public List<CostTypeBo> getCostTypeInfo() {
        return costTypeInfo;
    }

    public void setCostTypeInfo(List<CostTypeBo> costTypeInfo) {
        this.costTypeInfo = costTypeInfo;
    }

    public int getContractState() {
        return contractState;
    }

    public void setContractState(int contractState) {
        this.contractState = contractState;
    }

    public String getRefusalCause() {
        return refusalCause;
    }

    public void setRefusalCause(String refusalCause) {
        this.refusalCause = refusalCause;
    }

    public boolean isCurrentContract() {
        return isCurrentContract;
    }

    public void setCurrentContract(boolean currentContract) {
        isCurrentContract = currentContract;
    }

    public List<MeterReadingBo> getAppMeter() {
        return appMeter;
    }

    public void setAppMeter(List<MeterReadingBo> appMeter) {
        this.appMeter = appMeter;
    }

    public TenantInfoBo getAppCheckInfo() {
        return appCheckInfo;
    }

    public void setAppCheckInfo(TenantInfoBo appCheckInfo) {
        this.appCheckInfo = appCheckInfo;
    }

    @Override
    public LeaseContractBo clone() throws CloneNotSupportedException {
        return (LeaseContractBo) super.clone();
    }

    @Override
    public String toString() {
        return "LeaseContractBo{" +
                "id='" + id + '\'' +
                "housingResourceName='" + housingResourceName + '\'' +
                "roomName='" + roomName + '\'' +
                ", roomId='" + roomId + '\'' +
                ", rentType=" + rentType +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", tenancy='" + tenancy + '\'' +
                ", depositType='" + depositType + '\'' +
                ", rentMoney=" + rentMoney +
                ", depositMoney=" + depositMoney +
                ", payRentMoney=" + payRentMoney +
                ", remark='" + remark + '\'' +
                ", costType=" + costType +
                ", costTypeInfo=" + costTypeInfo +
                ", contractState=" + contractState +
                ", refusalCause=" + refusalCause +
                ", isCurrentContract=" + isCurrentContract +
                ", appMeter=" + appMeter +
                ", appCheckInfo=" + appCheckInfo +
                '}';
    }
}
