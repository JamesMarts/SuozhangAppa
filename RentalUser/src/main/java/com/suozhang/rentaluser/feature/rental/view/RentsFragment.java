package com.suozhang.rentaluser.feature.rental.view;

import android.Manifest;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.framework.utils.SPUtil;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.ADUtils;
import com.suozhang.rentaluser.common.widget.citypicker.CityPickerActivity;
import com.suozhang.rentaluser.entity.bo.BannerBo;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.enums.SearchType;
import com.suozhang.rentaluser.feature.rental.contract.BannerContract;
import com.suozhang.rentaluser.feature.rental.dependencies.banner.BannerPresenterModule;
import com.suozhang.rentaluser.feature.rental.dependencies.banner.DaggerBannerComponent;
import com.suozhang.rentaluser.feature.rental.view.adapter.RentalAdapter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.youth.banner.Banner;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.suozhang.rentaluser.framework.Config.KEY_AREA_ID;

public class RentsFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener,
        BaseQuickAdapter.RequestLoadMoreListener, AMapLocationListener, BannerContract.View, OnRefreshListener {


    @BindView(R.id.btn_rents_search)
    LinearLayout mBtnRentsSearch;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.rv_guess_you_like)
    RecyclerView mRvGuessYouLike;
    RentalAdapter mAdapter;
    @BindView(R.id.tv_location_city)
    TextView mTvLocationCity;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    public AMapLocationClient mlocationClient;
    public AMapLocationClientOption mLocationOption = null;
    @BindView(R.id.smartRefesh)
    SmartRefreshLayout mSmartRefesh;
    Unbinder unbinder;
    private EmptyView mEmptyView;
    private BaseBo mAreaParam = null;

    private AMapLocation mAMapLocation;

    @Inject
    BannerContract.Presenter mPresenter;
    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;
    List<HouseRoomBo> mHouseData;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_rents;
    }

    @Override
    protected void initInjector() {
        DaggerBannerComponent.builder().bannerPresenterModule(new BannerPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        initAdapter();
        mPresenter.doGetBannerList();
        initRoomData();
    }

    @Override
    protected void initEvent() {
        mSmartRefesh.setOnRefreshListener(this);

    }


    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();


    }

    private void initRoomData() {
        try {
            mAreaParam = (BaseBo) SPUtil.readObj(getActivity(), KEY_AREA_ID);
            if (mAreaParam == null) {
                checkPrmiessionLocation();
            } else {
                mPresenter.doGetLikeHouse(mAreaParam.getId());
                if (!TextUtils.isEmpty(mAreaParam.getName())) {
                    String cName = mAreaParam.getName().replaceAll("市", "");
                    initTextView(cName);
                    mTvLocationCity.setText(cName);
                }
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    private void initAdapter() {
        mSmartRefesh.setEnableLoadMore(false);
        mAdapter = new RentalAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        mRvGuessYouLike.setHasFixedSize(true);
        mRvGuessYouLike.setLayoutManager(linearLayoutManager);
        mRvGuessYouLike.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mAdapter.bindToRecyclerView(mRvGuessYouLike);
        mEmptyView = new EmptyView(mRvGuessYouLike);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnLoadMoreListener(this, mRvGuessYouLike);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(getActivity(), HouseActivity.class);
        intent.putExtra("id", mHouseData.get(position).getId());
        startActivity(intent);
    }


    @Override
    public void onLoadMoreRequested() {
        mAdapter.loadMoreEnd();
    }


    @OnClick(R.id.tv_location_city)
    public void onViewLocationClicked() {
        //启动
        startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                REQUEST_CODE_PICK_CITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                BaseBo city = (BaseBo) data.getSerializableExtra(CityPickerActivity.KEY_PICKED_CITY);
                String cityName = city.getName();

                if (city != null && !TextUtils.isEmpty(cityName)) {
                    SPUtil.saveObj(getActivity(), KEY_AREA_ID, city);
                    mPresenter.getCityId(cityName);
                }
            }
        }
    }


    private void initLocation() {
        mlocationClient = new AMapLocationClient(getActivity());
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(this);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mlocationClient.setLocationOption(mLocationOption);
        mlocationClient.startLocation();

    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        // T.showShort("执行定位！");
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                mAMapLocation = amapLocation;
//                LocalData.getInstance().saveLocationInfo(amapLocation);
                SPUtil.saveObj(getActivity(), "location", amapLocation);
                String city = amapLocation.getCity();
                city = city.replace("市", "");
                if (!TextUtils.isEmpty(city)) {
                    mPresenter.getCityId(city);
                }
            }
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
        }

    }

    private void checkPrmiessionLocation() {
        RxPermissions rxPermissions = new RxPermissions(getActivity());
        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        initLocation();
                    } else {
                        // At least one permission is denied
                    }
                });


    }


    @OnClick({R.id.btn_rents_search, R.id.btn_whole_rent, R.id.btn_joint_rent, R.id.btn_near_rent, R.id.btn_map_rent, R.id.btn_rent_like_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rents_search:
                if (mAreaParam != null) {
                    if (!TextUtils.isEmpty(mAreaParam.getId())) {
                        Intent intent = new Intent(getActivity(), SearchActivity.class);
                        intent.putExtra("areaId", mAreaParam.getId());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.btn_whole_rent:
                if (mAreaParam != null) {
                    if (!TextUtils.isEmpty(mAreaParam.getId())) {
                        Intent intent = new Intent(getActivity(), RentalListActivity.class);
                        intent.putExtra("rentType", SearchType.ZHENG.type);
                        intent.putExtra("areaId", mAreaParam.getId());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.btn_joint_rent:
                if (mAreaParam != null) {
                    if (!TextUtils.isEmpty(mAreaParam.getId())) {
                        Intent intent = new Intent(getActivity(), RentalListActivity.class);
                        intent.putExtra("rentType", SearchType.FENG.type);
                        intent.putExtra("areaId", mAreaParam.getId());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.btn_near_rent:
                if (mAreaParam != null) {
                    if (!TextUtils.isEmpty(mAreaParam.getId())) {
                        Intent intent = new Intent(getActivity(), RentalListActivity.class);
                        intent.putExtra("rentType", SearchType.NEAR.type);
                        intent.putExtra("areaId", mAreaParam.getId());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.btn_map_rent:
                if (mAreaParam != null && !TextUtils.isEmpty(mAreaParam.getId())) {
                    Intent intent = new Intent(getActivity(), RentMapActivity.class);
                    intent.putExtra("areaId", mAreaParam.getId());
                    //  intent.putExtra("location", mAMapLocation);
                    startActivity(intent);
                }
                break;
            case R.id.btn_rent_like_more:
                // startActivity(new Intent(getActivity(), RentalListActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void showSuccess(List<BannerBo> bannerBos) {
        mSmartRefesh.finishRefresh();
        if (mBanner != null && bannerBos != null) {
            ADUtils.initAd(getActivity(), mBanner, bannerBos);
        }

    }

    @Override
    public void showErrorMsg(String msg) {
        mSmartRefesh.finishRefresh();
        T.showShort(msg);
    }

    @Override
    public void showAreaSuccess(BaseBo baseBo) {
        mSmartRefesh.finishRefresh();
        mAreaParam = baseBo;
        SPUtil.saveObj(getActivity(), KEY_AREA_ID, mAreaParam);
        if (mAreaParam != null && !TextUtils.isEmpty(mAreaParam.getId())) {
            String cName = mAreaParam.getName().replaceAll("市", "");
            initTextView(cName);
            mTvLocationCity.setText(cName);
            mPresenter.doGetLikeHouse(mAreaParam.getId());
        }

    }

    @Override
    public void showAreaErrorMsg(String msg) {
        mSmartRefesh.finishRefresh();
    }

    @Override
    public void showLikeHouseSuccess(List<HouseRoomBo> baseBo) {
        mHouseData = baseBo;
        mAdapter.setNewData(mHouseData);
        if (mSmartRefesh != null) mSmartRefesh.finishRefresh();
    }

    @Override
    public void showLikeHouseEmpty() {
        mAdapter.setNewData(null);
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无数据!"));
        mSmartRefesh.finishRefresh();
    }

    @Override
    public void showLikeHouseError(String msg) {
        mSmartRefesh.finishRefresh();
        mAdapter.setNewData(null);
        mAdapter.setEmptyView(mEmptyView.getErrorView(msg));

    }

    private void initTextView(String cityStr) {
        if (TextUtils.isEmpty(cityStr)) {
            return;
        }
        if (cityStr.length() == 2) {
            mTvLocationCity.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        } else if (cityStr.length() == 3) {
            mTvLocationCity.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        } else if (cityStr.length() >= 4) {
            mTvLocationCity.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initRoomData();
        initData();
    }


}
