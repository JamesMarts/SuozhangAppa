/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.yiqi.lottery.framework.api;

import com.suozhang.framework.entity.bo.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/21 14:00
 */

public interface UserApi {


    /**
     * 获取未读消息数量
     * */
    @GET("Api/Message/v1/GetUnreadMessageCount")
    Observable<Result<Integer>> GetUnreadMessageCount();


    /**
     * 获取未读消息数量
     * */
    @POST("Api/Message/v1/UpdateMessageState/{MessageId}")
    Observable<Result<Boolean>> UpdateMessageState(@Path("MessageId") String MessageId);


}
