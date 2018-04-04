/*
 * Copyright (c) 2017. 深圳掌控网络科技有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.framework;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.utils.SPUtil;

/**
 * 全局配置
 *
 * @author Moodd
 * @e-mail 420410175@qq.com
 * @date 2017/3/27 13:46
 */

public class Config {


    public  static   String HotelId= (String) SPUtil.get(AM.app(),"hotelid","");

    public static final String ChainId = "f41a41c9-3319-42f4-aadd-3a1690fe304e";
    //    public static String HotelId = "8d27efbd-299c-4921-babf-31fe26b0b653";    //Online
//    public static String HotelId = "1f5dfd52-fda4-4292-9fd6-cf1b0d5d05a8";   //
    public static final String WxPayAppId = "wxfde91a9fce434565";

    public static final int CONTACT_NORMAL = 0;
    public static final int CONTACT_SELECT = 1;

    public static final String Dictionary_Comment = "CommentType";
    public static final String KEY_AREA_ID="area_id" ;
    public static final int PHONE_TYPE_REGISTER = 1;
    public static final int PHONE_TYPE_RESET = 2;
    public static final int PHONE_TYPE_REBIND = 3;
    public static final int PHONE_TYPE_WECHAT = 4;
    public static final int SERVER_TYPE_CLEAN = 1;
    public static final int SERVER_TYPE_WASH = 2;
    public static final int SERVER_TYPE_CHECK = 3;
}
