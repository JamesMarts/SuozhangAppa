/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.framework.api;

import com.suozhang.framework.entity.bo.Result;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.MessageBo;
import com.suozhang.rentaluser.entity.bo.PasswordBo;
import com.suozhang.rentaluser.entity.bo.RegisterBo;
import com.suozhang.rentaluser.entity.bo.StringDateBo;
import com.suozhang.rentaluser.entity.bo.SuggestionBo;
import com.suozhang.rentaluser.entity.bo.ThirdLoginBo;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.entity.bo.ZMBo;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Moodd
 * @email 420410175@qq.com
 * @date 2017/4/21 14:00
 */

public interface UserApi {

    /**
     * 发送手机验证码
     *
     * @param codeType
     * @param phone
     */
    @GET("Api/SMS/v1/SendCode")
    Observable<Result<String>> getAuthCode(
            @Query("Phone") String phone,
            @Query("CodeType") int codeType
    );

    /**
     * 验证手机号
     *
     * @param phone 手机号
     */
    @GET("Api/Authorization/v1/CheckPhone/{phone}?")
    Observable<Result<String>> registerVerifyPhone(@Path("phone") String phone, @Query("codeType") int codeType);

    /**
     * 验证验证码
     *
     * @param phone 手机号
     */
    @GET("Api/User/v1/CheckSmsCode")
    Observable<Result<String>> registerVerifyCode(@Query("phone") String phone, @Query("Code") String code);


    /**
     * 用户注册
     */
    @POST("Api/Authorization/v1/Register")
    Observable<Result<String>> registerCommit(@Body RegisterBo registerBo);

    /**
     * 用户重置密码
     */
    @POST("Api/User/v1/ResetPwd")
    Observable<Result<String>> resetPasswordCommit(@Body RegisterBo registerBo);


    /**
     * 获取用户基本资料
     *
     * @param
     */

    @GET("Api/User/v1/UserCenter")
    Observable<Result<UserInfoBo>> getUserInfo();


    /**
     * 修改用户昵称
     */
    @POST("Api/User/v1/EditNickName")
    Observable<Result<String>> updateNickName(@Body UserInfoBo user);

    /**
     * @param user
     * @return
     */
    @POST("Api/User/v1/EditSex")
    Observable<Result<String>> updateSex(@Body UserInfoBo user);

    /**
     * 修改生日
     * <p>
     *
     * @param user
     * @return
     */
    @POST("Api/User/v1/EditBirthday")
    Observable<Result<String>> updateBirthday(@Body StringDateBo user);

    /**
     *
     * */
    @POST("Api/User/v1/EditSummary")
    Observable<Result<String>> updateSummary(@Body UserInfoBo user);

    /**
     * 修改邮箱
     * <p>
     *
     * @param user
     * @return
     */
    @POST("Api/User/v1/EditEmail")
    Observable<Result<String>> updateEmail(@Body UserInfoBo user);

    /**
     * 修改密码
     *
     * @param passwordBo
     * @return
     */
    @POST("Api/User/v1/EditPwd")
    Observable<Result<String>> updatePassword(@Body PasswordBo passwordBo);

    /**
     * 修改密码
     *
     * @param
     * @return
     */
    @POST("Api/User/v1/EditPhone")
    Observable<Result<String>> updatePhone(@Body PasswordBo passwordBo);

    /**
     * 修改密码
     *
     * @param
     * @return
     */
    @POST("Api/User/v1/EditPhone")
    Observable<Result<String>> editPhone(@Body RegisterBo passwordBo);

    /**
     * 上传头像
     */
    @Multipart
    @POST("Api/User/v1/UploadIcon")
    Observable<Result<String>> updateUserIcon(@Part("uploadImgType") RequestBody uploadImgType,
                                              @Part MultipartBody.Part file);

    /**
     * 判断openID是否存在
     */
    @GET("Api/Authorization/v1/CheckUserHasExist/{openId}")
    Observable<Result<Boolean>> loginCheckUserHasExist(@Path("openId") String openId);

    /**
     * 判断openID是否绑定了手机号
     */
    @GET("Api/Authorization/v1/CheckUseHasBindPhone/{openId}")
    Observable<Result<Boolean>> loginCheckUseHasBindPhone(@Path("openId") String openId);

    /**
     * 创建新的用户
     */
    @POST("Api/Authorization/v1/CreateWeChatUser")
    Observable<Result<String>> loginCreateWeChatUser(@Body ThirdLoginBo thirdLoginBo);

    /**
     * 创建新的用户绑定手机号
     */
    @POST("Api/User/v1/BindUser/{openId}")
    Observable<Result<String>> loginBindUser(@Path("openId") String openId, @Body RegisterBo registerBo);

    /**
     * 个人中心-意见反馈
     *
     * @param suggestion
     * @return
     */
    @POST("Api/Suggestion/v1/Add")
    Observable<Result<String>> suggestionSubmit(@Body SuggestionBo suggestion);

    /**
     * 个人中心-意见反馈
     *
     * @param suggestion
     * @return
     */
    @POST("Api/User/v1/EditConstellation")
    Observable<Result<String>> editConstellation(@Body BaseBo suggestion);


    @GET("Api/User/v1/GetZhiMaRedirectUrl")
    Observable<Result<String>> zmAuth(@Query("Idcard") String Idcard
            , @Query("Name") String Name);

    @GET("Api/CollectHouse/v1/CollectHouseList")
    Observable<Result<List<HouseRoomBo>>> getCollection();

    /**
     * 检查是否有认证过
     */
    @GET("Api/user/v1/CheckZhimaScore")
    Observable<Result<ZMBo>> checkZhimaScore();

    /**
     * 获取消息类型列表
     * */
    @GET("Api/Message/v1/GetMessageList")
    Observable<Result<List<MessageBo>>> getUserMessageTypeList();


    /**
     * 获取消息列表
     * */
    @GET("Api/Message/v1/GetMessageTypeList")
    Observable<Result<List<MessageBo>>> getMessageTypeList(@Query("Type") String MessageType);

    /**
     * 获取消息详情
     * */
    @GET("Api/Message/v1/GetMessageInfo/{MessageId} ")
    Observable<Result<MessageBo>> GetMessageInfo(@Path("MessageId") String messageTypeId);

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
