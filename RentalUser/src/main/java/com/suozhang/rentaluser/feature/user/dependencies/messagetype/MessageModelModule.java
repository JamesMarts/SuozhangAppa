/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies.messagetype;


import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.model.MessageModel;

import dagger.Module;
import dagger.Provides;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/11 9:46
 */
@Module
public class MessageModelModule {

    @Provides

    public MessageContract.Model provideMessageModel() {
        return new MessageModel();
    }
}
