package com.yiqi.lottery.feature.find.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.suozhang.framework.framework.BaseFragment;
import com.yiqi.lottery.R;


public class FindFragment extends BaseFragment {


    Unbinder unbinder;

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


    @OnClick({R.id.btn_find_order_circle, R.id.btn_find_score_live, R.id.btn_find_game_analysis, R.id.btn_find_lottery_results})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_find_order_circle:
                startActivity(new Intent(getActivity(), OrderShareCircleActivity.class));
                break;
            case R.id.btn_find_score_live:
                break;
            case R.id.btn_find_game_analysis:
                break;
            case R.id.btn_find_lottery_results:
                break;
        }
    }
}
