package com.suozhang.rentaluser.feature.rental.view;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.HistoryUtil;
import com.suozhang.rentaluser.entity.bo.BaseBo;
import com.suozhang.rentaluser.entity.enums.SearchType;
import com.suozhang.rentaluser.feature.rental.view.adapter.HistorySearchAdapter;
import com.suozhang.rentaluser.feature.rental.view.adapter.HotSearchAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

import static com.suozhang.rentaluser.common.util.HistoryUtil.HISTORY_KEY;

public class SearchActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.edt_serach_text)
    EditText mEdtSerachText;
    @BindView(R.id.rv_hot_search)
    RecyclerView mRvHotSearch;
    @BindView(R.id.rv_history_search)
    RecyclerView mRvHistorySearch;
    @BindView(R.id.tv_history_none)
    TextView mTvHistoryNone;
    private HotSearchAdapter mHotSearchAdapter;
    private HistorySearchAdapter mHistorySearchAdapter;
    List<String> historys;
    private String mAreaId = "";

    private String mKeyWord="";


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_search;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void onStart() {
        super.onStart();
         historys = HistoryUtil.readHistory(this, HISTORY_KEY);
        if (historys != null && historys.size() > 0) {
            mHistorySearchAdapter.setNewData(historys);
            mTvHistoryNone.setVisibility(View.GONE);
            mRvHistorySearch.setVisibility(View.VISIBLE);
        } else {
            mTvHistoryNone.setVisibility(View.VISIBLE);
            mRvHistorySearch.setVisibility(View.GONE);
        }


    }

    @Override
    protected void initView() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                InputMethodManager inputManager = (InputMethodManager) mEdtSerachText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(mEdtSerachText, 0);
            }

        }, 200);
    }

    @Override
    protected void initData() {
        mAreaId=this.getIntent().getStringExtra("areaId");
        mKeyWord=this.getIntent().getStringExtra("keyword");
        mEdtSerachText.setText(mKeyWord);
        initHotAdapter();
        HistoryUtil.setHistoryLength(this, HISTORY_KEY, 10);

    }


    @OnClick(R.id.btn_serach_back)
    public void onViewClicked() {
        String text = mEdtSerachText.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            HistoryUtil.insertHistory(this, HISTORY_KEY, text);
        }
        Intent intent = new Intent(this, RentalListActivity.class);
        intent.putExtra("rentType", SearchType.KEYWORD.type);
        intent.putExtra("keyword", text);
        intent.putExtra("areaId", mAreaId);
        startActivity(intent);
        finish();
    }

    private void initHotAdapter() {
        mHotSearchAdapter = new HotSearchAdapter();
        mRvHotSearch.setLayoutManager(new GridLayoutManager(this, 4));
        mHotSearchAdapter.bindToRecyclerView(mRvHotSearch);
        mHotSearchAdapter.setNewData(getHotData());
       // mHotSearchAdapter.setOnItemClickListener(this);

        mHistorySearchAdapter = new HistorySearchAdapter();
        mRvHistorySearch.setLayoutManager(new GridLayoutManager(this, 4));
        mHistorySearchAdapter.bindToRecyclerView(mRvHistorySearch);
        mHistorySearchAdapter.setOnItemClickListener(this);
    }


    @OnClick(R.id.btn_history_clear)
    public void onViewClearClicked() {

        List<String> historys = HistoryUtil.readHistory(this, HISTORY_KEY);
        if (historys != null && historys.size() > 0) {
            HistoryUtil.clearHistory(this, HISTORY_KEY);
            SystemClock.sleep(500);
            T.showShort("清除成功！");
            onStart();
        }

    }

    private List<BaseBo> getHotData() {
        List<BaseBo> baseBos = new ArrayList<>();
        baseBos.add(new BaseBo("福田"));
        baseBos.add(new BaseBo("市民中心"));
        baseBos.add(new BaseBo("科技园"));
        baseBos.add(new BaseBo("西乡"));
        baseBos.add(new BaseBo("龙华"));
        baseBos.add(new BaseBo("白石洲"));
        baseBos.add(new BaseBo("桃园"));
        return baseBos;
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Intent intent = new Intent(this, RentalListActivity.class);
        intent.putExtra("rentType", SearchType.KEYWORD.type);
        intent.putExtra("keyword",historys.get(position));
        intent.putExtra("areaId", mAreaId);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.bt_back)
    public void onViewBackClicked() {
        finish();
    }
}
