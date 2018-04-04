package com.suozhang.rentaluser.common.lib;

import com.amap.api.location.AMapLocation;
import com.suozhang.framework.framework.AM;
import com.suozhang.framework.utils.SPUtil;

/**
 * @author Li
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/12/19 10:00
 */
public class LocalData {
    /**
     * 保存用户信息时使用的SharedPreferences文件名
     */
    private static final String FILE_NAME = "data_info";

    // 登录结果信息,用于在SharedPreferences中保存或获取用户信息的key
    private static final String LOCATION_INFO = "LOCATION_INFO";


    private AMapLocation aMapLocation;

    private static final Object lock = new Object();

    public static LocalData instance;

    private LocalData() {
    }

    public static LocalData getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new LocalData();
                }
            }
        }
        return instance;
    }


    public void saveLocationInfo(AMapLocation info) {
        //保存到内存
        aMapLocation = info;
        //保存到本地
        if (info != null) {
            SPUtil.saveObj(AM.app(), FILE_NAME, LOCATION_INFO, info);
        } else {
            SPUtil.clearByKey(AM.app(), FILE_NAME, LOCATION_INFO);
        }
    }

    /**
     * 获取登录结果，首先从内存中获取，内存中没有从磁盘缓存中取
     *
     * @return
     */
    public AMapLocation getLocationInfo() {

        if (aMapLocation == null) {
            try {
                aMapLocation = (AMapLocation) SPUtil.readObj(AM.app(), FILE_NAME, LOCATION_INFO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aMapLocation;
    }

}
