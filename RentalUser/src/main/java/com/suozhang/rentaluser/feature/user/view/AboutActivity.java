package com.suozhang.rentaluser.feature.user.view;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.common.base.Strings;
import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.entity.bo.AppUpdateInfo;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.AppUtil;
import com.suozhang.rentaluser.R;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/14 11:15
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_app_name)
    TextView mTvAppName;
    @BindView(R.id.tv_version_name)
    TextView mTvVersionName;
    @BindView(R.id.tv_version_info)
    TextView mTvVersionInfo;
    @BindView(R.id.tv_check_update)
    TextView mTvCheckUpdate;
    @BindView(R.id.tv_protocol)
    TextView mTvProtocol;
    @BindView(R.id.tv_service_terms)
    TextView mTvServiceTerms;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_about;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, R.string.title_about, true, true);
    }

    @Override
    protected void initData() {
        showLocalAppVersionInfo();
    }

    private void showLocalAppVersionInfo() {
        String appName = Strings.nullToEmpty(AppUtil.getAppName(this));
        String versionName = "（v" + Strings.nullToEmpty(AppUtil.getVersionName(this)) + "）";
        mTvAppName.setText(appName);
        mTvVersionName.setText(versionName);
    }

    @OnClick(R.id.tv_version_info)
    public void onMTvVersionInfoClicked() {
        showErrorMsg("功能暂未开放");
    }

    @OnClick(R.id.tv_check_update)
    public void onMTvCheckUpdateClicked() {
        checkUpdate();
    }

    @OnClick(R.id.tv_protocol)
    public void onMTvProtocolClicked() {
        showErrorMsg("功能暂未开放");
    }

    @OnClick(R.id.tv_service_terms)
    public void onMTvServiceTermsClicked() {
        showErrorMsg("功能暂未开放");
    }


    private void checkUpdate() {

        AM.appUpdate().getAppUpdateInfo(this)
                .compose(this.<AppUpdateInfo>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<AppUpdateInfo>(this) {
                    @Override
                    public void onNext(@NonNull AppUpdateInfo appUpdateInfo) {

                        int serverVer = appUpdateInfo.getVersionCode();
                        int localVer = AppUtil.getVersionCode(getApplicationContext());

                        //网络版本大于本地版本才提示升级
                        if (serverVer > localVer) {
                            AM.appUpdate().checkUpdate(getApplicationContext());
                        } else {
                            showMsg("已是最新版本");
                        }

                    }
                });
    }

}
