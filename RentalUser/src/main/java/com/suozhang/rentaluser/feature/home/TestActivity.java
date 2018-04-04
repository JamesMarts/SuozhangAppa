package com.suozhang.rentaluser.feature.home;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.baiiu.filter.DropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.rental.view.dropdownmenu.entity.FilterUrl;

import butterknife.BindView;

public class TestActivity extends BaseActivity implements OnFilterDoneListener {

    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

    @BindView(R.id.mFilterContentView)
    TextView mFilterContentView;

    private void initFilterDropDownView() {
        String[] titleList = new String[]{"第一个", "第二个", "第三个", "第四个"};
       // dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
        mFilterContentView.setText(FilterUrl.instance().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FilterUrl.instance().clear();
    }

    @Override
    protected void initView() {
        super.initView();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFilterDropDownView();
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_test;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initData() {

    }
}