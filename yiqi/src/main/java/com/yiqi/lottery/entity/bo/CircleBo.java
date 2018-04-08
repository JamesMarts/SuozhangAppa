package com.yiqi.lottery.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

import java.util.List;

public class CircleBo implements BaseEntity{
    private String date;
    private String name;
    private String content;
    private boolean isLike;
    private Integer likeConut;
    private List<String> imgs;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public Integer getLikeConut() {
        return likeConut;
    }

    public void setLikeConut(Integer likeConut) {
        this.likeConut = likeConut;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "CircleBo{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", isLike=" + isLike +
                ", likeConut=" + likeConut +
                ", imgs=" + imgs +
                '}';
    }
}
