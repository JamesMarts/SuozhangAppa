package com.suozhang.rentaluser.feature.life.view;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.permission.PermissionsManager;
import com.suozhang.framework.component.permission.PermissionsResultAction;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.DensityUtil;
import com.suozhang.framework.utils.PermissionHint;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.TenantInfoBo;
import com.suozhang.rentaluser.entity.enums.CheckinPepoleType;
import com.suozhang.rentaluser.feature.life.contract.CheckinPepoleContract;
import com.suozhang.rentaluser.feature.life.dependencies.checkinpepole.CheckinPepolePresenterModule;
import com.suozhang.rentaluser.feature.life.dependencies.checkinpepole.DaggerCheckinPepoleComponent;
import com.suozhang.rentaluser.feature.life.view.adapter.UploadIdcardPicAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LivePeopleActivity extends BaseActivity implements CheckinPepoleContract.View,
        SwipeRefreshLayout.OnRefreshListener,
        TabLayout.OnTabSelectedListener,
        Toolbar.OnMenuItemClickListener,
        BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.OnItemChildClickListener {


    private static final int REQUEST_CODE_IDCARD = 100;//身份证照片

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.edt_tenant_name)
    EditText mEdtTenantName;
    @BindView(R.id.tv_affirm_status)
    TextView mTvAffirmStatus;
    @BindView(R.id.rbtn_sex_man)
    RadioButton mRbtnSexMan;
    @BindView(R.id.rbtn_sex_woman)
    RadioButton mRbtnSexWoman;
    @BindView(R.id.group_sex)
    RadioGroup mGroupSex;
    @BindView(R.id.edt_tenant_phone)
    EditText mEdtTenantPhone;
    @BindView(R.id.edt_idcard)
    EditText mEdtIdcard;
    @BindView(R.id.rv_idcard_pic)
    RecyclerView mRvIdcardPic;
    @BindView(R.id.edt_remark)
    EditText mEdtRemark;
    @BindView(R.id.btn_ok)
    Button mBtnOk;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.layout_remark)
    View mLayoutRemark;

    @Inject
    CheckinPepoleContract.Presenter mPresenter;

    private UploadIdcardPicAdapter mIdcardAdapter;

    private boolean isAdd;

    private String mContractId;
    private String mRecordId;
    private String mCheckInfoPepoleId;
    private boolean isAffirm;
    private CheckinPepoleType mCheckinPepoleType;
    /**
     * 是否点击了添加租客，点击后返回刷新数据，否则不刷新数据
     */
    private boolean isClickAddTenant;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_checkin_pepole;
    }

    @Override
    protected void initInjector() {
        DaggerCheckinPepoleComponent.builder()
                .checkinPepolePresenterModule(new CheckinPepolePresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, R.string.title_checkin_pepole);
        mToolbar.inflateMenu(R.menu.menu_checkin_pepole);
        mSwipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        initIdcardAdapter();
    }

    @Override
    protected void initData() {
        isAdd = getIntent().getBooleanExtra("isAdd", false);
        mContractId = getIntent().getStringExtra("contractId");
        initUi(isAdd, false, false);
        onRefresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isClickAddTenant) {
            onRefresh();
            this.isClickAddTenant = false;
        }
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mSwipeLayout.setOnRefreshListener(this);
        mToolbar.setOnMenuItemClickListener(this);
        mTabLayout.addOnTabSelectedListener(this);
        mIdcardAdapter.setOnItemClickListener(this);
        mIdcardAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void dismissLoading() {
        super.dismissLoading();
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        if (isAdd) {
            mSwipeLayout.setRefreshing(false);
        } else {
            mPresenter.queryCheckinPepoleInfos(mContractId);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.item_add_tenant) {
            //添加租客
            Intent intent = new Intent(this, LivePeopleActivity.class);
            intent.putExtra("isAdd", true);
            intent.putExtra("contractId", mRecordId);
            startActivity(intent);

            this.isClickAddTenant = true;
            return true;
        }
        return false;
    }

    @Override
    public void onItemClick(final BaseQuickAdapter adapter, View view, final int position) {
        //身份证照片Item点击
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(
                this,
                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        mPresenter.selectOrPreviewPic(adapter, position, REQUEST_CODE_IDCARD, 2);
                    }

                    @Override
                    public void onDenied(String permission) {
                        PermissionHint.show(LivePeopleActivity.this, false);
                    }
                });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        //删除身份证照片
        mPresenter.deletePic(adapter, position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_IDCARD) {
            mPresenter.addPic(mIdcardAdapter, data, 2);
        }
    }

    @OnTextChanged(R.id.edt_tenant_phone)
    public void onPhoneTextChanged(CharSequence s, int start, int before, int count) {
        //手机号输入变化，查询入住人信息
        if (!isAdd) {
            return;
        }
        String phone = s.toString().trim();
        if (phone.length() != 11) {
            return;
        }

        mPresenter.queryCheckinPepoleInfoByPhone(phone);
    }

    private boolean isSave;

    @OnClick(R.id.btn_ok)
    public void onViewClicked() {
        TenantInfoBo info = new TenantInfoBo();
        info.setCheckInfoPepoleName(getTextValue(mEdtTenantName));
        info.setSex(mRbtnSexMan.isChecked());
        info.setPhone(getTextValue(mEdtTenantPhone));
        info.setCardNumber(getTextValue(mEdtIdcard));
        info.setCardImagePic(mIdcardAdapter.getData());
        info.setRemark(getTextValue(mEdtRemark));

        boolean isTenant = mCheckinPepoleType == CheckinPepoleType.TENANT;
        if (isAdd) {
            mPresenter.addOrUpdateCheckinPepole(true, isTenant, mContractId, mCheckInfoPepoleId, info);
        } else {
            if (isAffirm) {
                //编辑or保存
                if (isSave) {
                    mPresenter.addOrUpdateCheckinPepole(false, isTenant, mContractId, mCheckInfoPepoleId, info);
                } else {
                    //承租人可修改性别，手机号，备注，入住人信息均可修改
                    setUiEnabled(isTenant, true);
                    mBtnOk.setText("提交");
                    this.isSave = true;
                }
            } else {
                //确认
                mPresenter.affirmCheckinPepole(mContractId, mCheckInfoPepoleId);
            }
        }
    }

    private String getTextValue(TextView v) {
        return v.getText().toString().trim();
    }

    @Override
    public void updateCheckinPepole(List<String> titles) {
        mTabLayout.removeAllTabs();
        //4个一下固定模式，否则滚动模式
        int count = titles.size();
        int mode = count <= 4 ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE;
        int visible = count > 1 ? View.VISIBLE : View.GONE;
        mTabLayout.setTabMode(mode);
        mTabLayout.setVisibility(visible);

        for (String title : titles) {
            mTabLayout.addTab(mTabLayout.newTab().setText(title));
        }
    }

    @Override
    public void updateCheckinPepoleInfo(TenantInfoBo info) {
        mRecordId = info.getRecordId();
        mCheckInfoPepoleId = info.getId();
        mCheckinPepoleType = info.getCheckInfoPepoleTypeEnum();
        boolean isTenant = mCheckinPepoleType == CheckinPepoleType.TENANT;

        initUi(isAdd, isTenant, info.isAffirm());

        mEdtTenantName.setText(info.getCheckInfoPepoleName());
        if (info.isSex()) {
            mRbtnSexMan.setChecked(true);
        } else {
            mRbtnSexWoman.setChecked(true);
        }
        mEdtTenantPhone.setText(info.getPhone());
        mEdtIdcard.setText(info.getCardNumber());
        mEdtRemark.setText(info.getRemark());

        mIdcardAdapter.setNewData(info.getCardImagePic());
        //自动显示删除按钮
        mIdcardAdapter.setAtuoShowDelete();
    }

    @Override
    public void updateCheckinPepoleInfoByPhone(TenantInfoBo info) {
        mEdtTenantName.setText(info.getCheckInfoPepoleName());
        if (info.isSex()) {
            mRbtnSexMan.setChecked(true);
        } else {
            mRbtnSexWoman.setChecked(true);
        }
        mEdtIdcard.setText(info.getCardNumber());
    }

    @Override
    public void finishUi() {
        finish();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        mPresenter.queryCheckinPepoleInfoByPosition(position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    /**
     * 根据是否为添加模式，设置界面状态
     *
     * @param isAdd
     */
    private void initUi(boolean isAdd, boolean isTenant, boolean isAffirm) {
        if (isAdd) {
            mToolbar.getMenu().findItem(R.id.item_add_tenant).setVisible(false);
            mTabLayout.setVisibility(View.GONE);
            mTvAffirmStatus.setVisibility(View.GONE);

            setUiEnabled(isTenant, true);
        } else {
            mToolbar.getMenu().findItem(R.id.item_add_tenant).setVisible(true);
            mTabLayout.setVisibility(View.VISIBLE);
            mTvAffirmStatus.setVisibility(View.VISIBLE);

            setUiEnabled(isTenant, false);
        }
        //ok按钮文字，确认状态
        setStatusWithIsAffirm(isAffirm);
    }

    /**
     * 设置UI输入可用
     *
     * @param isTenant
     * @param enabled
     */
    private void setUiEnabled(boolean isTenant, boolean enabled) {

        //承租人信息不可修改，入住人可修改身份证图片、备注

        //承租人不显示底部按钮
        int visibility = isTenant ? View.GONE : View.VISIBLE;
        mLayoutRemark.setVisibility(visibility);
        mBtnOk.setVisibility(visibility);

        if (isTenant) {
            mEdtTenantPhone.setEnabled(false);
            mEdtTenantName.setEnabled(false);
            mRbtnSexMan.setEnabled(false);
            mRbtnSexWoman.setEnabled(false);
            mEdtIdcard.setEnabled(false);
            mEdtRemark.setEnabled(false);
            mBtnOk.setEnabled(false);
        } else {
            //添加的时候手机号才可输入
            mEdtTenantPhone.setEnabled(enabled && isAdd);
            mEdtTenantName.setEnabled(false);
            mRbtnSexMan.setEnabled(false);
            mRbtnSexWoman.setEnabled(false);
            mEdtIdcard.setEnabled(false);
            mRvIdcardPic.setEnabled(enabled);
            mEdtRemark.setEnabled(enabled);
            mBtnOk.setEnabled(true);
            //添加图片添加按钮
            if (enabled) {
                mIdcardAdapter.addAddedPic();
                mIdcardAdapter.setAtuoShowDelete();
            }

        }
    }

    /**
     * 根据是否确认设置按钮状态
     *
     * @param isAffirm
     */
    private void setStatusWithIsAffirm(boolean isAffirm) {
        this.isAffirm = isAffirm;
        this.isSave = false;
        if (isAdd) {
            mBtnOk.setText("提交");
        } else {
            if (isAffirm) {
                mTvAffirmStatus.setText("已确认");
                mTvAffirmStatus.setTextColor(getResources().getColor(R.color.primary_highlight));
                mBtnOk.setText("编辑");
            } else {
                mTvAffirmStatus.setText("未确认");
                mTvAffirmStatus.setTextColor(getResources().getColor(R.color.text_remind));
                mBtnOk.setText("已提交");
            }
        }
    }

    /**
     * 初始化身份证Adapter
     */
    private void initIdcardAdapter() {
        mIdcardAdapter = new UploadIdcardPicAdapter();
        mRvIdcardPic.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRvIdcardPic.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.HORIZONTAL, 0xffffffff, DensityUtil.dp2px(20)));
        mIdcardAdapter.bindToRecyclerView(mRvIdcardPic);
    }

}
