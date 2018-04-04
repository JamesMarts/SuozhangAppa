package com.suozhang.rentaluser.common.util;

import android.text.TextUtils;

import com.suozhang.rentaluser.entity.bo.PicBo;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/11/21 9:47
 */

public class UploadPicUtil {
    /**
     * 是否有Url类型的图片
     *
     * @param datas
     * @return
     */
    public static boolean hasUrlPic(List<PicBo> datas) {

        if (datas != null && !datas.isEmpty()) {
            Iterator<PicBo> it = datas.iterator();
            while (it.hasNext()) {
                PicBo oldPic = it.next();
                if (!oldPic.isAddBtn() && !TextUtils.isEmpty(oldPic.getUrl())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取Url图片包装数据
     *
     * @param urls
     * @param hasAddBtn
     * @return
     */
    public static List<PicBo> getPics(List<String> urls, boolean hasAddBtn) {
        List<PicBo> data = new ArrayList<>();
        if (hasAddBtn) {
            //第一个为添加按钮
            data.add(new PicBo(true));
        }
        if (urls == null || urls.isEmpty()) {
            return data;
        }
        for (String url : urls) {
            data.add(new PicBo(url));
        }
        return data;
    }

    /**
     * 获取文件图片数据
     *
     * @param pics
     * @return
     */
    public static List<PicBo> getPicFiles(List<PicBo> pics) {
        if (pics == null) {
            return null;
        }
        List<PicBo> files = new ArrayList<>();

        for (PicBo pic : pics) {
            File file = pic.getFile();
            if (!pic.isAddBtn() && file != null && file.exists() && file.isFile()) {
                files.add(pic);
            }
        }
        if (files.isEmpty()) {
            return null;
        }
        return files;
    }
}
