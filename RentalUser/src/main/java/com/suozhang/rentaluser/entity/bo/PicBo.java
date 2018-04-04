package com.suozhang.rentaluser.entity.bo;

import com.alibaba.fastjson.annotation.JSONField;
import com.suozhang.framework.entity.bo.BaseEntity;

import java.io.File;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/10/10 15:51
 */

public class PicBo implements BaseEntity {
    private String id;//图片Id
    private String url;//图片地址

    //客户端业务逻辑字段
    @JSONField(serialize = false)
    private boolean isAddBtn;//是否为添加按钮

    @JSONField(serialize = false)
    private File file;//本地图片文件


    public PicBo() {
    }

    public PicBo(String url) {
        this.url = url;
    }

    public PicBo(File file) {
        this.file = file;
    }

    public PicBo(String id, String url) {
        this.id = id;
        this.url = url;
    }
    public PicBo(boolean isAddBtn) {
        this.isAddBtn = isAddBtn;
    }

    public PicBo(boolean isAddBtn, File file) {
        this.isAddBtn = isAddBtn;
        this.file = file;
    }



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

    public boolean isAddBtn() {
        return isAddBtn;
    }

    public void setAddBtn(boolean addBtn) {
        isAddBtn = addBtn;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "PicBo{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", isAddBtn=" + isAddBtn +
                ", file=" + file +
                '}';
    }
}