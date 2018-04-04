package com.suozhang.rentaluser.feature.rental.view.dropdownmenu.view.doubleGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ScrollView;

import com.baiiu.filter.FilterBaseBo;
import com.baiiu.filter.adapter.SimpleTextAdapter;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.baiiu.filter.util.CommonUtil;
import com.baiiu.filter.util.UIUtil;
import com.baiiu.filter.view.FilterCheckedTextView;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity.FilterUrl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baiiu on 15/12/22.
 * 筛选器GridView
 */
public class DoubleGridView extends ScrollView implements View.OnClickListener {

    @BindView(R.id.grid_top)
    GridViewInScrollView mTopGrid;

    @BindView(R.id.grid_bottom)
    GridViewInScrollView mBottomGrid;

    @BindView(R.id.bt_confirm)
    Button bt_confirm;

    private SimpleTextAdapter<FilterBaseBo> mTopAdapter;
    private SimpleTextAdapter<FilterBaseBo> mBottomAdapter;

    private OnFilterDoneListener onFilterDoneListener;

    public DoubleGridView(Context context) {
        this(context, null);
    }

    public DoubleGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.merge_filter_third, this);
        setBackgroundResource(android.R.color.white);

        ButterKnife.bind(this, this);

        bt_confirm.setOnClickListener(this);

        initAdapter(context);

        mTopGrid.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mBottomGrid.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        mTopGrid.setAdapter(mTopAdapter);
        mBottomGrid.setAdapter(mBottomAdapter);
    }

    private void initAdapter(Context context) {

        mTopAdapter = new SimpleTextAdapter<FilterBaseBo>(null, context) {
            @Override
            public FilterBaseBo provideText(FilterBaseBo phase) {
                return phase;
            }

            @Override
            protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
                checkedTextView.setGravity(Gravity.CENTER);
                checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
            }
        };

        mBottomAdapter = new SimpleTextAdapter<FilterBaseBo>(null, context) {
            @Override
            public FilterBaseBo provideText(FilterBaseBo area) {
                return area;
            }

            @Override
            protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                checkedTextView.setPadding(0, UIUtil.dp(context, 3), 0, UIUtil.dp(context, 3));
                checkedTextView.setBackgroundResource(R.drawable.selector_filter_grid);
                checkedTextView.setGravity(Gravity.CENTER);
            }
        };

        mTopGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
    }

    public void setTopGridData(List<FilterBaseBo> list) {
        if (CommonUtil.isEmpty(list)) {
            return;
        }

        mTopAdapter.setList(list);
    }

    public void setBottomGridList(List<FilterBaseBo> list) {
        if (CommonUtil.isEmpty(list)) {
            return;
        }

        mBottomAdapter.setList(list);
    }

    @Override
    public void onClick(View v) {
        int topPosition = mTopGrid.getCheckedItemPosition();
        topPosition = topPosition == -1 ? 0 : topPosition;

        int bottomPosition = mBottomGrid.getCheckedItemPosition();
        bottomPosition = bottomPosition == -1 ? 0 : bottomPosition;

        FilterBaseBo financePhase = mTopAdapter.getItem(topPosition);
        FilterBaseBo area = mBottomAdapter.getItem(bottomPosition);

        FilterUrl.instance().doubleGridTop = financePhase;
        FilterUrl.instance().doubleGridBottom = area;

        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(3, "", "");
        }
    }

    public void setOnFilterDoneListener(OnFilterDoneListener listener) {
        onFilterDoneListener = listener;
    }
}