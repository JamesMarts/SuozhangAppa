package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.RegisterBo;

import io.reactivex.Observable;

;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/18 14:14
 */

public interface ModifyPhoneContract {


    interface Model {
        /**
         * 发送验证码
         *
         * @param phone
         * @param codeType 0：登录，1：修改手机号，2：注册，3：重置密码
         * @return
         */
        Observable<String> doSendCode(String phone, int codeType);


        /**
         * 修改绑定手机号
         *
         * @param resetPassword
         * @return
         */
        Observable<String> doModifyPhone(RegisterBo resetPassword);
    }

    interface View extends BaseView {

        /**
         * 设置重新获取验证码是否可点击
         *
         * @param enabled
         */
        void setResendEnabled(boolean enabled);

        /**
         * 设置倒计时
         *
         * @param countdown
         */
        void setResendCountdown(String countdown);


        /**
         * 修改绑定手机成功
         */
        void finishUi();


    }

    interface Presenter extends BasePresenter {


        /**
         * 发送验证码
         *
         * @param phone
         */
        void sendCode(String phone);

        /**
         * 修改手机号
         *
         * @param oldPhone
         * @param newPhone
         * @param code
         */
        void modifyPhone(String oldPhone, String newPhone, String code);
    }
}
