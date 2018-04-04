/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.common.util;

import android.app.Activity;

import com.suozhang.rentaluser.entity.bo.BannerBo;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/3/30 13:44
 */
public class ADUtils {

    /**
     * 初始化广告轮播页
     * */
    public static  void initAd(Activity activity, Banner banner,List<BannerBo> imgArrayBeen) {
//        String[] urls = activity.getResources().getStringArray(R.array.url);
//        String[] tips = activity.getResources().getStringArray(R.array.title);
        List<String> images =new ArrayList<>();
        List<String> titles = new ArrayList<>();

        for (BannerBo bean: imgArrayBeen) {
            images.add(bean.getImageUrl());
            titles.add("");
        }

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

}
