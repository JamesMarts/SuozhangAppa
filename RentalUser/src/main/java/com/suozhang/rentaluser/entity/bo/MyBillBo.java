package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/21 16:40
 */
public class MyBillBo implements BaseEntity {


    /**
     * checkInfoPepoleName : sample string 1
     * roomName : sample string 2
     * billPeriod : sample string 3
     * payAmount : 4.0
     * billStatus : 1
     * refuseCause : sample string 5
     * isRentRoom : true
     * isStayRentBill : true
     * appUserBillInfo : [{"costName":"sample string 1","price":2,"lastScale":3,"scale":4,"amount":5,"id":"sample string 6","name":"sample string 7","createTime":"2017-12-21 16:37:19","version":1},{"costName":"sample string 1","price":2,"lastScale":3,"scale":4,"amount":5,"id":"sample string 6","name":"sample string 7","createTime":"2017-12-21 16:37:19","version":1}]
     * id : sample string 8
     * name : sample string 9
     * createTime : 2017-12-21 16:37:19
     * version : 1
     */

    private String checkInfoPepoleName;
    private String roomName;
    private String billPeriod;
    private double payAmount;
    private int billStatus;
    private String refuseCause;
    private boolean isRentRoom;
    private boolean isStayRentBill;
    private String id;
    private String name;
    private String createTime;
    private int version;
    private List<AppUserBillInfoBo> appUserBillInfo;

    public String getCheckInfoPepoleName() {
        return checkInfoPepoleName;
    }

    public void setCheckInfoPepoleName(String checkInfoPepoleName) {
        this.checkInfoPepoleName = checkInfoPepoleName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBillPeriod() {
        return billPeriod;
    }

    public void setBillPeriod(String billPeriod) {
        this.billPeriod = billPeriod;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public String getRefuseCause() {
        return refuseCause;
    }

    public void setRefuseCause(String refuseCause) {
        this.refuseCause = refuseCause;
    }

    public boolean isIsRentRoom() {
        return isRentRoom;
    }

    public void setIsRentRoom(boolean isRentRoom) {
        this.isRentRoom = isRentRoom;
    }

    public boolean isIsStayRentBill() {
        return isStayRentBill;
    }

    public void setIsStayRentBill(boolean isStayRentBill) {
        this.isStayRentBill = isStayRentBill;
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

    public List<AppUserBillInfoBo> getAppUserBillInfo() {
        return appUserBillInfo;
    }

    public void setAppUserBillInfo(List<AppUserBillInfoBo> appUserBillInfo) {
        this.appUserBillInfo = appUserBillInfo;
    }

    public static class AppUserBillInfoBo implements BaseEntity{
        /**
         * costName : sample string 1
         * price : 2.0
         * lastScale : 3.0
         * scale : 4.0
         * amount : 5.0
         * id : sample string 6
         * name : sample string 7
         * createTime : 2017-12-21 16:37:19
         * version : 1
         */

        private String costName;
        private double price;
        private double lastScale;
        private double scale;
        private double amount;
        private String id;
        private String name;
        private String createTime;
        private int version;

        public String getCostName() {
            return costName;
        }

        public void setCostName(String costName) {
            this.costName = costName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getLastScale() {
            return lastScale;
        }

        public void setLastScale(double lastScale) {
            this.lastScale = lastScale;
        }

        public double getScale() {
            return scale;
        }

        public void setScale(double scale) {
            this.scale = scale;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
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
    }
}
