package com.suozhang.rentaluser.common.util;

import android.content.Context;

import com.suozhang.framework.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/10/31 13:09
 */
public class HistoryUtil {

    public  static  final String HISTORY_KEY="history";
    /**
     * 读取历史纪录
     * @param context
     * @param historyKey
     * @return
     */
    public static List<String> readHistory(Context context, String historyKey){
        String history = (String) SPUtil.get(context, historyKey, "");
        String[] histroys = history.split(";");
        List<String> list = new ArrayList<String>();
        if(histroys.length > 0){
            for (int i = 0; i < histroys.length; i++) {
                if(histroys[i] != null && histroys[i].length()>0){
                    list.add(histroys[i]);
                }
            }
        }
        return list;
    }

    /**
     * 插入历史纪录
     * @param context
     * @param historyKey
     * @param value
     */
    public static void insertHistory(Context context, String historyKey, String value) {
        String history = (String) SPUtil.get(context, historyKey, "");
        int historyLength = (int) SPUtil.get(context, historyKey + "Length", -1);
        boolean repeat = false;
        if (history != null && history.length() > 0) {
            String[] historys = history.split(";");
            for (int i = 0; i < historys.length; i++) {
                if (historys[i].equals(value)) {
                    repeat = true;
                }
            }
            if (repeat) {
                return;
            }else{
                if (historyLength == -1){
                    if (historys.length < 3) {
                        SPUtil.put(context, historyKey, value + ";" + history);
                    }else{
                        SPUtil.put(context, historyKey, value + ";" + history.substring(0, history.lastIndexOf(";")));
                    }
                }else{
                    if (historys.length < historyLength) {
                        SPUtil.put(context, historyKey, value + ";" + history);
                    }else{
                        SPUtil.put(context, historyKey, value + ";" + history.substring(0, history.lastIndexOf(";")));
                    }
                }
            }
        } else {
            SPUtil.put(context, historyKey, value);
        }
    }

    /**
     * 设置历史记录长度
     * @param context
     * @param historyKey
     * @param length
     */
    public static void setHistoryLength(Context context, String historyKey, int length){
        SPUtil.put(context,historyKey + "Length", length);
    }

    /**
     * 清除历史纪录
     * **/

    public static void clearHistory(Context context, String historyKey){
        SPUtil.clearByKey(context,historyKey);
    }
}
