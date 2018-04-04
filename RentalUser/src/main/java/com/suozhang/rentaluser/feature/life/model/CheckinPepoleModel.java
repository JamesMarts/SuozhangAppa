package com.suozhang.rentaluser.feature.life.model;

import com.alibaba.fastjson.JSON;
import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.entity.bo.PicBo;
import com.suozhang.rentaluser.entity.bo.TenantInfoBo;
import com.suozhang.rentaluser.feature.life.contract.CheckinPepoleContract;
import com.suozhang.rentaluser.feature.life.dependencies.checkinpepole.DaggerCheckinPepoleModelComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.LifeApi;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/16 17:25
 */

public class CheckinPepoleModel implements CheckinPepoleContract.Model {

    @Inject
    LifeApi api;

    public CheckinPepoleModel() {
        DaggerCheckinPepoleModelComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }

    @Override
    public Observable<List<TenantInfoBo>> doQueryCheckinPepoleInfos(String contractId) {
        return api.getCheckInfos(contractId).compose(RxDataProcessFactory.<List<TenantInfoBo>>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<TenantInfoBo> doQueryCheckinPepoleInfoByPhone(String phone) {
        return api.getCheckInfoByPhone(phone).compose(RxDataProcessFactory.<TenantInfoBo>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doAddCheckinPepole(String contractId, TenantInfoBo info) {
        return api.addCheckInfo(contractId, body(info)).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doUpdateCheckinPepole(String checkinPepoleId, TenantInfoBo info) {
        return api.updateCheckInfo(checkinPepoleId, body(info)).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    @Override
    public Observable<String> doAffirmCheckinPepole(String checkinPepoleId) {
        return api.updateIsAffirmState(checkinPepoleId).compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer());
    }

    private MultipartBody body(TenantInfoBo data) {
        Logger.d("原始图文数据：" + data);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        //多表单提交
        builder.setType(MultipartBody.FORM);
        //基本信息
        String info = String.valueOf(JSON.toJSONString(data));
        builder.addFormDataPart("info", info);

        //身份证图片
        List<PicBo> idcards = data.getCardImagePic();
        addFormDataPart(builder, idcards, "cardImage");


        return builder.build();
    }

    private void addFormDataPart(MultipartBody.Builder builder, List<PicBo> pics, String key) {
        if (pics != null && !pics.isEmpty()) {
            for (int i = 0; i < pics.size(); i++) {
                PicBo pic = pics.get(i);
                if (pic == null) {
                    continue;
                }
                File file = pic.getFile();
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/otcet-stream"), file);
                builder.addFormDataPart(key + "[" + i + "]", file.getName(), fileBody);
            }
        }
    }
}

