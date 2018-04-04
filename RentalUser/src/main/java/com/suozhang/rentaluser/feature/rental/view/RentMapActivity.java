package com.suozhang.rentaluser.feature.rental.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.HouseRoomBo;
import com.suozhang.rentaluser.entity.bo.RentParamsBo;
import com.suozhang.rentaluser.feature.rental.contract.RentContract;
import com.suozhang.rentaluser.feature.rental.dependencies.rent.DaggerRentComponent;
import com.suozhang.rentaluser.feature.rental.dependencies.rent.RentPresenterModule;
import com.suozhang.rentaluser.feature.rental.view.popup.PricePopup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class RentMapActivity extends BaseActivity implements AMapLocationListener, AMap.OnMarkerClickListener
        , AMap.OnInfoWindowClickListener, RentContract.View {


    @BindView(R.id.map)
    MapView mMapView;
    //初始化地图控制器对象
    AMap aMap;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MarkerOptions markerOption;

    //声明mlocationClient对象
    public AMapLocationClient mlocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    private Marker maker;
    RentParamsBo mRentParamsBo;

    List<HouseRoomBo> mData = null;

    private PricePopup mPopupWindow;

    @Inject
    RentContract.Presenter mPresenter;
    private String mAreaId;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_rent_map;
    }


    @Override
    protected void initInjector() {
        DaggerRentComponent.builder().rentPresenterModule(new RentPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, "地图选房");
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        initLocation();
        initPos();
    }

    @Override
    protected void initData() {
        mAreaId = this.getIntent().getStringExtra("areaId");
    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    private void initRentMap(AMapLocation aMapLocation) {
        mRentParamsBo = new RentParamsBo();
        mRentParamsBo.setAreaId(mAreaId);
        mRentParamsBo.setLatitude(aMapLocation.getLatitude());
        mRentParamsBo.setLongitude(aMapLocation.getLongitude());
        mPresenter.getHouseingResourseByFilter(mRentParamsBo);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    private void initLocation() {
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000);
        //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。

        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);
        float a = 0.0f;
        float b = 0.0f;
        myLocationStyle.anchor(a, b);
        myLocationStyle.showMyLocation(true);
        myLocationStyle.strokeColor(Color.parseColor("#90b1d4ff"));
        myLocationStyle.strokeWidth(2.0f);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory
                .fromResource(R.drawable.map_marker));// 设置小蓝点的图标
        myLocationStyle.radiusFillColor(Color.parseColor("#50b1d4ff"));
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.getUiSettings().setZoomControlsEnabled(false);
        aMap.setOnInfoWindowClickListener(this);
        aMap.moveCamera(CameraUpdateFactory.zoomTo(13));
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap(LatLng latlng) {

        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                .fromResource(R.drawable.start_center_point))
                .position(latlng)
                // .snippet("在这里找房")
                .draggable(false);
        maker = aMap.addMarker(markerOption);

        maker.showInfoWindow();
    }


    void getMarkers(List<HouseRoomBo> houseRoomBos) {
        for (int i = 0; i < houseRoomBos.size(); i++) {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(new LatLng(houseRoomBos.get(i).getLatitude(),
                    houseRoomBos.get(i).getLongitude()));
            markerOption.draggable(false);//设置Marker可拖动
            markerOption.title(String.valueOf(i));
            markerOption.icon(BitmapDescriptorFactory.fromView(getMyView(houseRoomBos.get(i).getRentMoney() + "元起")));
            aMap.addMarker(markerOption);
            aMap.setOnMarkerClickListener(this);
        }

//        return
    }

    protected View getMyView(String pm_val) {
        View view = this.getLayoutInflater().inflate(R.layout.map_title, null);
        TextView tv_val = (TextView) view.findViewById(R.id.marker_tv_val);
        tv_val.setText(pm_val);
        return view;
    }

    private void initPos() {

        mlocationClient = new AMapLocationClient(this);
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
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //aMap.setOnMarkerClickListener(this);
                // addMarkersToMap(new LatLng(amapLocation.getLatitude(), amapLocation.getLongitude()));
                // MapHelper.jumpPoint(maker, aMap);

                initRentMap(amapLocation);
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (aMap != null) {
            if (mPopupWindow != null) {
                mPopupWindow.dismiss();
                mPopupWindow = null;
            }
            initPopup(mData.get(Integer.valueOf(marker.getTitle())));
        }
        return true;
    }


    @Override
    public void onInfoWindowClick(Marker markers) {
        T.showShort("找房！");
    }


    @Override
    public void showSuccess(List<HouseRoomBo> houseRoomBos) {
        mData = houseRoomBos;
        if (mData != null && mData.size() > 0) {
            getMarkers(mData);
        }

    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort("showErrorMsg" + msg);
    }

    @Override
    public void showEmpty() {
        T.showShort("showEmpty");
    }

    private void initPopup(HouseRoomBo houseRoomBo) {
        mPopupWindow = new PricePopup(this, houseRoomBo, mRentParamsBo);

        mPopupWindow.showAtLocation(this.findViewById(R.id.bottom), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }


}
