package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/28 15:52
 */
public class ReportBo implements BaseEntity {


    private String reportInfo;
    private String housingResourceId;
    private String description;

    public String getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(String reportInfo) {
        this.reportInfo = reportInfo;
    }

    public String getHousingResourceId() {
        return housingResourceId;
    }

    public void setHousingResourceId(String housingResourceId) {
        this.housingResourceId = housingResourceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ReportBo{" +
                "reportInfo='" + reportInfo + '\'' +
                ", housingResourceId='" + housingResourceId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public ReportBo(String reportInfo, String housingResourceId, String description) {
        this.reportInfo = reportInfo;
        this.housingResourceId = housingResourceId;
        this.description = description;
    }

    public ReportBo() {
    }
}
