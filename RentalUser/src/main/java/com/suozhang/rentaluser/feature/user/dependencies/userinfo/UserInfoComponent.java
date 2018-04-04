/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.userinfo;


import com.suozhang.rentaluser.feature.user.view.UserInfoActivity;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = UserInfoPresenterModule.class)
public interface UserInfoComponent {
    void inject(UserInfoActivity userInfoActivity);
    //void injectUser(BookingActivity bookingActivity);
}
