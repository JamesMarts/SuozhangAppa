package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/20 15:44
 */
public class ContractInfoBo implements BaseEntity {

    /**
     * roomId : null
     * roomName : null
     * housingResourceName : 哈哈哈哈哈哈哈1
     * rentType : false
     * startDate : 2017-12-06 00:00:00
     * endDate : 2018-01-05 00:00:00
     * tenancy : 0
     * depositType : null
     * depositTypeName : 押一付一
     * rentMoney : 100
     * payRentMoney : 100
     * depositMoney : 100
     * costType : null
     * landlordId : null
     * remark :
     * contractState : 1
     * refusalCause : null
     * isCurrentContract : false
     * costTypeInfo : []
     * appCheckInfo : {"checkInfoPepoleName":"黄丽","phone":null,"sex":true,"cardNumber":"421081199306242538","userId":null,"remark":null,"isAffirm":false,"recordId":null,"checkInfoPepoleType":0,"stringCardImageUrl":null,"listCardImageUrl":null,"contractState":0,"id":null,"name":null,"createTime":"2018-01-16 17:42:52","version":null}
     * appMeter : [{"roomId":null,"roomStatus":3,"billId":null,"scale":0,"meterDateTime":"2018-01-16 17:42:52","meterType":"552ec26f-9550-4110-bf86-b61a472cb010","typeName":"电表","lastDateTime":null,"lastScale":0,"id":null,"name":null,"createTime":"2018-01-16 17:42:52","version":null},{"roomId":null,"roomStatus":3,"billId":null,"scale":0,"meterDateTime":"2018-01-16 17:42:52","meterType":"c5db90a2-baaf-4be9-bc3d-3d6f0c732a79","typeName":"水表","lastDateTime":null,"lastScale":0,"id":null,"name":null,"createTime":"2018-01-16 17:42:52","version":null},{"roomId":null,"roomStatus":3,"billId":null,"scale":0,"meterDateTime":"2018-01-16 17:42:52","meterType":"e05eee26-463a-4314-939c-b90c78b1c2e3","typeName":"燃气表","lastDateTime":null,"lastScale":0,"id":null,"name":null,"createTime":"2018-01-16 17:42:52","version":null}]
     * appRentalLandlordView : {"orgId":null,"userId":null,"payPassword":null,"phone":"13691994354","sex":true,"code":null,"operationPwdType":0,"idCard":null,"oldPayPassword":null,"id":null,"name":"董平","createTime":"2018-01-16 17:42:52","version":null}
     * id : 2cd20254-dd8b-42ec-930f-228bf33099e7
     * name : null
     * createTime : 2018-01-16 17:42:52
     * version : null
     */

    private Object roomId;
    private Object roomName;
    private String housingResourceName;
    private boolean rentType;
    private Date startDate;
    private Date endDate;
    private int tenancy;
    private Object depositType;
    private String depositTypeName;
    private int rentMoney;
    private int payRentMoney;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int depositMoney;
    private Object costType;
    private Object landlordId;
    private String remark;
    private int contractState;
    private Object refusalCause;
    private boolean isCurrentContract;
    private AppCheckInfoBo appCheckInfo;
    private AppRentalLandlordViewBo appRentalLandlordView;
    private String id;
    private Object name;
    private Date createTime;
    private Object version;
    private List<CostTypeInfoBo> costTypeInfo;
    private List<AppMeterBo> appMeter;

    public Object getRoomId() {
        return roomId;
    }

    public void setRoomId(Object roomId) {
        this.roomId = roomId;
    }

    public Object getRoomName() {
        return roomName;
    }

    public void setRoomName(Object roomName) {
        this.roomName = roomName;
    }

    public String getHousingResourceName() {
        return housingResourceName;
    }

    public void setHousingResourceName(String housingResourceName) {
        this.housingResourceName = housingResourceName;
    }

    public boolean isRentType() {
        return rentType;
    }

    public void setRentType(boolean rentType) {
        this.rentType = rentType;
    }



    public int getTenancy() {
        return tenancy;
    }

    public void setTenancy(int tenancy) {
        this.tenancy = tenancy;
    }

    public Object getDepositType() {
        return depositType;
    }

    public void setDepositType(Object depositType) {
        this.depositType = depositType;
    }

    public String getDepositTypeName() {
        return depositTypeName;
    }

    public void setDepositTypeName(String depositTypeName) {
        this.depositTypeName = depositTypeName;
    }

    public int getRentMoney() {
        return rentMoney;
    }

    public void setRentMoney(int rentMoney) {
        this.rentMoney = rentMoney;
    }

    public int getPayRentMoney() {
        return payRentMoney;
    }

    public void setPayRentMoney(int payRentMoney) {
        this.payRentMoney = payRentMoney;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Object getCostType() {
        return costType;
    }

    public void setCostType(Object costType) {
        this.costType = costType;
    }

    public Object getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Object landlordId) {
        this.landlordId = landlordId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getContractState() {
        return contractState;
    }

    public void setContractState(int contractState) {
        this.contractState = contractState;
    }

    public Object getRefusalCause() {
        return refusalCause;
    }

    public void setRefusalCause(Object refusalCause) {
        this.refusalCause = refusalCause;
    }

    public boolean isIsCurrentContract() {
        return isCurrentContract;
    }

    public void setIsCurrentContract(boolean isCurrentContract) {
        this.isCurrentContract = isCurrentContract;
    }

    public AppCheckInfoBo getAppCheckInfo() {
        return appCheckInfo;
    }

    public void setAppCheckInfo(AppCheckInfoBo appCheckInfo) {
        this.appCheckInfo = appCheckInfo;
    }

    public AppRentalLandlordViewBo getAppRentalLandlordView() {
        return appRentalLandlordView;
    }

    public void setAppRentalLandlordView(AppRentalLandlordViewBo appRentalLandlordView) {
        this.appRentalLandlordView = appRentalLandlordView;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }



    public Object getVersion() {
        return version;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public List<CostTypeInfoBo> getCostTypeInfo() {
        return costTypeInfo;
    }

    public void setCostTypeInfo(List<CostTypeInfoBo> costTypeInfo) {
        this.costTypeInfo = costTypeInfo;
    }

    public List<AppMeterBo> getAppMeter() {
        return appMeter;
    }

    public void setAppMeter(List<AppMeterBo> appMeter) {
        this.appMeter = appMeter;
    }
    public static class CostTypeInfoBo implements BaseEntity{
        /**
         * isOther : false
         * typeId : d7b5c097-f401-4507-b0af-2b5edbfb5b3f
         * price : 7.0
         * unit : 吨
         * meterId : null
         * id : null
         * name : 水费
         * createTime : 2017-12-20 17:13:29
         * version : null
         */

        private boolean isOther;
        private String typeId;
        private double price;
        private String unit;
        private Object meterId;
        private Object id;
        private String name;
        private String createTime;
        private Object version;

        public boolean isIsOther() {
            return isOther;
        }

        public void setIsOther(boolean isOther) {
            this.isOther = isOther;
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

        public Object getMeterId() {
            return meterId;
        }

        public void setMeterId(Object meterId) {
            this.meterId = meterId;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
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

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }
    }

    public static class AppCheckInfoBo implements BaseEntity{
        /**
         * checkInfoPepoleName : 黄丽
         * phone : null
         * sex : true
         * cardNumber : 421081199306242538
         * userId : null
         * remark : null
         * isAffirm : false
         * recordId : null
         * checkInfoPepoleType : 0
         * stringCardImageUrl : null
         * listCardImageUrl : null
         * contractState : 0
         * id : null
         * name : null
         * createTime : 2018-01-16 17:42:52
         * version : null
         */

        private String checkInfoPepoleName;
        private Object phone;
        private boolean sex;
        private String cardNumber;
        private Object userId;
        private Object remark;
        private boolean isAffirm;
        private Object recordId;
        private int checkInfoPepoleType;
        private Object stringCardImageUrl;
        private Object listCardImageUrl;
        private int contractState;
        private Object id;
        private Object name;
        private String createTime;
        private Object version;

        public String getCheckInfoPepoleName() {
            return checkInfoPepoleName;
        }

        public void setCheckInfoPepoleName(String checkInfoPepoleName) {
            this.checkInfoPepoleName = checkInfoPepoleName;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public boolean isIsAffirm() {
            return isAffirm;
        }

        public void setIsAffirm(boolean isAffirm) {
            this.isAffirm = isAffirm;
        }

        public Object getRecordId() {
            return recordId;
        }

        public void setRecordId(Object recordId) {
            this.recordId = recordId;
        }

        public int getCheckInfoPepoleType() {
            return checkInfoPepoleType;
        }

        public void setCheckInfoPepoleType(int checkInfoPepoleType) {
            this.checkInfoPepoleType = checkInfoPepoleType;
        }

        public Object getStringCardImageUrl() {
            return stringCardImageUrl;
        }

        public void setStringCardImageUrl(Object stringCardImageUrl) {
            this.stringCardImageUrl = stringCardImageUrl;
        }

        public Object getListCardImageUrl() {
            return listCardImageUrl;
        }

        public void setListCardImageUrl(Object listCardImageUrl) {
            this.listCardImageUrl = listCardImageUrl;
        }

        public int getContractState() {
            return contractState;
        }

        public void setContractState(int contractState) {
            this.contractState = contractState;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }
    }

    public static class AppRentalLandlordViewBo implements BaseEntity{
        /**
         * orgId : null
         * userId : null
         * payPassword : null
         * phone : 13691994354
         * sex : true
         * code : null
         * operationPwdType : 0
         * idCard : null
         * oldPayPassword : null
         * id : null
         * name : 董平
         * createTime : 2018-01-16 17:42:52
         * version : null
         */

        private Object orgId;
        private Object userId;
        private Object payPassword;
        private String phone;
        private boolean sex;
        private Object code;
        private int operationPwdType;
        private Object idCard;
        private Object oldPayPassword;
        private Object id;
        private String name;
        private String createTime;
        private Object version;

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Object getPayPassword() {
            return payPassword;
        }

        public void setPayPassword(Object payPassword) {
            this.payPassword = payPassword;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public int getOperationPwdType() {
            return operationPwdType;
        }

        public void setOperationPwdType(int operationPwdType) {
            this.operationPwdType = operationPwdType;
        }

        public Object getIdCard() {
            return idCard;
        }

        public void setIdCard(Object idCard) {
            this.idCard = idCard;
        }

        public Object getOldPayPassword() {
            return oldPayPassword;
        }

        public void setOldPayPassword(Object oldPayPassword) {
            this.oldPayPassword = oldPayPassword;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
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

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }
    }

    public static class AppMeterBo implements BaseEntity{
        /**
         * roomId : null
         * roomStatus : 3
         * billId : null
         * scale : 0
         * meterDateTime : 2018-01-16 17:42:52
         * meterType : 552ec26f-9550-4110-bf86-b61a472cb010
         * typeName : 电表
         * lastDateTime : null
         * lastScale : 0
         * id : null
         * name : null
         * createTime : 2018-01-16 17:42:52
         * version : null
         */

        private Object roomId;
        private int roomStatus;
        private Object billId;
        private int scale;
        private String meterDateTime;
        private String meterType;
        private String typeName;
        private Object lastDateTime;
        private int lastScale;
        private Object id;
        private Object name;
        private String createTime;
        private Object version;

        public Object getRoomId() {
            return roomId;
        }

        public void setRoomId(Object roomId) {
            this.roomId = roomId;
        }

        public int getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(int roomStatus) {
            this.roomStatus = roomStatus;
        }

        public Object getBillId() {
            return billId;
        }

        public void setBillId(Object billId) {
            this.billId = billId;
        }

        public int getScale() {
            return scale;
        }

        public void setScale(int scale) {
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

        public Object getLastDateTime() {
            return lastDateTime;
        }

        public void setLastDateTime(Object lastDateTime) {
            this.lastDateTime = lastDateTime;
        }

        public int getLastScale() {
            return lastScale;
        }

        public void setLastScale(int lastScale) {
            this.lastScale = lastScale;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }
    }
}
