/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.common.widget.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.suozhang.rentaluser.R;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


/**
 * 选择日期Dialog
 *
 * @author liuzx
 * @since 2015-6-15 16:02:26
 */
public class SelectDateDialog extends Dialog implements OnWheelChangedListener, OnWheelScrollListener {

    private Context mContext;

    /**
     * 年的数据适配器
     */
    private DateAdapter yearDateAdapter;
    /**
     * 月的数据适配器
     */

    private DateAdapter monthDateAdapter;
    //	/** 日的数据适配器 */suiijsaguv usguqg yqgvwqgvuqi
    private DateAdapter dayDateAdapter;
    /**
     * 年滚动轴
     */
    private WheelView wv_select_date_year;
    /**
     * 月滚动轴
     */
    private WheelView wv_select_date_month;
    /**
     * 日滚动轴
     */
    private WheelView wv_select_date_day;
    /**
     * 最早的年份
     */
    private static int START_YEAR = 1900;
    /**
     * 最晚的年份：今年
     */
    private static int END_YEAR;
    /**
     * 当前月
     */
    private int currentMonth;
    /**
     * 当前日
     */
    private int currentDayOfMonth;
    /**
     * 年
     */
    private int year;
    /**
     * 月
     */
    private int month;
    /**
     * 一个月的第几天
     */
    private int dayOfMonth;
    /**
     * 大月
     */
    private List<String> listBig;
    /**
     * 小月
     */
    private List<String> listLittle;
    /**
     * 生日 格式 1990-10-10
     */
    private String birthday;

    private int mmonth;

    /**
     * @param ctx 上下文
     */
    public SelectDateDialog(Context ctx) {
        super(ctx, R.style.ListDialog);
        setCanceledOnTouchOutside(true);
        this.mContext = ctx;
    }

    /**
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_select_date);
        initDateTimePicker();

        wv_select_date_year.addChangingListener(this);
        wv_select_date_month.addChangingListener(this);
        wv_select_date_day.addChangingListener(this);

        wv_select_date_year.addScrollingListener(this);
        wv_select_date_month.addScrollingListener(this);
        wv_select_date_day.addScrollingListener(this);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        if (onScrollListener != null) {
            birthday = year + "-" + month + "-" + dayOfMonth;
            onScrollListener.onScroll(birthday, year, month, dayOfMonth);
        }
    }

    /**
     * 初始化日期时间选择器
     */
    public void initDateTimePicker() {
        Calendar calendar = Calendar.getInstance();
        END_YEAR = year = calendar.get(Calendar.YEAR);
        mmonth = calendar.get(Calendar.MONTH) + 1;
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//
//		SharedPreferences sp = YongLeApplication.getInstance().spUserInfo;
//		String currentDate = sp.getString(YongLeApplication.CURRENT_DATE, "1990-1-1");
//		String[] dates = currentDate.split("-");

        String[] dates = {END_YEAR + "", mmonth + "", dayOfMonth + ""};
        END_YEAR = year = Integer.valueOf(dates[0]);
        currentMonth = month = Integer.valueOf(dates[1]);
        currentDayOfMonth = dayOfMonth = Integer.valueOf(dates[2]);

        if (!TextUtils.isEmpty(birthday)) {// 如果生日不为空
            String[] birthdays = birthday.split("-");
            try {
                year = Integer.valueOf(birthdays[0]);
                month = Integer.valueOf(birthdays[1]);
                dayOfMonth = Integer.valueOf(birthdays[2]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String[] monthsBig = {"1", "3", "5", "7", "8", "10", "12"};
        String[] monthsLittle = {"4", "6", "9", "11"};

        listBig = Arrays.asList(monthsBig);
        listLittle = Arrays.asList(monthsLittle);

        // 年
        wv_select_date_year = (WheelView) findViewById(R.id.wv_select_date_year);
        wv_select_date_year.setCyclic(false);// 可循环滚动
        yearDateAdapter = new DateAdapter(1, START_YEAR, END_YEAR);
        wv_select_date_year.setViewAdapter(yearDateAdapter);// 设置"年"的显示数据
        wv_select_date_year.setCurrentItem(year - START_YEAR);// 初始化时显示的数据
        yearDateAdapter.updateSelectIndex(year - START_YEAR);

        // 月
        wv_select_date_month = (WheelView) findViewById(R.id.wv_select_date_month);
        monthDateAdapter = new DateAdapter(2, 1, 12);
        wv_select_date_month.setCyclic(false);
        wv_select_date_month.setViewAdapter(monthDateAdapter);
        wv_select_date_month.setCurrentItem(month - 1);
        monthDateAdapter.updateSelectIndex(month - 1);

        // 日
        wv_select_date_day = (WheelView) findViewById(R.id.wv_select_date_day);
        wv_select_date_day.setCyclic(false);
        dayDateAdapter = new DateAdapter(3, 1, 31);
        wv_select_date_day.setViewAdapter(dayDateAdapter);
        // 判断大小月及是否闰年,用来确定"日"的数据
        if (listBig.contains(String.valueOf(month))) {
            dayDateAdapter.updateMax(31);
        } else if (listLittle.contains(String.valueOf(month))) {
            dayDateAdapter.updateMax(30);
        } else {
            // 闰年
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                dayDateAdapter.updateMax(29);
            } else {
                dayDateAdapter.updateMax(28);
            }
        }
        wv_select_date_day.setCurrentItem(dayOfMonth - 1);
        dayDateAdapter.updateSelectIndex(dayOfMonth - 1);

        RelativeLayout mConfirmView = (RelativeLayout) findViewById(R.id.txt_date_conform);
        RelativeLayout mCancelView = (RelativeLayout) findViewById(R.id.txt_date_cancle);
        mCancelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }

        });

        mConfirmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


    }

    public interface onChangeListener {
        public void onConfirm(String date, int year, int month, int dayOfMonth);
    }


    public void show(int gravity) {
        getWindow().setGravity(gravity);
        show();
    }

    /**
     * (non-Javadoc)
     *
     * @see int, int)
     * <p>
     * 当前值改变后执行的方法
     */
    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        switch (wheel.getId()) {
            case R.id.wv_select_date_year:
                yearChanged(newValue);
                break;
            case R.id.wv_select_date_month:
                monthChanged(newValue);
                break;
            case R.id.wv_select_date_day:
                dayChanged(newValue);
                break;
        }
    }

    /**
     * 年份改变
     *
     * @param newValue
     */
    private void yearChanged(int newValue) {
        int year_num = newValue + START_YEAR;
        // 判断大小月及是否闰年,用来确定"日"的数据
        if (listBig.contains(String.valueOf(wv_select_date_month.getCurrentItem() + 1))) {
            dayDateAdapter.updateMax(31);
        } else if (listLittle.contains(String.valueOf(wv_select_date_month.getCurrentItem() + 1))) {
            dayDateAdapter.updateMax(30);
            if (wv_select_date_day.getCurrentItem() > 29) {
                wv_select_date_day.setCurrentItem(29);
                dayDateAdapter.updateSelectIndex(29);
            }
        } else {
            if ((year_num % 4 == 0 && year_num % 100 != 0) || year_num % 400 == 0) {
                dayDateAdapter.updateMax(29);
                if (wv_select_date_day.getCurrentItem() > 28) {
                    wv_select_date_day.setCurrentItem(28);
                    dayDateAdapter.updateSelectIndex(28);
                }
            } else {
                dayDateAdapter.updateMax(28);
                if (wv_select_date_day.getCurrentItem() > 27) {
                    wv_select_date_day.setCurrentItem(27);
                    dayDateAdapter.updateSelectIndex(27);
                }
            }
        }

    }

    /**
     * 月份改变
     *
     * @param newValue
     */
    private void monthChanged(int newValue) {
        int month_num = newValue + 1;
        // 判断大小月及是否闰年,用来确定"日"的数据
        if (listBig.contains(String.valueOf(month_num))) {
            dayDateAdapter.updateMax(31);

        } else if (listLittle.contains(String.valueOf(month_num))) {
            dayDateAdapter.updateMax(30);
            if (wv_select_date_day.getCurrentItem() > 29) {// 从大月滑到小月，大月选中的是31日，小月没有选中30日
                wv_select_date_day.setCurrentItem(29);
                dayDateAdapter.updateSelectIndex(29);
            }
        } else {
            if (((wv_select_date_year.getCurrentItem() + START_YEAR) % 4 == 0 && (wv_select_date_year.getCurrentItem() + START_YEAR) % 100 != 0)
                    || (wv_select_date_year.getCurrentItem() + START_YEAR) % 400 == 0) {
                dayDateAdapter.updateMax(29);
                if (wv_select_date_day.getCurrentItem() > 28) {
                    wv_select_date_day.setCurrentItem(28);
                    dayDateAdapter.updateSelectIndex(28);
                }

            } else {
                dayDateAdapter.updateMax(28);
                if (wv_select_date_day.getCurrentItem() > 27) {
                    wv_select_date_day.setCurrentItem(27);
                    dayDateAdapter.updateSelectIndex(27);
                }
            }
        }

    }

    /**
     * 日改变
     *
     * @param newValue
     */
    private void dayChanged(int newValue) {
        // do something...
    }

    @Override
    public void onScrollingStarted(WheelView wheel) {

    }

    /**
     * (non-Javadoc)
     *
     * @see
     */
    @Override
    public void onScrollingFinished(WheelView wheel) {
        switch (wheel.getId()) {
            case R.id.wv_select_date_year:
                yearDateAdapter.updateSelectIndex(wv_select_date_year.getCurrentItem());
                year = (Integer) yearDateAdapter.getItem(wv_select_date_year.getCurrentItem());
                break;

            case R.id.wv_select_date_month:
                monthDateAdapter.updateSelectIndex(wv_select_date_month.getCurrentItem());
                month = (Integer) monthDateAdapter.getItem(wv_select_date_month.getCurrentItem());
                break;

            case R.id.wv_select_date_day:
                dayDateAdapter.updateSelectIndex(wv_select_date_day.getCurrentItem());
                break;
        }
        dayOfMonth = (Integer) dayDateAdapter.getItem(wv_select_date_day.getCurrentItem());

        if (END_YEAR == year && month > currentMonth) {// 月不能超过当前日期
            wv_select_date_month.setCurrentItem(currentMonth - 1);
            monthDateAdapter.updateSelectIndex(currentMonth - 1);
            month = currentMonth;
        }
        if (END_YEAR == year && month >= currentMonth && dayOfMonth > currentDayOfMonth) {// 日不能超过当前日期
            wv_select_date_day.setCurrentItem(currentDayOfMonth - 1);
            dayDateAdapter.updateSelectIndex(currentDayOfMonth - 1);
            dayOfMonth = currentDayOfMonth;
        }

        if (onScrollListener != null) {
            onScrollListener.onScroll(year + "-" + month + "-" + dayOfMonth, year, month, dayOfMonth);
        }
    }

    private OnScrollListener onScrollListener;

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public interface OnScrollListener {
        public void onScroll(String date, int year, int month, int dayOfMonth);
    }

    class DateAdapter extends BaseAdapter implements WheelViewAdapter {

        /**
         * 类型：1年，2月，3日
         */
        private int type;
        /**
         * 最小值
         */
        private int minValue;
        /**
         * 最大值
         */
        private int maxValue;
        /**
         * 选中项
         */
        private int selectIndex;

        public DateAdapter(int type, int minValue, int maxValue) {
            this.type = type;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        /**
         * 更新最大值， 用于更新大月跟小月的最大天数
         *
         * @param maxValue 最大天数
         */
        public void updateMax(int maxValue) {
            this.maxValue = maxValue;
            notifyDataSetChanged();
        }

        /**
         * 更新选中项
         *
         * @param selectIndex 选中项
         */
        public void updateSelectIndex(int selectIndex) {
            this.selectIndex = selectIndex;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return maxValue - minValue + 1;
        }

        @Override
        public Object getItem(int position) {
            return minValue + position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemsCount() {
            return maxValue - minValue + 1;
        }

        @Override
        public View getItem(int index, View convertView, ViewGroup parent) {
            return getView(index, convertView, parent);
        }

        @Override
        public View getEmptyItem(View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(mContext, R.layout.address_item, null);
                holder.date = (TextView) convertView.findViewById(R.id.address);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            if (type == 1) {
                holder.date.setText(minValue + position + "年");
            } else if (type == 2) {
                holder.date.setText(minValue + position + "月");
            } else if (type == 3) {
                holder.date.setText(minValue + position + "日");
            }

            if (selectIndex == position) {
                holder.date.setTextColor(mContext.getResources().getColor(R.color.text_primary));
            } else {
                holder.date.setTextColor(mContext.getResources().getColor(R.color.text_secondary));
            }

            return convertView;
        }

    }

    class ViewHolder {
        /**
         * 时间
         */
        TextView date;
    }

}
