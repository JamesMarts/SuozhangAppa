package com.suozhang.rentaluser.feature.life.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.common.base.Strings;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.utils.ValidatorUtil;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.UploadPicUtil;
import com.suozhang.rentaluser.entity.bo.PicBo;
import com.suozhang.rentaluser.entity.bo.TenantInfoBo;
import com.suozhang.rentaluser.entity.enums.CheckinPepoleType;
import com.suozhang.rentaluser.feature.life.contract.CheckinPepoleContract;
import com.suozhang.rentaluser.feature.life.dependencies.checkinpepole.DaggerCheckinPepolePresenterComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/16 17:23
 */

public class CheckinPepolePresenter implements CheckinPepoleContract.Presenter {

    private CheckinPepoleContract.View mView;
    @Inject
    CheckinPepoleContract.Model mModel;

    private List<TenantInfoBo> mDatas;


    public CheckinPepolePresenter(CheckinPepoleContract.View mView) {
        this.mView = mView;
        DaggerCheckinPepolePresenterComponent.create().inject(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void selectOrPreviewPic(BaseQuickAdapter adapter, int position, int requestCode, int maxPic) {
        PicBo pic = (PicBo) adapter.getItem(position);
        if (pic.isAddBtn()) {
            //删除服务端获取到的图片
            boolean hasUrlPic = UploadPicUtil.hasUrlPic(adapter.getData());
            if (hasUrlPic) {
                mView.showErrorMsg("请删除原图片重新选择本地图片！");
                return;
            }

            int count = maxPic + 1 - adapter.getItemCount();
            if (count <= 0) {
                mView.showErrorMsg("最多只能上传" + maxPic + "张照片");
                return;
            }

            //添加
            PictureSelector.create((Activity) mView)
                    .openGallery(PictureMimeType.ofImage())
                    .maxSelectNum(count)
                    .compress(true)
                    .isCamera(true)// 是否显示拍照按钮
                    .isGif(false)// 是否显示gif图片
                    .selectionMedia(null)
                    .forResult(requestCode);
        } else {
            //预览
            List<LocalMedia> selectList = new ArrayList<>();
            List<PicBo> datas = adapter.getData();
            for (PicBo p : datas) {
                if (!p.isAddBtn()) {
                    String path = p.getFile() == null ? p.getUrl() : p.getFile().getPath();
                    selectList.add(new LocalMedia(path, 2, PictureMimeType.ofImage(), null));
                }
            }
            PictureSelector.create((Activity) mView).externalPicturePreview(0, selectList);
        }
    }

    @Override
    public void addPic(BaseQuickAdapter adapter, Intent data, int maxPic) {
        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        for (LocalMedia media : selectList) {
            String path;
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                path = media.getCompressPath();
            } else {
                // 原图地址
                path = media.getPath();
            }

            //只添加maxPic张图片
            if (adapter.getItemCount() < maxPic + 1) {
                File file = new File(path);
                adapter.addData(new PicBo(file));
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void deletePic(BaseQuickAdapter adapter, int position) {
        adapter.remove(position);
    }

    @Override
    public void queryCheckinPepoleInfos(String contractId) {
        if (TextUtils.isEmpty(contractId)) {
            mView.showErrorMsg(R.string.msg_parameter_error);
            return;
        }
        mModel.doQueryCheckinPepoleInfos(contractId)
                .compose(mView.<List<TenantInfoBo>>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<List<TenantInfoBo>>(mView) {
                    @Override
                    public void onNext(@NonNull List<TenantInfoBo> leaseContractBos) {
                        initAndUpdateData(leaseContractBos);
                    }
                });
    }

    @Override
    public void queryCheckinPepoleInfoByPhone(String phone) {
        if (TextUtils.isEmpty(phone) || !ValidatorUtil.isMobile(phone)) {
            mView.showErrorMsg("手机号输入有误");
            return;
        }

        mModel.doQueryCheckinPepoleInfoByPhone(phone)
                .compose(mView.<TenantInfoBo>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<TenantInfoBo>(mView) {
                    @Override
                    public void onNext(TenantInfoBo tenant) {
                        updateTenantInfo(tenant);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        updateTenantInfo(null);
                    }
                });
    }

    private void updateTenantInfo(TenantInfoBo tenant) {
        tenant = tenant == null ? new TenantInfoBo() : tenant;

        tenant.setCheckInfoPepoleName(Strings.nullToEmpty(tenant.getCheckInfoPepoleName()));
        tenant.setPhone(Strings.nullToEmpty(tenant.getPhone()));
        tenant.setCardNumber(Strings.nullToEmpty(tenant.getCardNumber()));
        mView.updateCheckinPepoleInfoByPhone(tenant);
    }


    private void initAndUpdateData(List<TenantInfoBo> results) {
        //排序，承租人排最前
        Collections.sort(results, new Comparator<TenantInfoBo>() {
            @Override
            public int compare(TenantInfoBo o1, TenantInfoBo o2) {
                int sort1 = o1.getCheckInfoPepoleTypeEnum() == CheckinPepoleType.TENANT ? 0 : 1;
                int sort2 = o2.getCheckInfoPepoleTypeEnum() == CheckinPepoleType.TENANT ? 0 : 1;
                return sort1 - sort2;
            }
        });
        mDatas = results;

        List<String> pepoles = new ArrayList<>();
        for (TenantInfoBo result : results) {
            String name = Strings.nullToEmpty(result.getCheckInfoPepoleName());
            boolean isTenant = result.getCheckInfoPepoleTypeEnum() == CheckinPepoleType.TENANT;
            pepoles.add(isTenant ? "承租人" : name);
        }
        //先初始化信息
        checkParamsAndUpdate(null);
        //初始化TabLayout 初始化后会重新加载下拉列表
        mView.updateCheckinPepole(pepoles);
    }

    @Override
    public void checkParamsAndUpdate(TenantInfoBo result) {
        TenantInfoBo info = null;
        try {
            info = result == null ? new TenantInfoBo() : result.clone();
        } catch (CloneNotSupportedException e) {
        }
        if (info == null) {
            return;
        }

        info.setCheckInfoPepoleName(Strings.nullToEmpty(info.getCheckInfoPepoleName()));
        info.setPhone(Strings.nullToEmpty(info.getPhone()));
        info.setCardNumber(Strings.nullToEmpty(info.getCardNumber()));
        info.setCardImagePic(UploadPicUtil.getPics(info.getListCardImageUrl(), false));

        info.setRemark(Strings.nullToEmpty(info.getRemark()));

        mView.updateCheckinPepoleInfo(info);
    }

    @Override
    public void queryCheckinPepoleInfoByPosition(int position) {
        TenantInfoBo info = mDatas == null ? null : mDatas.get(position);
        checkParamsAndUpdate(info);
    }

    @Override
    public void affirmCheckinPepole(final String contractId, String checkinPepoleId) {
        if (TextUtils.isEmpty(checkinPepoleId)) {
            mView.showErrorMsg(R.string.msg_parameter_error);
            return;
        }
        mModel.doAffirmCheckinPepole(checkinPepoleId)
                .compose(mView.<String>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<String>(mView) {
                    @Override
                    public void onNext(@NonNull String s) {
                        mView.showMsg("确认成功");
                        queryCheckinPepoleInfos(contractId);
                    }
                });
    }

    @Override
    public void addOrUpdateCheckinPepole(final boolean isAdd, boolean isTenant, final String contractId, String checkinPepoleId, TenantInfoBo info) {
        TenantInfoBo params = checkParams(isAdd, isTenant, contractId, checkinPepoleId, info);
        if (params == null) {
            return;
        }

        Observable<String> observable = isAdd ? mModel.doAddCheckinPepole(contractId, info)
                : mModel.doUpdateCheckinPepole(checkinPepoleId, info);

        observable.compose(mView.<String>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<String>(mView) {
                    @Override
                    public void onNext(@NonNull String s) {
                        if (isAdd) {
                            mView.showMsg("添加成功");
                            mView.finishUi();
                        } else {
                            mView.showMsg("修改成功");
                            queryCheckinPepoleInfos(contractId);
                        }
                    }
                });
    }

    /**
     * 检查参数
     * 1.添加：验证所有参数
     * 2.修改：承租人，可修改性别，手机号，备注；入住人可修改所有参数
     *
     * @param isAdd
     * @param isTenant
     * @param contractId
     * @param checkinPepoleId
     * @param info
     * @return
     */
    private TenantInfoBo checkParams(boolean isAdd, boolean isTenant, String contractId, String checkinPepoleId, TenantInfoBo info) {

        List<PicBo> idcards = UploadPicUtil.getPicFiles(info.getCardImagePic());

        if (isAdd) {
            if (TextUtils.isEmpty(contractId)) {
                mView.showErrorMsg("参数错误：合同Id不能为null");
                return null;
            }
            if (TextUtils.isEmpty(info.getPhone()) || !ValidatorUtil.isMobile(info.getPhone())) {
                mView.showErrorMsg("手机号输入有误");
                return null;
            }

            /*if (TextUtils.isEmpty(info.getCheckInfoPepoleName())) {
                mView.showErrorMsg("租客姓名输入有误");
                return null;
            }

            if (TextUtils.isEmpty(info.getCardNumber()) || !ValidatorUtil.isIDCard(info.getCardNumber())) {
                mView.showErrorMsg("身份证号输入有误");
                return null;
            }*/

            //添加时，照片必须为正反2张图片
            if (idcards == null || idcards.size() != 2) {
                mView.showErrorMsg("身份证照片必须包含正反面2张图片");
                return null;
            }
            info.setCardImagePic(idcards);

        } else {
            if (TextUtils.isEmpty(checkinPepoleId)) {
                mView.showErrorMsg("参数错误：入住人Id不能为null");
                return null;
            }

            if (isTenant) {
               /* if (TextUtils.isEmpty(info.getPhone()) || !ValidatorUtil.isMobile(info.getPhone())) {
                    mView.showErrorMsg("手机号输入有误");
                    return null;
                }*/
                info.setPhone(null);

                info.setCheckInfoPepoleName(null);
                info.setCardNumber(null);
                info.setListCardImageUrl(null);
                info.setCardImagePic(null);
            } else {
                if (TextUtils.isEmpty(info.getPhone()) || !ValidatorUtil.isMobile(info.getPhone())) {
                    mView.showErrorMsg("手机号输入有误");
                    return null;
                }
               /* if (TextUtils.isEmpty(info.getCheckInfoPepoleName())) {
                    mView.showErrorMsg("租客姓名输入有误");
                    return null;
                }

                if (TextUtils.isEmpty(info.getCardNumber()) || !ValidatorUtil.isIDCard(info.getCardNumber())) {
                    mView.showErrorMsg("身份证号输入有误");
                    return null;
                }*/
                //更新时，照片可不修改，否则照片必须为正反2张图片
                if (idcards != null && idcards.size() != 2) {
                    mView.showErrorMsg("身份证照片必须包含正反面2张图片");
                    return null;
                }
                info.setCardImagePic(idcards);
            }
        }
        return info;
    }
}
