/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.contract;

import com.suozhang.framework.entity.bo.LoginRequest;
import com.suozhang.framework.entity.bo.TokenInfo;
import com.suozhang.framework.entity.bo.UserAccount;
import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.ThirdLoginBo;

import io.reactivex.Observable;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:06
 */
public interface LoginContract {

    interface Model {

        /**
         * 用户登录
         *
         * @param loginRequest 用户登录请求参数
         */

        Observable<TokenInfo> doUserLogin(LoginRequest<UserAccount> loginRequest);

        /**
         * 获取短信验证码
         */
        Observable<String> doGetAuthCode(String phone, int codeType);

        /**
         * 用动态登录
         *
         * @param loginRequest 用户登录请求参数
         */

        Observable<TokenInfo> doUserDynamicLogin(LoginRequest<UserAccount> loginRequest);


        /**
         * 通过openId判断用户是否存在
         */
        Observable<Boolean> doUserIsExistByOpenId(String openId);

        /**
         * 通过openId判断用户是否绑定了手机号
         */
        Observable<Boolean> doUserIsBindPhoneByOpenId(String openId);

        /**
         * 创建用户
         */
        Observable<String> doUserCreate(ThirdLoginBo thirdLoginBo);

    }

    interface View extends BaseView {

        void finishActivity();

        void showUserInfo();

        void showGetCodeSuccess(String msg);

        void showGetCodeError(String msg);

        void showLoginError(String msg);

        void showDynamicLoginSuccess(String msg);

        void showDynamicLoginError(String msg);

        void showUserIsExistSuccess(Boolean msg);

        void showUserIsExistError(String msg);

        void showUserIsBindPhoneSuccess(Boolean msg);

        void showUserIsBindPhoneError(String msg);

        void showCreateUserSuccess(String msg);

        void showCreateUserError(String msg);



    }


    interface Presenter extends BasePresenter {

        void initUserAccout();

        void login(String username, String password);

        void getAuthCode(String phone, int codeType);

        void userDynamicLogin(String phone, String code);



        void userIsExistByOpenId(String openId);


        void userIsBindPhoneByOpenId(String openId);

        void userCreate(ThirdLoginBo thirdLoginBo);

        void loginByWx(String openId, int type);


    }
}
