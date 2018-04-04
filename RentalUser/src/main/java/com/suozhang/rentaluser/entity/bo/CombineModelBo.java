/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/6/13 9:52
 */
public class CombineModelBo implements BaseEntity{


    /**
     * Id : 71616263-a4aa-4b7e-a960-26678034d864
     * CreateTime : 2017-05-19T16:08:24
     * DevicePosition : 00B60001
     * GroupId : 00
     * PhysicalAddr : null
     * DeviceCode : 0034
     * Name : 电视
     * DeviceModel_Id : f7e1b5d0-62ef-412a-b593-bf3f36a0fd0f
     * DeviceModelName : DF_LT_C_01
     * Manufacturer_Id : d8c4cb4f-1aed-4ab8-9df0-077451144450
     * ManufacturerName : 默认厂家
     * DeviceType : 3
     * DeviceSubType : 1
     * CommunicateType : 1
     * DeviceVersion : null
     * RoomId : cbaea0df-2637-4b8a-b3a5-7ca7282f7570
     * RoomAddrCode : 01010102
     * OrgId : adcbb3e7-a309-4d31-ab68-fafe4582f201
     */

    private String Id;
    private String CreateTime;
    private String DevicePosition;
    private String GroupId;
    private String PhysicalAddr;
    private String DeviceCode;
    private String Name;
    private String DeviceModel_Id;
    private String DeviceModelName;
    private String Manufacturer_Id;
    private String ManufacturerName;
    private int DeviceType;
    private int DeviceSubType;
    private int CommunicateType;
    private String DeviceVersion;
    private String RoomId;
    private String RoomAddrCode;
    private String OrgId;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getDevicePosition() {
        return DevicePosition;
    }

    public void setDevicePosition(String DevicePosition) {
        this.DevicePosition = DevicePosition;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String GroupId) {
        this.GroupId = GroupId;
    }

    public String getPhysicalAddr() {
        return PhysicalAddr;
    }

    public void setPhysicalAddr(String PhysicalAddr) {
        this.PhysicalAddr = PhysicalAddr;
    }

    public String getDeviceCode() {
        return DeviceCode;
    }

    public void setDeviceCode(String DeviceCode) {
        this.DeviceCode = DeviceCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDeviceModel_Id() {
        return DeviceModel_Id;
    }

    public void setDeviceModel_Id(String DeviceModel_Id) {
        this.DeviceModel_Id = DeviceModel_Id;
    }

    public String getDeviceModelName() {
        return DeviceModelName;
    }

    public void setDeviceModelName(String DeviceModelName) {
        this.DeviceModelName = DeviceModelName;
    }

    public String getManufacturer_Id() {
        return Manufacturer_Id;
    }

    public void setManufacturer_Id(String Manufacturer_Id) {
        this.Manufacturer_Id = Manufacturer_Id;
    }

    public String getManufacturerName() {
        return ManufacturerName;
    }

    public void setManufacturerName(String ManufacturerName) {
        this.ManufacturerName = ManufacturerName;
    }

    public int getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(int DeviceType) {
        this.DeviceType = DeviceType;
    }

    public int getDeviceSubType() {
        return DeviceSubType;
    }

    public void setDeviceSubType(int DeviceSubType) {
        this.DeviceSubType = DeviceSubType;
    }

    public int getCommunicateType() {
        return CommunicateType;
    }

    public void setCommunicateType(int CommunicateType) {
        this.CommunicateType = CommunicateType;
    }

    public String getDeviceVersion() {
        return DeviceVersion;
    }

    public void setDeviceVersion(String DeviceVersion) {
        this.DeviceVersion = DeviceVersion;
    }

    public String getRoomId() {
        return RoomId;
    }

    public void setRoomId(String RoomId) {
        this.RoomId = RoomId;
    }

    public String getRoomAddrCode() {
        return RoomAddrCode;
    }

    public void setRoomAddrCode(String RoomAddrCode) {
        this.RoomAddrCode = RoomAddrCode;
    }

    public String getOrgId() {
        return OrgId;
    }

    public void setOrgId(String OrgId) {
        this.OrgId = OrgId;
    }

    @Override
    public String toString() {
        return "CombineModelBo{" +
                "Id='" + Id + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", DevicePosition='" + DevicePosition + '\'' +
                ", GroupId='" + GroupId + '\'' +
                ", PhysicalAddr=" + PhysicalAddr +
                ", DeviceCode='" + DeviceCode + '\'' +
                ", Name='" + Name + '\'' +
                ", DeviceModel_Id='" + DeviceModel_Id + '\'' +
                ", DeviceModelName='" + DeviceModelName + '\'' +
                ", Manufacturer_Id='" + Manufacturer_Id + '\'' +
                ", ManufacturerName='" + ManufacturerName + '\'' +
                ", DeviceType=" + DeviceType +
                ", DeviceSubType=" + DeviceSubType +
                ", CommunicateType=" + CommunicateType +
                ", DeviceVersion=" + DeviceVersion +
                ", RoomId='" + RoomId + '\'' +
                ", RoomAddrCode='" + RoomAddrCode + '\'' +
                ", OrgId='" + OrgId + '\'' +
                '}';
    }
}
