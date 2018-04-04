package com.suozhang.rentaluser.entity.bo;

import android.os.Parcel;
import android.os.Parcelable;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/25 14:41
 */
public class PaymentDetailBo implements BaseEntity {


    /**
     * checkInfoPepoleName : sample string 1
     * roomName : sample string 2
     * billPeriod : sample string 3
     * payAmount : 4.0
     * payDateTime : 2017-12-26 15:11:16
     * payType : 1
     * billStatus : 1
     * refusalCause : sample string 5
     * isRentRoom : true
     * landloadPhone : sample string 7
     * isStayRentBill : true
     * appUserBillInfo : [{"costName":"sample string 1","price":2,"lastScale":3,"scale":4,"amount":5,"id":"sample string 6","name":"sample string 7","createTime":"2017-12-26 15:11:17","version":1},{"costName":"sample string 1","price":2,"lastScale":3,"scale":4,"amount":5,"id":"sample string 6","name":"sample string 7","createTime":"2017-12-26 15:11:17","version":1}]
     * id : sample string 9
     * name : sample string 10
     * createTime : 2017-12-26 15:11:17
     * version : 1
     */

    private String checkInfoPepoleName;
    private String roomName;
    private String billPeriod;
    private double payAmount;
    private String payDateTime;
    private int payType;
    private int billStatus;
    private String refusalCause;
    private Date billStartDate;

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

    private Date billEndDate;
    private boolean isRentRoom;
    private String landloadPhone;
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

    public String getPayDateTime() {
        return payDateTime;
    }

    public void setPayDateTime(String payDateTime) {
        this.payDateTime = payDateTime;
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

    public String getRefusalCause() {
        return refusalCause;
    }

    public void setRefusalCause(String refusalCause) {
        this.refusalCause = refusalCause;
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

    public static class AppUserBillInfoBo implements BaseEntity, Parcelable {
        /**
         * costName : sample string 1
         * price : 2.0
         * lastScale : 3.0
         * scale : 4.0
         * amount : 5.0
         * id : sample string 6
         * name : sample string 7
         * createTime : 2017-12-26 15:11:17
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.costName);
            dest.writeDouble(this.price);
            dest.writeDouble(this.lastScale);
            dest.writeDouble(this.scale);
            dest.writeDouble(this.amount);
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeString(this.createTime);
            dest.writeInt(this.version);
        }

        public AppUserBillInfoBo() {
        }

        protected AppUserBillInfoBo(Parcel in) {
            this.costName = in.readString();
            this.price = in.readDouble();
            this.lastScale = in.readDouble();
            this.scale = in.readDouble();
            this.amount = in.readDouble();
            this.id = in.readString();
            this.name = in.readString();
            this.createTime = in.readString();
            this.version = in.readInt();
        }

        public static final Parcelable.Creator<AppUserBillInfoBo> CREATOR = new Parcelable.Creator<AppUserBillInfoBo>() {
            @Override
            public AppUserBillInfoBo createFromParcel(Parcel source) {
                return new AppUserBillInfoBo(source);
            }

            @Override
            public AppUserBillInfoBo[] newArray(int size) {
                return new AppUserBillInfoBo[size];
            }
        };
    }
}
