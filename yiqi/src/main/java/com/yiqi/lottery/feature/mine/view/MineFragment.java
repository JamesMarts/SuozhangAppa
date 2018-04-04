package com.yiqi.lottery.feature.mine.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseFragment;
import com.yiqi.lottery.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.yiqi.lottery.feature.common.view.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.iv_user_head)
    ImageView ivUserHead;
    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {
        AM.image().bindToCircleObject("http://himg2.huanqiu.com/attachment2010/2012/0517/20120517040321282.jpg", ivUserHead);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @OnClick({R.id.btn_user_info, R.id.btn_user_recharge, R.id.btn_user_withdraw, R.id.btn_user_mseeage,
            R.id.btn_user_basicinfo, R.id.btn_user_bind_iphone, R.id.btn_user_verified,
            R.id.btn_user_betting_record, R.id.btn_user_tracing_management, R.id.btn_user_edit_pwd,
            R.id.btn_user_account_detail, R.id.btn_user_withdraw_setting, R.id.tv_user_edit_nick,
            R.id.btn_user_betting_setting,R.id.btn_user_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user_info://用户信息
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.tv_user_edit_nick://修改昵称
                Intent intentEditNick = new Intent(getActivity(), EditNickActivity.class);
                startActivity(intentEditNick);
                break;
            case R.id.btn_user_recharge://充值
                Intent intentRecharge = new Intent(getActivity(), RechargeActivity.class);
                startActivity(intentRecharge);
                break;
            case R.id.btn_user_withdraw://提现
                Intent intentWithdraw = new Intent(getActivity(), WithdrawActivity.class);
                startActivity(intentWithdraw);
                break;
            case R.id.btn_user_mseeage://消息中心
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            case R.id.btn_user_basicinfo://基础资料

                break;
            case R.id.btn_user_bind_iphone://绑定手机
                startActivity(new Intent(getActivity(), EditPhoneActivity.class));
                break;
            case R.id.btn_user_verified://实名认证
                startActivity(new Intent(getActivity(), VerifiedActivity.class));
                break;
            case R.id.btn_user_betting_record://投注记录
                startActivity(new Intent(getActivity(), BeetingDetailActivity.class));
                break;
            case R.id.btn_user_tracing_management://追号管理
                startActivity(new Intent(getActivity(), NumberManageActivity.class));
                break;
            case R.id.btn_user_edit_pwd://修改密码
                startActivity(new Intent(getActivity(), EditPasswordActivity.class));
                break;
            case R.id.btn_user_account_detail://账户明细
                Intent intentAccount = new Intent(getActivity(), AccountInfoActivity.class);
                startActivity(intentAccount);
                break;
            case R.id.btn_user_withdraw_setting://提现账户设置
                startActivity(new Intent(getActivity(), WithdrawalAccountSettingActivity.class));
                break;

            case R.id.btn_user_betting_setting://投注站基本信息
                startActivity(new Intent(getActivity(), BettingStationInfoActivity.class));
                break;
            case R.id.btn_user_setting://设置
                startActivity(new Intent(getActivity(), SeetingActivity.class));
                break;
        }
    }
}
