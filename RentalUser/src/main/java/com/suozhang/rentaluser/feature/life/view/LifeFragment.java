package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.framework.utils.SPUtil;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.LifeMenuSection;
import com.suozhang.rentaluser.entity.bo.MyLifeBo;
import com.suozhang.rentaluser.feature.life.contract.LifeContract;
import com.suozhang.rentaluser.feature.life.dependencies.life.DaggerLifeComponent;
import com.suozhang.rentaluser.feature.life.dependencies.life.LifePresenterModule;
import com.suozhang.rentaluser.feature.life.view.adapter.LifeMenuAdapter;
import com.suozhang.rentaluser.feature.login.view.LoginActivity;
import com.suozhang.rentaluser.feature.rental.view.RentalListActivity;
import com.suozhang.rentaluser.feature.user.view.MessageActivity;
import com.suozhang.rentaluser.framework.DataServer;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.suozhang.rentaluser.framework.Config.KEY_AREA_ID;

public class LifeFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener, LifeContract.View {


    @BindView(R.id.rv_life_menu)
    RecyclerView mRvLifeMenu;
    @BindView(R.id.btn_life_payment)
    TextView mBtnLifePayment;
    Unbinder unbinder;
    @BindView(R.id.view_no_pay)
    LinearLayout mViewNoPay;
    @BindView(R.id.view_no_check_in)
    LinearLayout mViewNoCheckIn;
    @BindView(R.id.view_no_bills)
    LinearLayout mViewNoBills;
    @BindView(R.id.tv_pay_money)
    TextView mTvPayMoney;
    TextView mTvUserNick;
    @BindView(R.id.tv_show_unread_count)
    TextView mTvShowUnreadCount;
    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;
    Unbinder unbinder4;
    private List<LifeMenuSection> mMenuData;
    LifeMenuAdapter sectionAdapter;
    private MyLifeBo mData;


    @Inject
    LifeContract.Presenter mPresenter;

    @Override
    public int attachLayoutRes() {
        return R.layout.activity_life_fragment;
    }

    @Override
    protected void initInjector() {
        DaggerLifeComponent.builder().lifePresenterModule(new LifePresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {

        if (AM.user().isLogin()){
            mTvShowUnreadCount.setVisibility(View.VISIBLE);
        }else {
            mTvShowUnreadCount.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        initAdapter();
        mPresenter.getMyRentState();
        mPresenter.doGetUnreadMessageCount();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    private void initAdapter() {
        mRvLifeMenu.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mMenuData = DataServer.getSampleData();
        sectionAdapter = new LifeMenuAdapter(mMenuData);
        mRvLifeMenu.setAdapter(sectionAdapter);
        sectionAdapter.setOnItemChildClickListener(this);
    }


    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (!AM.user().isLogin()) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            return;
        }
        LifeMenuSection lifeMenuSection = mMenuData.get(position);


        if (!lifeMenuSection.isHeader) {
            switch (lifeMenuSection.t.getClickType()) {
                case 0:
                    startActivity(new Intent(getActivity(), MyRoomActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), MyContractActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(getActivity(), PaymentRecordsActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(getActivity(), RepairServiceActivity.class));
                    break;
                case 4:
                    T.showShort("正在开发中...");
                    break;
                case 5:
                    T.showShort("正在开发中...");
                    break;
                case 6:
                    T.showShort("正在开发中...");
                    break;
                case 7:
                    T.showShort("正在开发中...");
                    break;
                case 8:
                    T.showShort("正在开发中...");
                    break;
                default:
                    break;
            }

        }
    }


    @OnClick(R.id.btn_life_payment)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), BillingDetailActivity.class);
        if (mData != null && !TextUtils.isEmpty(mData.getId())) {
            intent.putExtra("id", mData.getId());
            startActivity(intent);
        }

    }

    @Override
    public void showSuccess(MyLifeBo contractBos) {
        mData = contractBos;
        initRentData(mData);
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void showMsgCount(Integer count) {
        if (count != null && count <= 0) {
            mTvShowUnreadCount.setVisibility(View.GONE);
        } else {
            mTvShowUnreadCount.setText(count + "");
            mTvShowUnreadCount.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void showMsgCountError(String msg) {

    }

    private void initRentData(MyLifeBo lifeBo) {
        if (lifeBo.isIsRentRoom()) {
            if (lifeBo.isIsStayRentBill()) {
                mViewNoCheckIn.setVisibility(View.GONE);
                mViewNoBills.setVisibility(View.GONE);
                mViewNoPay.setVisibility(View.VISIBLE);
                mTvPayMoney.setText(lifeBo.getPayAmount() + "");
            } else {
                mViewNoCheckIn.setVisibility(View.GONE);
                mViewNoBills.setVisibility(View.VISIBLE);
                mViewNoPay.setVisibility(View.GONE);
            }
        } else {
            mViewNoCheckIn.setVisibility(View.VISIBLE);
            mViewNoBills.setVisibility(View.GONE);
            mViewNoPay.setVisibility(View.GONE);
        }
    }


    @OnClick(R.id.btn_life_need_checkin)
    public void onViewNeedCheckClicked() {

        if (mData != null && !TextUtils.isEmpty(mData.getId())) {
            Intent intent = new Intent(getActivity(), BillingDetailActivity.class);
            intent.putExtra("id", mData.getId());
            startActivity(intent);
        } else {

            BaseBo baseBo = (BaseBo) SPUtil.readObj(getActivity(), KEY_AREA_ID);
            Intent intent = new Intent(getActivity(), RentalListActivity.class);
            if (baseBo != null && !TextUtils.isEmpty(baseBo.getId())) {
                intent.putExtra("areaId", baseBo.getId());
            }
            startActivity(intent);
        }
    }


    @OnClick(R.id.btn_user_message)
    public void onMessageViewClicked() {
        Intent intent
                = new Intent(getActivity(), MessageActivity.class);
        startActivity(intent);
    }


}
