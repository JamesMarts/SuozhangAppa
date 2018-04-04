package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.MyRoomBo;
import com.suozhang.rentaluser.entity.bo.RoomConfigBo;
import com.suozhang.rentaluser.feature.life.contract.MyRoomContract;
import com.suozhang.rentaluser.feature.life.dependencies.room.DaggerMyRoomComponent;
import com.suozhang.rentaluser.feature.life.dependencies.room.MyRoomPresenterModule;
import com.suozhang.rentaluser.feature.rental.view.adapter.RoomConfigurationAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MyRoomActivity extends BaseActivity implements MyRoomContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv_room_configuration)
    RecyclerView mRvRoomConfiguration;

    @Inject
    MyRoomContract.Presenter mPresenter;
    @BindView(R.id.tv_myroom_type)
    TextView mTvMyroomType;
    @BindView(R.id.tv_myroom_area)
    TextView mTvMyroomArea;
    @BindView(R.id.tv_myroom_toward)
    TextView mTvMyroomToward;
    @BindView(R.id.tv_myroom_floor)
    TextView mTvMyroomFloor;
    @BindView(R.id.tv_myroom_features)
    TextView mTvMyroomFeatures;
    private MyRoomBo myRoomBo;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_room;
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "我的房子", true, true);
    }

    @Override
    protected void initInjector() {
        DaggerMyRoomComponent.builder().myRoomPresenterModule(new MyRoomPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        mPresenter.getMyRoomInfo();
    }

    private void initConfigurationData(List<RoomConfigBo> roomConfigBo) {
        RoomConfigurationAdapter adapter = new RoomConfigurationAdapter();
        LinearLayoutManager ms = new LinearLayoutManager(this);
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvRoomConfiguration.setLayoutManager(ms);
        adapter.setNewData(roomConfigBo);
        mRvRoomConfiguration.setAdapter(adapter);
    }


    @Override
    public void showSuccess(MyRoomBo roomBo) {
        if (roomBo == null) return;
        myRoomBo = roomBo;
        initConfigurationData(roomBo.getRoomConfig());
        mTvMyroomType.setText(roomBo.getRoomTypeName());
        mTvMyroomArea.setText(roomBo.getAcreage() + "㎡");
        mTvMyroomFeatures.setText(roomBo.getFeature());
        mTvMyroomFloor.setText(roomBo.getFloor() + "");
        mTvMyroomToward.setText(roomBo.getOrientationName());
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
        finish();
    }

    @OnClick(R.id.btn_live_people)
    public void onViewClicked() {
        Intent intent = new Intent(this, LivePeopleActivity.class);
        intent.putExtra("contractId", myRoomBo.getId());
        startActivity(intent);

    }
}