package com.suozhang.rentaluser.feature.rental.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.baiiu.filter.DropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.SPUtil;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;
import com.suozhang.rentaluser.entity.enums.SearchType;
import com.suozhang.rentaluser.feature.rental.contract.RentContract;
import com.suozhang.rentaluser.feature.rental.dependencies.rent.DaggerRentComponent;
import com.suozhang.rentaluser.feature.rental.dependencies.rent.RentPresenterModule;
import com.suozhang.rentaluser.feature.rental.view.adapter.RentalAdapter2;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.DropMenuAdapter;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity.FilterUrl;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class RentalListActivity extends BaseActivity implements RentContract.View,
        BaseQuickAdapter.OnItemClickListener, OnRefreshListener, OnFilterDoneListener {

    RentalAdapter2 mAdapter = null;
    @BindView(R.id.bt_back)
    ImageView mBtBack;
    @BindView(R.id.edt_serach_text)
    EditText mEdtSerachText;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.mFilterContentView)
    RecyclerView mRvBookingRoomType;
    @BindView(R.id.smartRefesh)
    SmartRefreshLayout mSmartRefesh;
    AMapLocation aMapLocation = null;
    private EmptyView mEmptyView;
    @Inject
    RentContract.Presenter mPresenter;
    RentParamsBo rentParamsBo = null;
    private String mAreaId = "";
    private String mKeyword = "";
    private List<HouseRoomBo> mHouseData = null;
    private int rentType;
    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_rental_list;
    }

    @Override
    protected void initInjector() {
        DaggerRentComponent.builder().rentPresenterModule(new RentPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        super.initView();

        mSmartRefesh.setEnableRefresh(false);
        initFilterDropDownView();
        initAdapter();
    }

    @Override
    protected void initData() {
        aMapLocation = (AMapLocation) SPUtil.readObj(this, "location");
        mAreaId = this.getIntent().getStringExtra("areaId");
        rentType = this.getIntent().getIntExtra("rentType", SearchType.UND.type);
        mKeyword = this.getIntent().getStringExtra("keyword");
        mEdtSerachText.setText(mKeyword);
        initSearch(rentType, mAreaId);

    }


    private void initSearch(int type, String areaId) {
        rentParamsBo = new RentParamsBo();
        if (TextUtils.isEmpty(areaId)) {
            return;

        }
        switch (type) {
            case 0://整租
                rentParamsBo.setRentType(true);
                break;
            case 1://分租
                rentParamsBo.setRentType(false);
                break;
            case 2://周边
                if (aMapLocation != null) {
                    rentParamsBo.setLatitude(aMapLocation.getLatitude());
                    rentParamsBo.setLongitude(aMapLocation.getLongitude());
                }
            case 3://模糊条件搜索
                if (!TextUtils.isEmpty(mKeyword))
                    rentParamsBo.setName(mKeyword);
                break;
        }

        rentParamsBo.setAreaId(areaId);
        mPresenter.getHouseingResourseByFilter(rentParamsBo);
    }

    @Override
    protected void initEvent() {
        mSmartRefesh.setOnRefreshListener(this);
    }

    @Override
    public void showSuccess(List<HouseRoomBo> houseRoomBos) {
        mSmartRefesh.finishRefresh();
        mHouseData = houseRoomBos;
        mAdapter.setNewData(mHouseData);
    }

    @Override
    public void showErrorMsg(String msg) {
        mSmartRefesh.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView(msg));
        mAdapter.setNewData(null);
    }

    @Override
    public void showEmpty() {
        mSmartRefesh.finishRefresh();
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无匹配房间!"));
        mAdapter.setNewData(null);
    }


    private void initAdapter() {
        mSmartRefesh.setEnableLoadMore(false);
        mAdapter = new RentalAdapter2();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvBookingRoomType.setLayoutManager(linearLayoutManager);
//        mRvBookingRoomType.addItemDecoration(new RecycleViewDivider(
//                this, LinearLayoutManager.VERTICAL, 40, getResources().getColor(R.color.window_background)));
        mAdapter.bindToRecyclerView(mRvBookingRoomType);
        mEmptyView = new EmptyView(mRvBookingRoomType);
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(this, HouseActivity.class);
        intent.putExtra("id", mHouseData.get(position).getId());
        startActivity(intent);
    }


    @OnClick(R.id.bt_back)
    public void onViewClicked() {
        finish();
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rentParamsBo = null;
        FilterUrl.instance().clear();
    }

    @OnClick(R.id.edt_serach_text)
    public void onSearchViewClicked() {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("areaId", mAreaId);
        intent.putExtra("keyword",mEdtSerachText.getText().toString());
        startActivity(intent);
        finish();

    }


    private void initFilterDropDownView() {
        String[] titleList = new String[]{"区域", "租金", "户型", "更多"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {

        Logger.e("选择的数据-------------->"+FilterUrl.instance().toString());
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
        if (FilterUrl.instance().singleGridPosition != null) {
            rentParamsBo.setRoomTypeId(FilterUrl.instance().singleGridPosition.getId());
        }

        if (FilterUrl.instance().doubleGridTop != null) {
            if (FilterUrl.instance().doubleGridTop.getId().equals("0")) {
                rentParamsBo.setRentType(true);
            } else {
                rentParamsBo.setRentType(false);
            }

        }else {
            rentParamsBo.setRentType(true);
        }

        if (FilterUrl.instance().doubleGridBottom != null) {
            rentParamsBo.setOrientationId(FilterUrl.instance().doubleGridBottom.getId());
        }else {
            rentParamsBo.setOrientationId(null);
        }

        if (FilterUrl.instance().singleListPosition != null) {
            if (!TextUtils.isEmpty(FilterUrl.instance().singleListPosition.getId())) {
                String[] data = FilterUrl.instance().singleListPosition.getId().split(",");
                if (!TextUtils.isEmpty(data[0])) {
                    rentParamsBo.setMinRentMoney(Double.valueOf(data[0]));
                }
                if (!TextUtils.isEmpty(data[1])) {
                    rentParamsBo.setMaxRentMoney(Double.valueOf(data[1]));
                }
            }else {
                rentParamsBo.setMaxRentMoney(null);
                rentParamsBo.setMinRentMoney(null);
            }
        }


        if (FilterUrl.instance().doubleListRight!=null){
            if (!TextUtils.isEmpty(FilterUrl.instance().doubleListRight.getId())){
                rentParamsBo.setQuyuId(FilterUrl.instance().doubleListRight.getId());
            }else {
                rentParamsBo.setQuyuId(null);
            }
        }

        mPresenter.getHouseingResourseByFilter(rentParamsBo);

    }


}
