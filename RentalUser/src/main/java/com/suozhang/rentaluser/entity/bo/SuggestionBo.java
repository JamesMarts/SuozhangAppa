package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/14 16:16
 */

public class SuggestionBo implements BaseEntity {

    private String content;//意见反馈内容

    public SuggestionBo() {
    }

    public SuggestionBo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SuggestionBo{" +
                "content='" + content + '\'' +
                '}';
    }
}
