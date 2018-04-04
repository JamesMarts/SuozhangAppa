package com.suozhang.rentaluser.feature.life.view;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.FullyGridLayoutManager;
import com.suozhang.rentaluser.feature.life.view.adapter.GridImageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RepairInfoActivity extends BaseActivity implements GridImageAdapter.OnItemClickListener, GridImageAdapter.onAddPicClickListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.btn_repair_type)
    TextView mBtnRepairType;
    @BindView(R.id.btn_repair_time)
    TextView mBtnRepairTime;
    private GridImageAdapter adapter;
    private List<LocalMedia> selectList = new ArrayList<>();
    public static final int CHOOSE_TYPE = 1001;
    public static final int CHOOSE_DATE = 1002;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_repair_info;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "报修详情", true, true);
    }

    @Override
    protected void initData() {
        initImageAdapter();
    }

    private void initImageAdapter() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 5, GridLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, this);
        adapter.setList(selectList);
        adapter.setSelectMax(5);
        mRecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(int position, View v) {
        if (selectList.size() > 0) {
            int mediaType = 1;
            switch (mediaType) {
                case 1:
                    PictureSelector.create(this).externalPicturePreview(position, selectList);
                    break;

            }
        }
    }

    @Override
    public void onAddPicClick() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)// 主题样式设置 具体参考 values/styles   用法：
                .maxSelectNum(5)// 最大图片选择数量
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(5)// 每行显示个数
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                .previewImage(true)// 是否可预览图片
                .isCamera(true)// 是否显示拍照按钮
                .compress(true)// 是否压缩
                .selectionMedia(selectList)// 是否传入已选图片
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                // 图片选择结果回调
                selectList = PictureSelector.obtainMultipleResult(data);
                adapter.setList(selectList);
                adapter.notifyDataSetChanged();
                Logger.e("onActivityResult:" + selectList.size());
                break;

            case CHOOSE_TYPE:
                if (data != null) {
                    String mType = data.getStringExtra("type");
                    mBtnRepairType.setText(TextUtils.isEmpty(mType) ? "" : mType);
                }

                break;

            case CHOOSE_DATE:
                if (data != null) {
                    String mDate = data.getStringExtra("date");
                    String mTime = data.getStringExtra("time");
                    mBtnRepairTime.setText(TextUtils.isEmpty(mDate) ? "" : mDate + "\t" + (TextUtils.isEmpty(mTime) ? "" : mTime));
                }
                break;
        }

    }


    @OnClick({R.id.btn_repair_type, R.id.btn_repair_time, R.id.btn_repair_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_repair_type:
                Intent intent = new Intent(this, SelectRepairTypeActivity.class);
                startActivityForResult(intent, CHOOSE_TYPE);
                break;
            case R.id.btn_repair_time:
                Intent intent2 = new Intent(this, ChooseRepairDateActivity.class);
                startActivityForResult(intent2, CHOOSE_DATE);
                break;
            case R.id.btn_repair_commit:
                break;
        }
    }


    @OnClick(R.id.btn_repair_commit)
    public void onViewClicked() {
    }
}
