/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface UserCenterContract {

    interface Model {

        Observable<UserInfoBo> doUserInfo();
        Observable<Integer> doGetUnreadMessageCount();
    }

    interface View extends BaseView {
        /**
         * 关闭页面
         */
        void finishActivity();

        /**
         * 设置用户信息
         */

        void showUserInfo(UserInfoBo userInfoBo);

        /**
         * 显示错误信息
         */

        void showErrorMsg(String msg);
        void showMsgCount(Integer count);
        void showMsgCountError(String msg);
    }


    interface Presenter extends BasePresenter {


        void getUserInfo();
        void doGetUnreadMessageCount();
    }
}
