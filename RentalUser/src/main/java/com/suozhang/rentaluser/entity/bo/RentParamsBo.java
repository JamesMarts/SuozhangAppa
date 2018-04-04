package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/27 10:45
 */
public class RentParamsBo implements BaseEntity {


    /**
     * longitude : 1.0
     * name : sample string 1
     * latitude : 1.0
     * distance : 1
     * administrativeName : sample string 2
     * areaId : sample string 3
     * minRentMoney : 1.0
     * maxRentMoney : 1.0
     * roomTypeId : sample string 4
     * rentType : true
     * orientationId : sample string 5
     * rentMoneyOrder : 1
     * acreageOrder : 1
     */

    private Double longitude;
    private String name;
    private Double latitude;
    private Integer distance;
    private String administrativeName;
    private String areaId;
    private Double minRentMoney;
    private Double maxRentMoney;
    private String roomTypeId;
    private Boolean rentType;
    private String orientationId;
    private Integer rentMoneyOrder;
    private Integer acreageOrder;

    private String quyuId;

    public String getQuyuId() {
        return quyuId;
    }

    public void setQuyuId(String quyuId) {
        this.quyuId = quyuId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getAdministrativeName() {
        return administrativeName;
    }

    public void setAdministrativeName(String administrativeName) {
        this.administrativeName = administrativeName;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Double getMinRentMoney() {
        return minRentMoney;
    }

    public void setMinRentMoney(Double minRentMoney) {
        this.minRentMoney = minRentMoney;
    }

    public Double getMaxRentMoney() {
        return maxRentMoney;
    }

    public void setMaxRentMoney(Double maxRentMoney) {
        this.maxRentMoney = maxRentMoney;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Boolean getRentType() {
        return rentType;
    }

    public void setRentType(Boolean rentType) {
        this.rentType = rentType;
    }

    public String getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(String orientationId) {
        this.orientationId = orientationId;
    }

    public Integer getRentMoneyOrder() {
        return rentMoneyOrder;
    }

    public void setRentMoneyOrder(Integer rentMoneyOrder) {
        this.rentMoneyOrder = rentMoneyOrder;
    }

    public Integer getAcreageOrder() {
        return acreageOrder;
    }

    public void setAcreageOrder(Integer acreageOrder) {
        this.acreageOrder = acreageOrder;
    }

    @Override
    public String toString() {
        return "RentParamsBo{" +
                "longitude=" + longitude +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", distance=" + distance +
                ", administrativeName='" + administrativeName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", minRentMoney=" + minRentMoney +
                ", maxRentMoney=" + maxRentMoney +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", rentType=" + rentType +
                ", orientationId='" + orientationId + '\'' +
                ", rentMoneyOrder=" + rentMoneyOrder +
                ", acreageOrder=" + acreageOrder +
                '}';
    }
}
