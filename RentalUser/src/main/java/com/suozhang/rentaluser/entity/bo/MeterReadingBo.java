package com.suozhang.rentaluser.entity.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/29 13:59
 */

public class MeterReadingBo implements BaseEntity {

    /**
     * roomId : sample string 1
     * scale : 2
     * meterDate : sample string 3
     * meterType : sample string 4
     * typeName : sample string 5
     * lastDate : sample string 6
     * lastScale : sample string 7
     * id : sample string 8
     * name : sample string 9
     * createTime : 2017-11-28 09:39:49
     * version : 1
     */

    /**
     * id
     */
    private String id;
    /**
     * 房间id
     */
    private String roomId;
    /**
     * 当前刻度/本次刻度
     */
    private double scale;
    /**
     * 本次抄表日期
     */
    private String meterDateTime;
    /**
     * 表类型Id
     */
    private String meterType;
    /**
     * 表名称
     */
    private String typeName;
    /**
     * 上次抄表日期
     */
    private String lastDateTime;
    /**
     * 上次抄表刻度
     */
    private double lastScale;
    /**
     * 名称
     */
    private String name;

    /**
     * 存放输入之前的值，用于比对
     */
    @JSONField(serialize = false)
    private double tempValue;

    public MeterReadingBo() {

    }

    public MeterReadingBo(String roomId, double scale) {
        this.roomId = roomId;
        this.scale = scale;
    }

    public MeterReadingBo(String meterType, String typeName, double scale) {
        this.meterType = meterType;
        this.typeName = typeName;
        this.scale = scale;
    }

    public MeterReadingBo(String roomId, String name, double scale, double lastScale) {
        this.roomId = roomId;
        this.name = name;
        this.scale = scale;
        this.lastScale = lastScale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getMeterDateTime() {
        return meterDateTime;
    }

    public void setMeterDateTime(String meterDateTime) {
        this.meterDateTime = meterDateTime;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLastDateTime() {
        return lastDateTime;
    }

    public void setLastDateTime(String lastDateTime) {
        this.lastDateTime = lastDateTime;
    }

    public double getLastScale() {
        return lastScale;
    }

    public void setLastScale(double lastScale) {
        this.lastScale = lastScale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTempValue() {
        return tempValue;
    }

    public void setTempValue(double tempValue) {
        this.tempValue = tempValue;
    }

    @Override
    public String toString() {
        return "MeterReadingBo{" +
                "id='" + id + '\'' +
                "roomId='" + roomId + '\'' +
                ", scale=" + scale +
                ", meterDateTime=" + meterDateTime +
                ", meterType='" + meterType + '\'' +
                ", typeName='" + typeName + '\'' +
                ", lastDateTime='" + lastDateTime + '\'' +
                ", lastScale='" + lastScale + '\'' +
                ", name='" + name + '\'' +
                ", tempValue='" + tempValue + '\'' +
                '}';
    }
}
