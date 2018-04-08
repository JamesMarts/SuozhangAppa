package com.yiqi.lottery.feature.find.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.logger.Logger;
import com.yiqi.lottery.R;

import com.luck.picture.lib.config.PictureConfig;
import com.yiqi.lottery.common.widget.util.FullyGridLayoutManager;
import com.yiqi.lottery.feature.find.view.adapter.GridImageAdapter;
import  com.luck.picture.lib.PictureSelector;
import  com.luck.picture.lib.config.PictureMimeType;
import java.util.ArrayList;
import java.util.List;
import com.luck.picture.lib.entity.LocalMedia;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteCircleActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycler)
    RecyclerView mRvImg;
    private GridImageAdapter adapter;

    LinearLayout mLlCommentCategory;
    private int themeId;

    private int maxSelectNum = 5;// 图片最大可选数量
    private List<com.luck.picture.lib.entity.LocalMedia> selectList = new ArrayList<>();

    List<String> file = new ArrayList<>();
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_share_circle;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mToolbar.inflateMenu(R.menu.menu_find_circle_write);
        initToolBar(mToolbar, "晒单圈", true, true);
        mToolbar.setOnMenuItemClickListener(this);
    }


    @Override
    protected void initData() {
        initImgSelector();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cieclr_write:
                finish();
                break;
        }
        return true;
    }

   private void initImgSelector(){
       themeId = R.style.picture_default_style1;
       FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
       mRvImg.setLayoutManager(manager);
       adapter = new GridImageAdapter(this, onAddPicClickListener);
       adapter.setList(selectList);
       adapter.setSelectMax(maxSelectNum);
       mRvImg.setAdapter(adapter);
       adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position, View v) {
               if (selectList.size() > 0) {
                   int mediaType = 1;
                   switch (mediaType) {
                       case 1:
                           // 预览图片 可自定长按保存路径
                           com.luck.picture.lib.PictureSelector.create(WriteCircleActivity.this).externalPicturePreview(position, selectList);
                           break;

                   }
               }
           }
       });

   }

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener=new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
// 进入相册 以下是例子：用不到的api可以不写
         PictureSelector.create(WriteCircleActivity.this)
                    .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .theme(themeId)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                    .maxSelectNum(5)// 最大图片选择数量 int
                    .minSelectNum(1)// 最小选择数量 int
                    .imageSpanCount(4)// 每行显示个数 int
                    .selectionMode(com.luck.picture.lib.config.PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                    .previewImage(true)// 是否可预览图片 true or false
                    .isCamera(true)// 是否显示拍照按钮 true or false
                    .imageFormat(PictureMimeType.JPEG)// 拍照保存图片格式后缀,默认jpeg
                    .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                    .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                    .compress(true)// 是否压缩 true or false
                    .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                    .isGif(false)// 是否显示gif图片 true or false
                    .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                    .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                    .minimumCompressSize(100)// 小于100kb的图片不压缩
                    .synOrAsy(true)//同步true或异步false 压缩 默认同步
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                // 图片选择结果回调
                selectList = PictureSelector.obtainMultipleResult(data);
                // 例如 LocalMedia 里面返回三种path
                // 1.media.getPath(); 为原图path
                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                adapter.setList(selectList);
                adapter.notifyDataSetChanged();
                Logger.e("onActivityResult:" + selectList.size());
                if (selectList != null && selectList.size() > 0) {
                    for (LocalMedia localMedia : selectList) {
                        file.add(localMedia.getCompressPath());
                    }
                }
                break;
        }
    }
}
