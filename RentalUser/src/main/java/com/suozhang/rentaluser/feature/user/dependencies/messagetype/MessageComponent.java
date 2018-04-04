/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.messagetype;


import com.suozhang.rentaluser.feature.user.view.MessageActivity;
import com.suozhang.rentaluser.feature.user.view.MessageInfoActivity;
import com.suozhang.rentaluser.feature.user.view.adapter.MessageViewActivity;

import dagger.Component;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:24
 */

@Component(modules = MessagePresenterModule.class)
public interface MessageComponent {
    void inject(MessageActivity messageActivity);

    void inject(MessageInfoActivity messageInfoActivity);
    void inject(MessageViewActivity messageInfoActivity);
}
