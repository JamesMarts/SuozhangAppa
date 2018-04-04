/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.user.dependencies;


import com.suozhang.framework.framework.annotation.ModelScope;
import com.suozhang.rentaluser.feature.user.view.FeedbackActivity;
import com.suozhang.rentaluser.framework.api.dependencies.ApiComponent;

import dagger.Component;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/17 11:58
 */
@ModelScope
@Component(dependencies = ApiComponent.class)
public interface UserCenterCommonApiComponent {

    void inject(FeedbackActivity target);




}
