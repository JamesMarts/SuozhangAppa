package com.yiqi.lottery.framework;

import java.util.ArrayList;
import java.util.List;

public class DataServer {
    public static final String AD_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523353714&di=ea3dcd1aa540348238be88655742e575&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.bitauto.com%2Fdealer%2Fnews%2F100045116%2F3ded33f3-7f50-4883-9c33-ccddbbbc694b.jpg";

    public static final String WIN = "http://img.zgzcw.com/zgzcw/matchCenter/team/images/20150127164537.jpg";
    public static final String DEFEAT = "http://img.zgzcw.com/zgzcw/matchCenter/team/images/20160728021003.jpg";


    public static List<String> getBannerData() {
        List<String> strings = new ArrayList<>();
        strings.add("http://img.500.com/upimages/ad/201804/20180402170924_1353.jpg");
        strings.add("http://img.500.com/upimages/ad/201804/20180403143107_3413.jpg");
        strings.add("http://img.500.com/upimages/sfc/201803/20180313151900_4909.jpg");
        strings.add("http://public.zgzcw.com/d/images/2018221517555242416_788.jpg");
        strings.add("http://public.zgzcw.com/d/images/2018431522718720789_715.jpg");
        return strings;
    }

    public static  List<String> getMsgData(){

        List<String> info = new ArrayList<>();
        info.add("信息：恭喜[刘德华]投注双色球中奖5.0元");
        info.add("信息：恭喜[渣渣辉]投注双色球中奖20.0元");
        info.add("信息：恭喜[古天乐]投注双色球中奖300.0元");
        info.add("信息：恭喜[陈小春]投注双色球中奖20.0元");
        info.add("信息：恭喜[周吉伦]投注双色球中奖10.0元");
        return info;
    }
}
