package com.suozhang.rentaluser.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/10/18 11:51
 */
public class DateUtil {


    /**
     * 获取过去或者未来 任意天内的日期数组
     * @param intervals      intervals天内
     * @return              日期数组
     */
    public static ArrayList<String> test(int intervals ) {
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i <intervals; i++) {
            fetureDaysList.add(getFetureDate(i));
        }
        return fetureDaysList;
    }



    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        String result = format.format(today);

        return result;
    }

    public static String getTimeStr(Date date) {
        String sdate = "";
        if (date==null){
            return "";
        }
        sdate = (new SimpleDateFormat("yyyy.MM.dd")).format(date);
        return sdate;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param
     * @return
     */
    public static String getHourByDate(Date date) {
        Calendar c = Calendar.getInstance();
        if (date == null) {
            return null;
        }
        c.setTime(date);
        String min = "";
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minus = c.get(Calendar.MINUTE);
        if (minus < 10) {
            min = "0" + minus;
        } else {
            min = minus + "";
        }
        return hour + ":" + min;
    }
    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

   public static boolean isToday(Date sdate) {
        boolean b = false;
        Date time = sdate;
        Date today = new Date();
        if (time != null) {
            String nowDate = dateFormater2.get().format(today);
            String timeDate = dateFormater2.get().format(time);
            if (nowDate.equals(timeDate)) {
                b = true;
            }
        }
        return b;
    }
}
