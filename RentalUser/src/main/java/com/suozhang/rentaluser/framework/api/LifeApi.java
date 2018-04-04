package com.suozhang.rentaluser.framework.api;

import com.suozhang.framework.entity.bo.Result;
import com.suozhang.rentaluser.entity.bo.AlipayBo;
import com.suozhang.rentaluser.entity.bo.ContractBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoBo;
import com.suozhang.rentaluser.entity.bo.ContractInfoPramsBo;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.entity.bo.MyRoomBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyBo;
import com.suozhang.rentaluser.entity.bo.PayNotifyRes;
import com.suozhang.rentaluser.entity.bo.PaymentDetailBo;
import com.suozhang.rentaluser.entity.bo.TenantInfoBo;
import com.suozhang.rentaluser.entity.bo.WXPayBo;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/20 11:20
 */
public interface LifeApi {

    /**
     * 获取我的合同列表
     **/
    @GET("Api/Contract/v1/MyContractList")
    Observable<Result<List<ContractBo>>> getContractList(@Query("IsCurrentContract") boolean isCurrentContract);

    /**
     * 获取我的合同列表
     **/
    @GET("Api/Contract/v1/MyContractInfo/{id}")
    Observable<Result<ContractInfoBo>> getContractInfo(@Path("id") String id);

    /**
     * 确认租约
     **/
    @POST("Api/Contract/v1/ConfirmContract/{id}")
    Observable<Result<String>> postConfirmContract(@Path("id") String id);

    /**
     * 拒绝租约
     **/
    @POST("Api/Contract/v1/RefauseContract/{id}")
    Observable<Result<String>> postCancleContract(@Path("id") String id, @Body ContractInfoPramsBo contractInfoBo);

    /**
     * 读取合同模板
     **/

    @GET("Api/Contract/v1/GetContrcTemplateInfo/{id}")
    Observable<Result<String>> getContrcTemplateInfo(@Path("id") String id);

    /**
     * 获取我的账单状态
     */

    @GET("Api/Bill/v1/MyBill")
    Observable<Result<MyLifeBo>> getMyBill();
    /**
     * 获取我的账单状态
     */

    @GET("Api/Bill/v1/GetMyBillInfo/{BillId}")
    Observable<Result<MyLifeBo>> getMyBillInfo(@Path("BillId")String BillId);

    @POST("Api/Bill/v1/RefauseMyBill/{BillId}")
    Observable<Result<String>> refauseMyBill(@Path("BillId")String BillId,@Body ContractInfoPramsBo contractInfoPramsBo);


    /**
     * 获取微信支付参数
     **/

    @GET("Api/Bill/v1/GetPayPara/{BillId}")
    Observable<Result<WXPayBo>> getWxPayInfo(@Path("BillId") String orderId, @Query("payType") int payType);

    /**
     * 获取支付宝参数
     **/

    @GET("Api/Bill/v1/GetPayPara/{BillId}")
    Observable<Result<AlipayBo>> getAliPayInfo(@Path("BillId") String orderId, @Query("payType") int payType);

    /**
             * 支付成功回调
             *
             * @param orderId     订单ID
             * @param payNotifyBo 回调参数
             */
    @POST("Api/Bill/V1/PayNotify/{BillId}")
    Observable<Result<PayNotifyRes>> sendPayNotify(@Path("BillId") String orderId, @Body PayNotifyBo payNotifyBo);

    /**
     * 获取我的房间信息
     */

    @GET("Api/Room/v1/MyRoom")
    Observable<Result<MyRoomBo>> getMyRoomInfo();

    /**
     * 获取入住人信息
     *
     * @param contractId
     * @return
     */
    @GET("Api/CheckInfo/v1/GetCheckInfos/{id}")
    Observable<Result<List<TenantInfoBo>>> getCheckInfos(@Path("id") String contractId);
    /**
     * 获取入住人信息--根据手机号获取
     *
     * @param phone
     * @return
     */
    @GET("Api/CheckInfo/v1/GetCheckInfoByPhone/{phone}")
    Observable<Result<TenantInfoBo>> getCheckInfoByPhone(@Path("phone") String phone);
    /**
     * 添加入住人信息
     *
     * @param contractId
     * @param info
     * @return
     */
    @POST("Api/CheckInfo/v1/AddCheckInfo/{id}")
    Observable<Result<String>> addCheckInfo(@Path("id") String contractId, @Body MultipartBody info);

    /**
     * 修改入住人信息
     *
     * @param checkinPepoleId 入住人Id
     * @param info
     * @return
     */
    @POST("Api/CheckInfo/v1/UpdateCheckInfo/{id}")
    Observable<Result<String>> updateCheckInfo(@Path("id") String checkinPepoleId, @Body MultipartBody info);

    /**
     * 确认入住人状态 ，房东确认
     *
     * @param checkinPepoleId
     * @return
     */
    @POST("Api/CheckInfo/v1/UpdateIsAffirmState/{id}")
    Observable<Result<String>> updateIsAffirmState(@Path("id") String checkinPepoleId);


    /**
     * 获取账单详列表
     * */

    @GET("Api/Bill/v1/GetPayMentList")
    Observable<Result<List<PaymentDetailBo>>> getPayMentList();


    /**
     * 获取未读消息数量
     * */
    @GET("Api/Message/v1/GetUnreadMessageCount")
    Observable<Result<Integer>> GetUnreadMessageCount();
}
