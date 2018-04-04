package com.yiqi.lottery.feature.lottery.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.suozhang.framework.component.recyclerview.DividerItemDecoration;
import com.suozhang.framework.framework.BaseFragment;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.logger.Logger;
import com.yiqi.lottery.R;
import com.yiqi.lottery.feature.lottery.view.adapter.HomeAdapter;
import com.yiqi.lottery.feature.lottery.view.adapter.MultipleItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class LotteryFragment extends BaseFragment {
    HomeAdapter mHomeAdapter = null;

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    public int attachLayoutRes() {
        return R.layout.fragment_lottery;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        //rvHome.addItemDecoration(new DividerItemDecoration(DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initData() {
        List<MultipleItem> list = new ArrayList<>();
        list.add(new MultipleItem(MultipleItem.ITEM_BANNER, MultipleItem.IMG_SPAN_SIZE));
        list.add(new MultipleItem(MultipleItem.ITEM_MSG, MultipleItem.IMG_SPAN_SIZE, "奥什市哦"));
        list.add(new MultipleItem(MultipleItem.ITEM_TYPE, MultipleItem.IMG_SPAN_SIZE));
        list.add(new MultipleItem(MultipleItem.ITEM_LUCKY_NUMBER, MultipleItem.IMG_SPAN_SIZE));
        list.add(new MultipleItem(MultipleItem.ITEM_WINNING_COLUMN, MultipleItem.IMG_SPAN_SIZE));
        list.add(new MultipleItem(MultipleItem.ITEM_FOCUS_EVENT, MultipleItem.IMG_SPAN_SIZE));
        mHomeAdapter = new HomeAdapter(list);
        rvHome.setAdapter(mHomeAdapter);
    }


    @Override
    public void onStart() {
        super.onStart();

        if (mHomeAdapter != null)
            mHomeAdapter.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

        if (mHomeAdapter != null)
            mHomeAdapter.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

        if (mHomeAdapter != null)
            mHomeAdapter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mHomeAdapter != null)
            mHomeAdapter.onStop();
    }

    @Override
    protected void initEvent() {

    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        T.showShort("Hidden");
    }


}
