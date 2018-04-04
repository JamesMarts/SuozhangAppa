/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.contract;

import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.StringDateBo;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;

import java.io.File;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface UserInfoContract {

    interface Model {

        /**
         * 获取当前登录用户的常用联系人信息
         * String Search,
         @Query("PageIndex") int PageIndex,
         @Query("PageSize") int PageSize
         * @param
         */
        Observable<String> doUpdateUserIcon(int uploadImgType, File file);
        Observable<UserInfoBo> doUserInfo();
        Observable<String> doEditBirthday(StringDateBo stringDateBo);
        Observable<String> doEditGender(UserInfoBo nickName);
        Observable<String> doEditStar(BaseBo star);
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

        /**
         * 设置用户信息
         */

        void showEditBirthdaySuccess(String msg);

        /**
         * 显示错误信息
         */

        void showEditBirthdayErrorMsg(String msg);

        void showUploadSuccess(String msg);
        void showUploadError(String msg);
    }


    interface Presenter extends BasePresenter {

        /**
         * 修改用户头像
         *
         * @param uploadImgType 1头像 2背景图
         * @param file
         * @return
         */
        void updateUserIcon(int uploadImgType, File file);
        void getUserInfo();
        void editBirthday(String birthady);
        void doEditGender(boolean gender);
        void editStar(String star);
    }
}
