package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/25 10:56
 */
public class MyRoomBo implements BaseEntity{


    /**
     * name : sample string 1
     * roomTypeName : sample string 2
     * rentType : true
     * acreage : 4.1
     * floor : 5
     * introduction : sample string 6
     * description : sample string 7
     * address : sample string 8
     * roomImage : [{"id":"sample string 1","url":"sample string 2","isCommon":"sample string 3"},{"id":"sample string 1","url":"sample string 2","isCommon":"sample string 3"}]
     * roomImagePic : {"id":"sample string 1","url":"sample string 2","isCommon":"sample string 3"}
     * lifeRoomImage : sample string 9
     * area : sample string 10
     * areaId : sample string 11
     * rentMoney : 12.0
     * feature : sample string 13
     * orientationName : sample string 14
     * houseCount : 15
     * longitude : 16.0
     * latitude : 17.0
     * isCollection : true
     * roomConfig : [{"configId":"sample string 1","roomId":"sample string 2","isDic":true,"icon":"sample string 4","id":"sample string 5","name":"sample string 6","createTime":"2017-12-25 10:42:00","version":1},{"configId":"sample string 1","roomId":"sample string 2","isDic":true,"icon":"sample string 4","id":"sample string 5","name":"sample string 6","createTime":"2017-12-25 10:42:00","version":1}]
     * id : sample string 19
     * createTime : 2017-12-25 10:42:00
     * version : 1
     */

    private String name;
    private String roomTypeName;
    private boolean rentType;
    private double acreage;
    private int floor;
    private String introduction;
    private String description;
    private String address;
    private RoomImagePicBo roomImagePic;
    private String lifeRoomImage;
    private String area;
    private String areaId;
    private double rentMoney;
    private String feature;
    private String orientationName;
    private int houseCount;
    private double longitude;
    private double latitude;
    private boolean isCollection;
    private String id;
    private String createTime;
    private int version;

    private String recordId;
    private List<RoomImageBo> roomImage;
    private List<RoomConfigBo> roomConfig;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public boolean isRentType() {
        return rentType;
    }

    public void setRentType(boolean rentType) {
        this.rentType = rentType;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoomImagePicBo getRoomImagePic() {
        return roomImagePic;
    }

    public void setRoomImagePic(RoomImagePicBo roomImagePic) {
        this.roomImagePic = roomImagePic;
    }

    public String getLifeRoomImage() {
        return lifeRoomImage;
    }

    public void setLifeRoomImage(String lifeRoomImage) {
        this.lifeRoomImage = lifeRoomImage;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public double getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(double rentMoney) {
        this.rentMoney = rentMoney;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getOrientationName() {
        return orientationName;
    }

    public void setOrientationName(String orientationName) {
        this.orientationName = orientationName;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

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

    public boolean isIsCollection() {
        return isCollection;
    }

    public void setIsCollection(boolean isCollection) {
        this.isCollection = isCollection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<RoomImageBo> getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(List<RoomImageBo> roomImage) {
        this.roomImage = roomImage;
    }

    public List<RoomConfigBo> getRoomConfig() {
        return roomConfig;
    }

    public void setRoomConfig(List<RoomConfigBo> roomConfig) {
        this.roomConfig = roomConfig;
    }

    public static class RoomImagePicBo implements BaseEntity{
        /**
         * id : sample string 1
         * url : sample string 2
         * isCommon : sample string 3
         */

        private String id;
        private String url;
        private String isCommon;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIsCommon() {
            return isCommon;
        }

        public void setIsCommon(String isCommon) {
            this.isCommon = isCommon;
        }
    }

    public static class RoomImageBo implements BaseEntity{
        /**
         * id : sample string 1
         * url : sample string 2
         * isCommon : sample string 3
         */

        private String id;
        private String url;
        private String isCommon;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIsCommon() {
            return isCommon;
        }

        public void setIsCommon(String isCommon) {
            this.isCommon = isCommon;
        }
    }


}
