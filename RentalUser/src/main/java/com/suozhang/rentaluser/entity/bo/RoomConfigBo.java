package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/25 11:30
 */
public class RoomConfigBo implements BaseEntity {

    /**
     * configId : sample string 1
     * roomId : sample string 2
     * isDic : true
     * icon : sample string 4
     * id : sample string 5
     * name : sample string 6
     * createTime : 2017-12-25 10:42:00
     * version : 1
     */

    private String configId;
    private String roomId;
    private boolean isDic;
    private String icon;
    private String id;
    private String name;
    private String createTime;
    private int version;

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public boolean isIsDic() {
        return isDic;
    }

    public void setIsDic(boolean isDic) {
        this.isDic = isDic;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
