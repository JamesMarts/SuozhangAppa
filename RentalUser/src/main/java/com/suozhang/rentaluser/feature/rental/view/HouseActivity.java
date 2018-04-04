package com.suozhang.rentaluser.feature.rental.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.EmptyView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.GlideImageLoader;
import com.suozhang.rentaluser.common.widget.CommonDialog;
import com.suozhang.rentaluser.entity.bo.RentInfoBo;
import com.suozhang.rentaluser.entity.bo.RoomConfigBo;
import com.suozhang.rentaluser.feature.login.view.LoginActivity;
import com.suozhang.rentaluser.feature.rental.contract.HouseContract;
import com.suozhang.rentaluser.feature.rental.dependencies.house.DaggerHouseComponent;
import com.suozhang.rentaluser.feature.rental.dependencies.house.HousePresenterModule;
import com.suozhang.rentaluser.feature.rental.view.adapter.RentalAdapter;
import com.suozhang.rentaluser.feature.rental.view.adapter.RoomConfigurationAdapter;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class HouseActivity extends BaseActivity implements HouseContract.View, UMShareListener, AMap.OnInfoWindowClickListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.tv_house_name)
    TextView mTvHouseName;
    @BindView(R.id.bt_back)
    ImageView mBtBack;
    @BindView(R.id.title_bar)
    RelativeLayout mTitleBar;
    @BindView(R.id.map_house)
    MapView mMapHouse;
    @BindView(R.id.tv_house_info_name)
    TextView mTvHouseInfoName;
    @BindView(R.id.tv_house_info_area)
    TextView mTvHouseInfoArea;
    @BindView(R.id.tv_house_info_rent_type)
    TextView mTvHouseInfoRentType;
    @BindView(R.id.tv_house_info_price)
    TextView mTvHouseInfoPrice;
    @BindView(R.id.tv_house_info_address)
    TextView mTvHouseInfoAddress;
    @BindView(R.id.tv_house_info_type)
    TextView mTvHouseInfoType;
    @BindView(R.id.tv_house_info_area_m2)
    TextView mTvHouseInfoAreaM2;
    @BindView(R.id.tv_house_info_toward)
    TextView mTvHouseInfoToward;
    @BindView(R.id.tv_house_info_floor)
    TextView mTvHouseInfoFloor;
    @BindView(R.id.rv_room_configuration)
    RecyclerView mRvRoomConfiguration;
    @BindView(R.id.tv_room_info_desc)
    TextView mTvRoomInfoDesc;
    @BindView(R.id.rv_room_near)
    RecyclerView mRvRoomNear;
    @BindView(R.id.cbx_house_collection)
    CheckBox mCbxHouseCollection;
    private MarkerOptions markerOption;
    private AMap aMap;
    private RentalAdapter mAdapter;
    private RentInfoBo mData = null;
    private String mHouseId = "";
    private EmptyView mEmptyView,mEmptyView2;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_room;
    }

    @Inject
    HouseContract.Presenter mPresenter;

    @Override
    protected void initInjector() {
        DaggerHouseComponent.builder().housePresenterModule(new HousePresenterModule(this)).build().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapHouse.onCreate(savedInstanceState);
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mHouseId = this.getIntent().getStringExtra("id");
        if (!TextUtils.isEmpty(mHouseId)) {
            mPresenter.doGetRentInfo(mHouseId);
        }

        initNearAdapter();
    }

    @Override
    protected void initEvent() {
        mCbxHouseCollection.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //当按钮被按下时会触发此listener
                if(!compoundButton.isPressed())return;
                if (AM.user().isLogin()) {
                    if (isChecked) {
                        mPresenter.collectionHouse(mHouseId);
                    } else {
                        mPresenter.cancleCollectionHouse(mHouseId);
                    }
                } else {
                    Intent intent = new Intent(HouseActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void showSuccess(RentInfoBo rentInfoBo) {
        mData = rentInfoBo;

        initHouseInfo(mData);

    }

    private void initHouseInfo(RentInfoBo rentInfoBo) {
        if (rentInfoBo == null) {
            return;
        }
        mTvHouseName.setText(TextUtils.isEmpty(rentInfoBo.getName()) ? "" : rentInfoBo.getName());
        mTvHouseInfoName.setText("[" + rentInfoBo.getArea() + "]\t\t" + (TextUtils.isEmpty(rentInfoBo.getDescription()) ? "" : rentInfoBo.getDescription()));
        mTvHouseInfoAddress.setText(TextUtils.isEmpty(rentInfoBo.getAddress()) ? "" : rentInfoBo.getAddress());
        mTvHouseInfoPrice.setText((int) rentInfoBo.getRentMoney() + "");
        mTvHouseInfoArea.setText((TextUtils.isEmpty(rentInfoBo.getRoomTypeName()) ? "户型未知" : rentInfoBo.getRoomTypeName()) + "\t|\t" + rentInfoBo.getAcreage() + "平米");
        mTvHouseInfoRentType.setText((rentInfoBo.isRentType() ? "整租" : "分租"));
        mTvHouseInfoAreaM2.setText(rentInfoBo.getAcreage() + "㎡");
        mTvHouseInfoFloor.setText(rentInfoBo.getFloor() + "层");
        mTvHouseInfoToward.setText(TextUtils.isEmpty(rentInfoBo.getOrientationName()) ? "未知" : "朝" + rentInfoBo.getOrientationName());
        mTvHouseInfoType.setText(TextUtils.isEmpty(rentInfoBo.getRoomTypeName()) ? "未知" : rentInfoBo.getRoomTypeName());
        mTvRoomInfoDesc.setText(TextUtils.isEmpty(rentInfoBo.getIntroduction()) ? "房东太懒了，什么也没留下！" : Html.fromHtml(rentInfoBo.getIntroduction()));
        initBanner(rentInfoBo.getRoomImage());
        initConfigurationData(rentInfoBo.getRoomConfig());
        addMarkersToMap(new LatLng(rentInfoBo.getLatitude(), rentInfoBo.getLongitude()), rentInfoBo.getName());

        if (AM.user().isLogin()) {
            if (rentInfoBo.isIsCollection()) {
                mCbxHouseCollection.setChecked(true);
            } else {
                mCbxHouseCollection.setChecked(false);
            }
        }
    }

    private void initConfigurationData(List<RoomConfigBo> roomConfigBo) {
        RoomConfigurationAdapter adapter = new RoomConfigurationAdapter();
        LinearLayoutManager ms = new LinearLayoutManager(this);
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvRoomConfiguration.setLayoutManager(ms);
        adapter.bindToRecyclerView(mRvRoomConfiguration);
        mEmptyView2 = new EmptyView(mRvRoomConfiguration);
        if (roomConfigBo.size()>0){
            adapter.setNewData(roomConfigBo);
        }else {

            //adapter.setNewData(null);
           // adapter.setEmptyView(mEmptyView2.getEmptyView("此房间暂无配置!"));
        }

    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showCollectionSuccess(String msg) {
        T.showShort("已收藏！");
        //  mCbxHouseCollection.setChecked(true);
    }

    @Override
    public void showCollectionSuccessError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showCancleCollectionSuccess(String msg) {
        // mCbxHouseCollection.setChecked(false);
        T.showShort("已取消！");
    }

    @Override
    public void showCancleCollectionError(String msg) {
        T.showShort(msg);
    }

    private void initBanner(List<RentInfoBo.RoomImageBo> roomImage) {
        if (roomImage == null) {
            return;
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < roomImage.size(); i++) {
            strings.add(roomImage.get(i).getUrl());
        }
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置自动轮播，默认为true
        //设置图片集合
        mBanner.setImages(strings);
        mBanner.isAutoPlay(false);
        mBanner.start();
    }


    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }


    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    @OnClick(R.id.bt_back)
    public void onViewBackClicked() {
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initPopup() {

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.popup_house_more, null);

        final PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);


        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
        int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                - popupWindow.getWidth() / 2;
        popupWindow.showAsDropDown(findViewById(R.id.btn_house_more), xPos, 0);

        (view.findViewById(R.id.btn_popup_report)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HouseActivity.this, ReportRentActivity.class);
                intent.putExtra("id", mHouseId);
                startActivity(intent);
                popupWindow.dismiss();

            }
        });
        (view.findViewById(R.id.btn_popup_share)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new ShareAction(HouseActivity.this)
                            .withText("hello")
                            .setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE)
                            .setCallback(HouseActivity.this)
                            .open();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.btn_house_more)
    public void onViewMoreClicked() {
        initPopup();
    }


    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap(LatLng latlng, String name) {
        aMap = mMapHouse.getMap();
        aMap.getUiSettings().setAllGesturesEnabled(false);
        aMap.getUiSettings().setZoomControlsEnabled(false);
        aMap.setOnInfoWindowClickListener(this);
        aMap.moveCamera(CameraUpdateFactory.zoomTo(16));
        aMap.moveCamera(CameraUpdateFactory.changeLatLng(latlng));
        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                .fromResource(R.drawable.start_center_point))
                .position(latlng)
               // .snippet(name)
                //.title("")
                .draggable(false)
        ;
        Marker marker = aMap.addMarker(markerOption);
        marker.showInfoWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapHouse.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapHouse.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapHouse.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapHouse.onSaveInstanceState(outState);
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        T.showShort(marker.getSnippet());
    }

    private void initNearAdapter() {
        mAdapter = new RentalAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvRoomNear.setLayoutManager(linearLayoutManager);
        mRvRoomNear.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
        mAdapter.bindToRecyclerView(mRvRoomNear);
        mEmptyView = new EmptyView(mRvRoomNear);
        mAdapter.setNewData(null);
        mAdapter.setEmptyView(mEmptyView.getEmptyView("暂无数据!"));
        mAdapter.setOnLoadMoreListener(this, mRvRoomNear);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {
        mAdapter.loadMoreEnd();
    }

    @OnClick(R.id.btn_connect)
    public void onViewClicked() {
        if (mData!=null){
            callPhone(mData.getPhone());
        }

    }

    private void callPhone(final String phone) {

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.CALL_PHONE)
                .subscribe(granted -> {
                    if (granted) {
                        if (!TextUtils.isEmpty(phone)) {
                            final CommonDialog mDialog = new CommonDialog(HouseActivity.this, "拔打房东电话：" + phone);
                            mDialog.show();

                            mDialog.setListener(new CommonDialog.MyClickListenerInterface() {
                                @Override
                                public void doConfirm() {
                                    callToPhone(phone);
                                    mDialog.dismiss();
                                }
                            });
                        }
                    } else {
                        // At least one permission is denied
                    }
                });

    }


    public void callToPhone(String phone) {
        if (!TextUtils.isEmpty(phone)) {

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            T.showShort("手机号不能为空！");
            return;
        }

    }



}
