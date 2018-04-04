package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/22 9:11
 */
public class MyLifeBo implements BaseEntity {


    /**
     * checkInfoPepoleName : 盛晓华
     * roomName : 松鼠小区101
     * billStartDate : 2018-01-16 00:00:00
     * billEndDate : 2018-02-15 00:00:00
     * payAmount : 2300.0
     * payDateTime : null
     * payType : 0
     * billStatus : 0
     * refusalCause : null
     * isRentRoom : false
     * landloadPhone : 18271901023
     * isStayRentBill : false
     * appUserBillInfo : [{"costName":"租金","price":1000,"lastScale":0,"scale":0,"amount":1000,"unit":"元/月","id":null,"name":null,"createTime":"2018-01-18 09:09:40","version":null},{"costName":"物业费","price":1000,"lastScale":0,"scale":0,"amount":1000,"unit":"元/月","id":null,"name":null,"createTime":"2018-01-18 09:09:40","version":null},{"costName":"维修费用","price":100,"lastScale":0,"scale":0,"amount":100,"unit":"元/月","id":null,"name":null,"createTime":"2018-01-18 09:09:40","version":null},{"costName":"水费","price":20,"lastScale":30,"scale":40,"amount":200,"unit":"元/吨","id":null,"name":null,"createTime":"2018-01-18 09:09:40","version":null}]
     * id : c1a68e9f-ab69-416e-9436-984f19925e71
     * name : null
     * createTime : 2018-01-18 09:09:40
     * version : null
     */

    private String checkInfoPepoleName;
    private String roomName;
    private Date billStartDate;
    private Date billEndDate;
    private double payAmount;
    private Date payDateTime;
    private int payType;
    private int billStatus;
    private String refusalCause;
    private boolean isRentRoom;
    private String landloadPhone;
    private boolean isStayRentBill;
    private String id;
    private String name;
    private String createTime;
    private String version;
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

    public Date getBillStartDate() {
        return billStartDate;
    }

    public void setBillStartDate(Date billStartDate) {
        this.billStartDate = billStartDate;
    }

    public Date getBillEndDate() {
        return billEndDate;
    }

    public void setBillEndDate(Date billEndDate) {
        this.billEndDate = billEndDate;
    }

    public void setPayDateTime(Date payDateTime) {
        this.payDateTime = payDateTime;
    }

    public void setRefusalCause(String refusalCause) {
        this.refusalCause = refusalCause;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public Object getPayDateTime() {
        return payDateTime;
    }


    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }


    public boolean isIsRentRoom() {
        return isRentRoom;
    }

    public void setIsRentRoom(boolean isRentRoom) {
        this.isRentRoom = isRentRoom;
    }

    public String getLandloadPhone() {
        return landloadPhone;
    }

    public void setLandloadPhone(String landloadPhone) {
        this.landloadPhone = landloadPhone;
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



    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRefusalCause() {
        return refusalCause;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public List<AppUserBillInfoBo> getAppUserBillInfo() {
        return appUserBillInfo;
    }

    public void setAppUserBillInfo(List<AppUserBillInfoBo> appUserBillInfo) {
        this.appUserBillInfo = appUserBillInfo;
    }

    public static class AppUserBillInfoBo implements BaseEntity{
        /**
         * costName : 租金
         * price : 1000.0
         * lastScale : 0.0
         * scale : 0.0
         * amount : 1000.0
         * unit : 元/月
         * id : null
         * name : null
         * createTime : 2018-01-18 09:09:40
         * version : null
         */

        private String costName;
        private double price;
        private double lastScale;
        private double scale;
        private double amount;
        private String unit;
        private String id;
        private String name;
        private String createTime;
        private String version;

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

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
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

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
