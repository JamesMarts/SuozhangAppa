package com.suozhang.rentaluser.feature.find;


import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.home.view.HomeActivity;
import com.suozhang.rentaluser.feature.rental.view.RentalListActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class FindFragment extends BaseFragment {


    @BindView(R.id.tv_location)
    TextView mTvLocation;
    @BindView(R.id.bt_map_zoom)
    ImageView mBtMapZoom;
    private HomeActivity homeActivity;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
        homeActivity.setHandler(handler);
    }


    @Override
    protected void initView() {

    }

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }


    @OnClick(R.id.bt_map_zoom)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), RentalListActivity.class));
    }


}

