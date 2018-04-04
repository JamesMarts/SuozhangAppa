package com.suozhang.rentaluser.feature.user.view;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.luck.picture.lib.tools.PictureFileUtils;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DataCleanManager;
import com.suozhang.rentaluser.common.widget.CommonDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.bt_userinfo_data)
    TextView mBtUserinfoData;
    @BindView(R.id.tg_is_add_contact)
    ToggleButton mTgIsAddContact;
    private CommonDialog mDialog;
    private String mDatas;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "设置", true, true);
    }

    @Override
    protected void initData() {
        try {
            mDatas = DataCleanManager.getTotalCacheSize(this);
            if (!TextUtils.isEmpty(mDatas)) {
                mBtUserinfoData.setText(mDatas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean isChecked = AM.user().isAllowLockScreen();
        Logger.e("初始化isAllowLockScreen = " + isChecked);

        mTgIsAddContact.setChecked(isChecked);

    }


    @OnClick(R.id.bt_login_out)
    public void onViewClicked() {
        mDialog = new CommonDialog(this, "确认要退出登录吗？", new CommonDialog.MyClickListenerInterface() {
            @Override
            public void doConfirm() {
                if (AM.user().isLogin()) {
                    AM.user().loginOut();
                }
                finish();
            }
        });
        mDialog.show();
    }

    @Override
    protected void initEvent() {
        mTgIsAddContact.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                AM.user().setAllowLockScreen(isChecked);
            }
        });
    }

    @OnClick(R.id.bt_userinfo_data)
    public void onCliViewClicked() {
        DataCleanManager.clearAllCache(this);
        PictureFileUtils.deleteCacheDirFile(this);
//        SystemClock.sleep(2000);
        try {
            mDatas = DataCleanManager.getTotalCacheSize(this);
            if (!TextUtils.isEmpty(mDatas)) {
                mBtUserinfoData.setText(mDatas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
