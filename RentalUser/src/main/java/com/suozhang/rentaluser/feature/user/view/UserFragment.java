package com.suozhang.rentaluser.feature.user.view;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.suozhang.framework.component.image.GlideCircleTransform;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.login.view.LoginActivity;
import com.suozhang.rentaluser.feature.user.contract.UserCenterContract;
import com.suozhang.rentaluser.feature.user.dependencies.ediruser.DaggerUserComponent;
import com.suozhang.rentaluser.feature.user.dependencies.ediruser.UserPresenterModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;


public class UserFragment extends BaseFragment implements UserCenterContract.View {

    @BindView(R.id.iv_user_head)
    ImageView mIvUserHead;

    @Inject

    UserCenterContract.Presenter mPresenter;
    @BindView(R.id.tv_user_nick)
    TextView mTvUserNick;
    @BindView(R.id.tv_show_unread_count)
    TextView mTvShowUnreadCount;
    Unbinder unbinder;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initInjector() {
        DaggerUserComponent.builder().userPresenterModule(new UserPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        if (AM.user().isLogin()) {
            mPresenter.getUserInfo();
            mPresenter.doGetUnreadMessageCount();
            mTvShowUnreadCount.setVisibility(View.VISIBLE);
        } else {
            mTvUserNick.setText("未登录");
            mIvUserHead.setImageResource(R.drawable.ic_head_portrait_man);
            mTvShowUnreadCount.setVisibility(View.GONE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void initEvent() {

    }


    @OnClick({R.id.btn_user_coupons, R.id.btn_user_collection, R.id.btn_user_certificate, R.id.btn_user_order, R.id.btn_user_account, R.id.btn_user_setting, R.id.btn_user_more, R.id.btn_user_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user_coupons:
                break;
            case R.id.btn_user_message:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.btn_user_collection:
                startActivity(new Intent(getActivity(), CollectionActivity.class));
                break;
            case R.id.btn_user_certificate:
                startActivity(new Intent(getActivity(), CertificationActivity.class));
                break;
            case R.id.btn_user_order:
                break;
            case R.id.btn_user_account:
                if (AM.user().isLogin()) {
                    startActivity(new Intent(getActivity(), AccountSafeActivity.class));
                } else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }

                break;
            case R.id.btn_user_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.btn_user_more:
                startActivity(new Intent(getActivity(), MoreActivity.class));
                break;
            default:
                break;
        }
    }


    @OnClick(R.id.btn_user_info)
    public void onViewClicked() {
        if (AM.user().isLogin()) {
            startActivity(new Intent(getActivity(), UserInfoActivity.class));
        } else {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void showUserInfo(UserInfoBo userInfoBo) {
        if (userInfoBo != null) {
            if (mIvUserHead != null) {

                if (userInfoBo.isSex()) {
                    Glide.with(this)
                            .load(userInfoBo.getIcon())
                            .apply(new RequestOptions().clone()
                                    .transform(new GlideCircleTransform(getActivity()))
                                    .error(R.drawable.ic_head_portrait_man)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL))
                            .into(mIvUserHead);

                } else {
                    Glide.with(this)
                            .load(userInfoBo.getIcon())
                            .apply(new RequestOptions().clone()
                                    .transform(new GlideCircleTransform(getActivity()))
                                    .error(R.drawable.ic_head_portrait_woman)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL))
                            .into(mIvUserHead);
                }
            }
            if (mTvUserNick != null) {
                mTvUserNick.setText(TextUtils.isEmpty(userInfoBo.getNickName()) ? "" : userInfoBo.getNickName());
            }


        }
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void showMsgCount(Integer count) {
        if (count != null&&count<=0) {
            mTvShowUnreadCount.setVisibility(View.GONE);
        } else {
            mTvShowUnreadCount.setText(count + "");
            mTvShowUnreadCount.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void showMsgCountError(String msg) {

    }


}
