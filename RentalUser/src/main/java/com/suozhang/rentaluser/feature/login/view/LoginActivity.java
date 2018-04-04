/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.feature.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.suozhang.framework.entity.enums.CredentialType;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.QQUserInfoBo;
import com.suozhang.rentaluser.entity.bo.ThirdLoginBo;
import com.suozhang.rentaluser.entity.bo.WBUserInfoBo;
import com.suozhang.rentaluser.entity.bo.WxLoginInfoBo;
import com.suozhang.rentaluser.entity.bo.WxUserInfoBo;
import com.suozhang.rentaluser.feature.login.contract.LoginContract;
import com.suozhang.rentaluser.feature.login.dependencies.DaggerLoginComponent;
import com.suozhang.rentaluser.feature.login.dependencies.LoginPresenterModule;
import com.suozhang.rentaluser.framework.Config;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_login_username)
    PowerfulEditText mEtLoginUsername;
    @BindView(R.id.et_login_password)
    PowerfulEditText mEtLoginPassword;

    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.view_show_nrrmal_login)
    LinearLayout mViewShowNormalLogin;

    @BindView(R.id.iv_head)
    ImageView mIvHead;
    private ProgressDialog dialog;
    @Inject
    LoginContract.Presenter mPresenter;

    UMShareAPI mShareAPI = null;

    private int mThirdLoginType = 0;
    private WxUserInfoBo mWxUserInfoBo;
    private QQUserInfoBo mQQUserInfoBo;
    private WBUserInfoBo mWbUserInfoBo;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInjector() {
        DaggerLoginComponent.builder().loginPresenterModule(new LoginPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        mShareAPI = UMShareAPI.get(this);
        mPresenter.initUserAccout();
    }

    @Override
    protected void initView() {
        super.initView();
        mToolbar.inflateMenu(R.menu.menu_contact_register);
        initToolBar(mToolbar, "", true, true);
        dialog = new ProgressDialog(this);
//        mEtLoginUsername.setText("15013777020");
//        mEtLoginPassword.setText("as1234");
    }


    @OnClick({R.id.btn_login_qq, R.id.btn_login_wechat, R.id.btn_login_weibo})
    public void onViewClicsked(View view) {

        switch (view.getId()) {
            case R.id.btn_login_qq:
                mThirdLoginType = CredentialType.QQ.value();
                dialog.setMessage("正在启动QQ登录");
               // mShareAPI.doOauthVerify(this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.btn_login_wechat:
                mThirdLoginType = CredentialType.WX.value();
                dialog.setMessage("正在启动微信登录");
                //mShareAPI.doOauthVerify(this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.btn_login_weibo:
                mThirdLoginType = CredentialType.WEIBO.value();
                dialog.setMessage("正在启动微博");
//              //  mShareAPI.getPlatformInfo(this, SHARE_MEDIA.SINA, new UMAuthListener() {
//                    @Override
//                    public void onStart(SHARE_MEDIA share_media) {
//                        SocializeUtils.safeShowDialog(dialog);
//                    }
//
//                    @Override
//                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//                        SocializeUtils.safeCloseDialog(dialog);
//                        if (map == null) return;
//                        Logger.e("2222--->" + JSON.toJSONString(map));
//                        mWbUserInfoBo = JSON.parseObject(JSON.toJSONString(map), new TypeReference<WBUserInfoBo>() {
//                        });
//                        mPresenter.userIsExistByOpenId(mWbUserInfoBo.getUid());
//                    }
//
//                    @Override
//                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
//                        SocializeUtils.safeCloseDialog(dialog);
//                    }
//
//                    @Override
//                    public void onCancel(SHARE_MEDIA share_media, int i) {
//                        SocializeUtils.safeCloseDialog(dialog);
//                    }
//                });
                break;
        }
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_register) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    intent.putExtra("reg", Config.PHONE_TYPE_REGISTER);
                    startActivity(intent);
                }
                return false;
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShareAPI.release();
    }


    /**
     * 第三方授权监听回调
     */

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            SocializeUtils.safeShowDialog(dialog);
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data == null) return;

            Logger.e("111--->" + JSON.toJSONString(data));
            WxLoginInfoBo wxLoginInfoBo = JSON.parseObject(JSON.toJSONString(data), new TypeReference<WxLoginInfoBo>() {
            });
            mShareAPI.getPlatformInfo(LoginActivity.this, platform, new UMAuthListener() {
                @Override
                public void onStart(SHARE_MEDIA share_media) {

                }

                @Override
                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    SocializeUtils.safeCloseDialog(dialog);
                    if (map == null) return;
                    Logger.e("2222--->" + JSON.toJSONString(map));
                    if (mThirdLoginType == CredentialType.QQ.value()) {
                        mQQUserInfoBo = JSON.parseObject(JSON.toJSONString(map), new TypeReference<QQUserInfoBo>() {
                        });
                        mPresenter.userIsExistByOpenId(mQQUserInfoBo.getOpenid());
                    } else if (mThirdLoginType == CredentialType.WX.value()) {
                        mWxUserInfoBo = JSON.parseObject(JSON.toJSONString(map), new TypeReference<WxUserInfoBo>() {
                        });
                        mPresenter.userIsExistByOpenId(mWxUserInfoBo.getOpenid());
                    }


                }

                @Override
                public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                    SocializeUtils.safeCloseDialog(dialog);
                }

                @Override
                public void onCancel(SHARE_MEDIA share_media, int i) {
                    SocializeUtils.safeCloseDialog(dialog);
                }
            });

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            SocializeUtils.safeCloseDialog(dialog);
            T.showShort("失败：" + t.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            SocializeUtils.safeCloseDialog(dialog);
            T.showShort("取消了");
        }
    };


    @Override
    public void finishActivity() {

    }

    @Override
    public void showUserInfo() {
        initBooking();
        finish();
    }

    protected void initBooking() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hadLogin", true);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent); //intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle

    }

    @Override
    public void showGetCodeSuccess(String msg) {

    }


    @Override
    public void showGetCodeError(String msg) {
        T.showShort("获取验证码失败！" + msg);
    }

    @Override
    public void showLoginError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showDynamicLoginSuccess(String msg) {
        T.showShort(msg);
        initBooking();
        finish();

    }

    @Override
    public void showDynamicLoginError(String msg) {
        T.showShort(msg);
    }


    @Override
    public void showUserIsExistSuccess(Boolean msg) {


        if (mThirdLoginType == CredentialType.QQ.value()) {
            if (mQQUserInfoBo == null) return;
            if (msg) {
                mPresenter.userIsBindPhoneByOpenId(mQQUserInfoBo.getOpenid());
            } else {
                ThirdLoginBo thirdLoginBo = new ThirdLoginBo();
                thirdLoginBo.setCity(mQQUserInfoBo.getCity());
                thirdLoginBo.setHeadimgurl(mQQUserInfoBo.getIconurl());
                thirdLoginBo.setHotelId(Config.HotelId);
                thirdLoginBo.setNickname(mQQUserInfoBo.getName());
                thirdLoginBo.setOpenId(mQQUserInfoBo.getOpenid());
                if (mQQUserInfoBo.getGender().equals("男")) {
                    thirdLoginBo.setSex(0);
                } else {
                    thirdLoginBo.setSex(1);
                }
                thirdLoginBo.setProvince(mQQUserInfoBo.getProvince());
                thirdLoginBo.setUnionid(mQQUserInfoBo.getUnionid());
                thirdLoginBo.setUserSource(2);
                mPresenter.userCreate(thirdLoginBo);
            }
        } else if (mThirdLoginType == CredentialType.WX.value()) {
            if (mWxUserInfoBo == null) return;
            if (msg) {
                mPresenter.userIsBindPhoneByOpenId(mWxUserInfoBo.getOpenid());
            } else {
                ThirdLoginBo thirdLoginBo = new ThirdLoginBo();
                thirdLoginBo.setCity(mWxUserInfoBo.getCity());
                thirdLoginBo.setHeadimgurl(mWxUserInfoBo.getIconurl());
                thirdLoginBo.setCountry(mWxUserInfoBo.getCountry());
                thirdLoginBo.setHotelId(Config.HotelId);
                thirdLoginBo.setNickname(mWxUserInfoBo.getName());
                thirdLoginBo.setOpenId(mWxUserInfoBo.getOpenid());
                if (mWxUserInfoBo.getGender().equals("男")) {
                    thirdLoginBo.setSex(0);
                } else {
                    thirdLoginBo.setSex(1);
                }
                thirdLoginBo.setProvince(mWxUserInfoBo.getProvince());
                thirdLoginBo.setUnionid(mWxUserInfoBo.getUnionid());
                thirdLoginBo.setUserSource(1);
                mPresenter.userCreate(thirdLoginBo);
            }
        } else if (mThirdLoginType == CredentialType.WEIBO.value()) {
            if (mWbUserInfoBo == null) return;
            if (msg) {
                mPresenter.userIsBindPhoneByOpenId(mWbUserInfoBo.getUid());
            } else {
                ThirdLoginBo thirdLoginBo = new ThirdLoginBo();

                thirdLoginBo.setHeadimgurl(mWbUserInfoBo.getIconurl());
                thirdLoginBo.setHotelId(Config.HotelId);
                thirdLoginBo.setNickname(mWbUserInfoBo.getName());
                thirdLoginBo.setOpenId(mWbUserInfoBo.getUid());
                if (mWbUserInfoBo.getGender().equals("男")) {
                    thirdLoginBo.setSex(0);
                } else {
                    thirdLoginBo.setSex(1);
                }
                thirdLoginBo.setUserSource(3);
                mPresenter.userCreate(thirdLoginBo);
            }
        }

    }

    @Override
    public void showUserIsExistError(String msg) {
        T.showLong(msg);
    }

    @Override
    public void showUserIsBindPhoneSuccess(Boolean msg) {
        if (mThirdLoginType == CredentialType.QQ.value()) {
            if (msg) {
                mPresenter.loginByWx(mQQUserInfoBo.getOpenid(), CredentialType.QQ.value());
            } else {
                Intent intentphone = new Intent(this, RegisterActivity.class);
                intentphone.putExtra("reg", Config.PHONE_TYPE_WECHAT);
                intentphone.putExtra("openId", mQQUserInfoBo.getOpenid());
                startActivityForResult(intentphone, 1);
            }
        } else if (mThirdLoginType == CredentialType.WX.value()) {
            if (msg) {
                mPresenter.loginByWx(mWxUserInfoBo.getOpenid(), CredentialType.WX.value());
            } else {
                Intent intentphone = new Intent(this, RegisterActivity.class);
                intentphone.putExtra("reg", Config.PHONE_TYPE_WECHAT);
                intentphone.putExtra("openId", mWxUserInfoBo.getOpenid());
                startActivityForResult(intentphone, 1);
            }
        } else if (mThirdLoginType == CredentialType.WEIBO.value()) {
            if (msg) {
                mPresenter.loginByWx(mWbUserInfoBo.getUid(), CredentialType.WEIBO.value());
            } else {
                Intent intentphone = new Intent(this, RegisterActivity.class);
                intentphone.putExtra("reg", Config.PHONE_TYPE_WECHAT);
                intentphone.putExtra("openId", mWbUserInfoBo.getUid());
                startActivityForResult(intentphone, 1);
            }
        }

    }

    @Override
    public void showUserIsBindPhoneError(String msg) {
        T.showLong(msg);

    }

    @Override
    public void showCreateUserSuccess(String msg) {
        if (mThirdLoginType == CredentialType.QQ.value()) {
            mPresenter.userIsBindPhoneByOpenId(mQQUserInfoBo.getOpenid());
        } else if (mThirdLoginType == CredentialType.WX.value()) {
            mPresenter.userIsBindPhoneByOpenId(mWxUserInfoBo.getOpenid());
        } else if (mThirdLoginType == CredentialType.WEIBO.value()) {
            mPresenter.userIsBindPhoneByOpenId(mWbUserInfoBo.getUid());
        }

    }

    @Override
    public void showCreateUserError(String msg) {
        T.showLong("创建失败！" + msg);
    }


    @OnClick(R.id.bt_login_reset_password)
    public void onViewClicked() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.putExtra("reg", Config.PHONE_TYPE_RESET);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mShareAPI.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Bundle extras = data.getExtras(); //data为B中回传的Intent
            switch (requestCode) {
                case 1:
                    boolean isBindSuccess = extras.getBoolean("bind");
                    String openId = extras.getString("openId");
                    if (isBindSuccess && !TextUtils.isEmpty(openId)) {
                        mPresenter.loginByWx(openId, mThirdLoginType);
                    }
                    break;
                case 2:
                    boolean msg = extras.getBoolean("result");
                    if (msg) {
                        finish();
                    }
                    break;
            }
        }
    }


    @OnClick(R.id.bt_login)
    public void onViewLoginClicked() {
            String username = mEtLoginUsername.getText().toString();
            String password = mEtLoginPassword.getText().toString();
            mPresenter.login(username, password);

    }



    @OnClick(R.id.btn_fast_login)
    public void onViewQuickClicked() {
        startActivityForResult(new Intent(this,DynamicLoginActivity.class),2);
    }


}
