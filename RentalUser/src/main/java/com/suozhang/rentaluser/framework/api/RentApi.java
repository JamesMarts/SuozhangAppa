package com.suozhang.rentaluser.framework.api;

import com.baiiu.filter.FilterBaseBo;
import com.suozhang.framework.entity.bo.Result;
import com.suozhang.rentaluser.entity.bo.BannerBo;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentInfoBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;
import com.suozhang.rentaluser.entity.bo.ReportBo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/10/26 17:13
 */
public interface RentApi {

    /**
     * 获取首页banner
     **/
    @GET("Api/Advertising/v1/GetAdvertising")
    Observable<Result<List<BannerBo>>> getBannerList();

    /**
     * 获取房间详情
     **/
    @GET("Api/HousingResource/v1/GetRoomAndHouseInfo")
    Observable<Result<RentInfoBo>> getHotelInfo(@Query("id") String id);

    /**
     * 根据城市名获取城市ID
     */

    @GET("Api/HousingResource/v1/GetAreaIdByName")
    Observable<Result<BaseBo>> getCityId(@Query("Name") String name);

    /**
     * 首页猜你喜欢
     */
    @GET("Api/HousingResource/v1/GetHouseingResourseByLike")
    Observable<Result<List<HouseRoomBo>>> getGuestLike(@Query("AreaId") String areaId);

    /**
     * 获取房源列表
     */
    @POST("Api/HousingResource/v1/GetHouseingResourseByFilter")
    Observable<Result<List<HouseRoomBo>>> getHouseResourseList(@Body RentParamsBo rentParamsBo);

    /**
     * 收藏房源
     */
    @POST("Api/CollectHouse/v1/AddCollectHouse")
    Observable<Result<String>> collectionHouse(@Query("id") String id);


    /**
     * 取消收藏房源
     */
    @POST("Api/CollectHouse/v1/CancelCollectHouse")
    Observable<Result<String>> cancleCollectionHouse(@Query("id") String id);

    /**
     * 获取举报房源类别
     */

    @GET("Api/Report/v1/GetReportType")
    Observable<Result<List<BaseBo>>> getReportType();

    /**
     * 举报房源
     * */

    @POST("Api/Report/v1/AddReport")
    Observable<Result<String>> addReport(@Body ReportBo reportBo);

    /**
     * 获取附近信息
     *
     * */

    @GET("Api/RoomScreening/v1/GetScreeningInfo")
    Observable<Result<List<FilterBaseBo>>> getNearList(@Query("AreaId") String AreaId);


    /**
     * 获取户型
     *
     * */

    @GET("Api/Room/v1/GetHouseType")
    Observable<Result<List<FilterBaseBo>>> getHouseType();

    /**
     * 获取朝向
     * */

    @GET("Api/Room/v1/GetOrientation")
    Observable<Result<List<FilterBaseBo>>> getOrientation();
}
