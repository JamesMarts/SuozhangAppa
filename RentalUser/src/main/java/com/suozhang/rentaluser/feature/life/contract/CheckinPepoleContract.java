package com.suozhang.rentaluser.feature.life.contract;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.framework.BasePresenter;
import com.suozhang.framework.framework.BaseView;
import com.suozhang.rentaluser.entity.bo.TenantInfoBo;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/13 10:52
 */

public interface CheckinPepoleContract {


    interface Model {
        /**
         * 获取入住人信息
         *
         * @return
         */
        Observable<List<TenantInfoBo>> doQueryCheckinPepoleInfos(String contractId);

        /**
         * 获取入住人信息-根据手机号
         *
         * @param phone
         * @return
         */
        Observable<TenantInfoBo> doQueryCheckinPepoleInfoByPhone(String phone);

        /**
         * 添加入住人
         *
         * @param contractId
         * @param info
         * @return
         */
        Observable<String> doAddCheckinPepole(String contractId, TenantInfoBo info);

        /**
         * 修改入住人信息
         *
         * @param checkinPepoleId
         * @param info
         * @return
         */
        Observable<String> doUpdateCheckinPepole(String checkinPepoleId, TenantInfoBo info);

        /**
         * 确认入住人
         *
         * @param checkinPepoleId
         * @return
         */
        Observable<String> doAffirmCheckinPepole(String checkinPepoleId);


    }

    interface Presenter extends BasePresenter {

        /**
         * 选择或者预览照片
         *
         * @param adapter
         * @param position
         * @param requestCode
         */
        void selectOrPreviewPic(BaseQuickAdapter adapter, int position, int requestCode, int maxPic);

        /**
         * 添加照片
         *
         * @param adapter
         * @param data
         * @param maxPic
         */
        void addPic(BaseQuickAdapter adapter, Intent data, int maxPic);

        /**
         * 删除照片
         *
         * @param adapter
         * @param position
         */
        void deletePic(BaseQuickAdapter adapter, int position);

        /**
         * 获取入住人信息
         *
         * @param contractId
         */
        void queryCheckinPepoleInfos(String contractId);

        /**
         * 获取入住人信息-根据手机号
         *
         * @param phone
         */
        void queryCheckinPepoleInfoByPhone(String phone);

        /**
         * 根据位置查询入住人信息
         *
         * @param position
         */
        void queryCheckinPepoleInfoByPosition(int position);

        /**
         * 检查参数并更新数据
         *
         * @param result
         */
        void checkParamsAndUpdate(TenantInfoBo result);

        /**
         * 确认入住人
         *
         * @param contractId
         * @param checkinPepoleId
         * @return
         */
        void affirmCheckinPepole(String contractId, String checkinPepoleId);

        /**
         * 添加或更新入住人
         *
         * @param isAdd
         * @param isTenant
         * @param contractId
         * @param checkinPepoleId
         * @param info
         */
        void addOrUpdateCheckinPepole(boolean isAdd, boolean isTenant, String contractId, String checkinPepoleId, TenantInfoBo info);

    }

    interface View extends BaseView {

        /**
         * 更新入住人
         *
         * @param titles
         */
        void updateCheckinPepole(List<String> titles);

        /**
         * 更新入住人信息
         *
         * @param info
         */
        void updateCheckinPepoleInfo(TenantInfoBo info);

        /**
         * 更新入住人信息 -根据手机号获取到的数据
         *
         * @param info
         */
        void updateCheckinPepoleInfoByPhone(TenantInfoBo info);

        /**
         * 关闭界面
         */
        void finishUi();
    }

}
