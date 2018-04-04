package com.yiqi.lottery.feature.lottery.view.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sunfusheng.marqueeview.MarqueeView;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.utils.T;
import com.yiqi.lottery.R;
import com.yiqi.lottery.common.widget.RoundImageView;
import com.yiqi.lottery.common.widget.banner.BannerView;
import com.yiqi.lottery.common.widget.banner.holder.HolderCreator;
import com.yiqi.lottery.common.widget.banner.holder.ViewHolder;
import com.yiqi.lottery.framework.DataServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GEILI on 2018/3/26.
 */

public class HomeAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    BannerView mBannerView;
    MarqueeView marqueeView;

    public HomeAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.ITEM_BANNER, R.layout.home_list_banner);
        addItemType(MultipleItem.ITEM_MSG, R.layout.home_list_msg);
        addItemType(MultipleItem.ITEM_TYPE, R.layout.home_list_type);
        addItemType(MultipleItem.ITEM_LUCKY_NUMBER, R.layout.home_list_lucky);
        addItemType(MultipleItem.ITEM_WINNING_COLUMN, R.layout.home_list_winning);
        addItemType(MultipleItem.ITEM_FOCUS_EVENT, R.layout.home_list_last);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.ITEM_BANNER:
                mBannerView = helper.getView(R.id.banner);
                setBannerData(mBannerView);
                break;
            case MultipleItem.ITEM_MSG:
                marqueeView = helper.getView(R.id.marqueeView);
                marqueeView.startWithList(DataServer.getMsgData());

                break;
            case MultipleItem.ITEM_TYPE:
                AM.image().bind(DataServer.AD_URL, helper.getView(R.id.iv_lottery_ad));
                helper.getView(R.id.btn_lottery_kaijiang).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_bifen).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_gendan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_zuqiu).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_lanqiu).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_shenfu).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_jinqiu).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_renxuan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                helper.getView(R.id.btn_lottery_liudian).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                break;
            case MultipleItem.ITEM_WINNING_COLUMN:
                AM.image().bindToCircleObject(DataServer.WIN, helper.getView(R.id.iv_lottery_focus_events_win));
                AM.image().bindToCircleObject(DataServer.DEFEAT, helper.getView(R.id.iv_lottery_focus_events_defeat));
                String time = "周日<font color=\"#D83200\">" + "16:02" + "</font>截至";
                helper.setText(R.id.tv_lottery_focus_events_time, Html.fromHtml(time));
                break;
        }
    }

    public void onStart() {

    }

    public void onResume() {
        if (mBannerView != null)
            mBannerView.start();
        if (marqueeView != null)
            marqueeView.startFlipping();

    }

    public void onPause() {
        if (mBannerView != null)
            mBannerView.pause();
        if (marqueeView != null)
            marqueeView.stopFlipping();
    }

    public void onStop() {

    }


    /**
     * 设置banner数据
     */
    private void setBannerData(BannerView mBannerView) {

        mBannerView.setIndicatorRes(R.drawable.dot_unselect_image, R.drawable.dot_select_image);
        mBannerView.setIndicatorVisible(true);

        mBannerView.setPages(DataServer.getBannerData(), new HolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mBannerView.start();

    }


    public static class BannerViewHolder implements ViewHolder<String> {
        private RoundImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            AM.image().bind(data, mImageView);

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    T.showShort("click!");
                }
            });
        }
    }

}
