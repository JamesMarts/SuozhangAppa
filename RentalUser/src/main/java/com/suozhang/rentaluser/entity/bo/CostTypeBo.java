package com.suozhang.rentaluser.entity.bo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/13 11:05
 */

public class CostTypeBo extends BaseBo {
    /**
     * isOther : false
     * typeId : 14e083c1-bc3e-436e-8f45-b2f09cfd072a
     * price : 3
     * unit : 吨
     * id : 24725415-3793-4f6a-b3d4-a41d38944dcc
     * name : 水费
     */

    /**
     * 图标
     */
    private String icon;
    /**
     * 费用详情
     */
    private List<CostTypeBo> costTypeInfo;


    /**
     * 费用所属类型Id
     */
    private String typeId;
    /**
     * 价格
     */
    private double price;
    /**
     * 单位
     */
    private String unit;
    /**
     * 是否其他费用
     */
    @JSONField(name = "isOther")
    private boolean isOther;

    /**
     * 费用类型所对应的表类型Id
     */
    private String meterId;


    public CostTypeBo() {
    }

    public CostTypeBo(String id, String name) {
        super(id, name);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<CostTypeBo> getCostTypeInfo() {
        return costTypeInfo;
    }

    public void setCostTypeInfo(List<CostTypeBo> costTypeInfo) {
        this.costTypeInfo = costTypeInfo;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isOther() {
        return isOther;
    }

    public void setOther(boolean other) {
        isOther = other;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    @Override
    public String toString() {
        return "CostTypeBo{" +
                "icon='" + icon + '\'' +
                ", costTypeInfo=" + costTypeInfo +
                ", typeId='" + typeId + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", isOther=" + isOther +
                ", meterId='" + meterId + '\'' +
                "} " + super.toString();
    }
}
