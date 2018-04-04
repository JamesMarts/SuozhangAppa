package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/20 15:44
 */
public class ContractInfoPramsBo implements BaseEntity {

    private String RefusalCause ;

    public String getRefusalCause() {
        return RefusalCause;
    }

    public void setRefusalCause(String refusalCause) {
        RefusalCause = refusalCause;
    }

    public ContractInfoPramsBo(String refusalCause) {
        RefusalCause = refusalCause;
    }

    public ContractInfoPramsBo() {
    }


    @Override
    public String toString() {
        return "ContractInfoPramsBo{" +
                "refusalCause='" + RefusalCause + '\'' +
                '}';
    }
}
