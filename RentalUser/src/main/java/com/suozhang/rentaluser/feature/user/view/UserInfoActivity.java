package com.suozhang.rentaluser.feature.user.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.suozhang.framework.component.image.GlideCircleTransform;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.widget.UpLoadDialog;
import com.suozhang.rentaluser.common.widget.datepicker.SelectDateDialog;
import com.suozhang.rentaluser.entity.bo.UserInfoBo;
import com.suozhang.rentaluser.feature.user.contract.UserInfoContract;
import com.suozhang.rentaluser.feature.user.dependencies.userinfo.DaggerUserInfoComponent;
import com.suozhang.rentaluser.feature.user.dependencies.userinfo.UserInfoPresenterModule;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInfoActivity extends BaseActivity implements UserInfoContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_user_head_portrait)
    ImageView mIvUserHeadPortrait;
    @BindView(R.id.tv_user_head_nickname)
    TextView mTvUserHeadNickname;
    @BindView(R.id.tv_user_head_gender)
    TextView mTvUserHeadGender;
    @BindView(R.id.tv_user_birthday)
    TextView mTvUserBirthday;
    @BindView(R.id.btn_user_head_birthday)
    RelativeLayout mBtnUserHeadBirthday;
    @BindView(R.id.tv_user_star)
    TextView mTvUserStar;

    private UpLoadDialog mUpLoadDialog;
    private UpLoadDialog mGenderDialog;
    private SelectDateDialog mDateDialog;
    private String birthday = "";
    private List<LocalMedia> selectList;
    @Inject
    UserInfoContract.Presenter mPresenter;
    private String uri;
    private String mName, mStar;
    AlertDialog.Builder alert;
    String[] items = new String[]{"白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座", "水瓶座", "双鱼座"};

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initInjector() {
        DaggerUserInfoComponent.builder().userInfoPresenterModule(new UserInfoPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        mPresenter.getUserInfo();
    }


    @Override
    protected void initView() {
        initToolBar(mToolbar, "个人信息", true, true);
        mUpLoadDialog = new UpLoadDialog(this, "拍照", "从相册选择");
        mGenderDialog = new UpLoadDialog(this, "男", "女");
        mDateDialog = new SelectDateDialog(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @OnClick({R.id.btn_user_head_portrait, R.id.btn_user_nickname, R.id.btn_user_head_gender, R.id.btn_user_head_birthday, R.id.btn_user_star})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_user_head_portrait:
                mUpLoadDialog.show();
                mUpLoadDialog.setListener(new UpLoadDialog.MyClickListenerInterface() {
                    @Override
                    public void doCarema() {
                        PictureSelector.create(UserInfoActivity.this)
                                .openCamera(PictureMimeType.ofImage())
                                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选
                                .previewImage(true)// 是否可预览图片
                                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                                .enableCrop(true)// 是否裁剪
                                .compress(true)// 是否压缩
                                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示
                                .isGif(false)// 是否显示gif图片
                                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                                .circleDimmedLayer(true)// 是否圆形裁剪
                                .selectionMedia(selectList)// 是否传入已选图片
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    }

                    @Override
                    public void doGallery() {
                        PictureSelector.create(UserInfoActivity.this)
                                .openGallery(PictureMimeType.ofImage())
                                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选
                                .previewImage(true)// 是否可预览图片
                                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                                .isCamera(false)
                                .enableCrop(true)// 是否裁剪
                                .compress(true)// 是否压缩
                                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示
                                .isGif(false)// 是否显示gif图片
                                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                                .circleDimmedLayer(true)// 是否圆形裁剪
                                .selectionMedia(selectList)// 是否传入已选图片
                                .scaleEnabled(true)
                                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                    }
                });
                break;
            case R.id.btn_user_nickname:
                Intent intent = new Intent(this, EditNickNameActivity.class);
                intent.putExtra("name", mName);
                startActivity(intent);
                break;
            case R.id.btn_user_head_gender:
                mGenderDialog.show();
                mGenderDialog.setListener(new UpLoadDialog.MyClickListenerInterface() {
                    @Override
                    public void doCarema() {
                        mPresenter.doEditGender(true);
                    }

                    @Override
                    public void doGallery() {
                        mPresenter.doEditGender(false);
                    }
                });
                break;
            case R.id.btn_user_head_birthday:
                mDateDialog.show(Gravity.BOTTOM);

                mDateDialog.setOnScrollListener(new SelectDateDialog.OnScrollListener() {
                    @Override
                    public void onScroll(String date, int year, int month,
                                         int dayOfMonth) {
                        Logger.e("date--->" + date);
                        birthday = date;
                    }
                });


                final RelativeLayout btncancle = (RelativeLayout) mDateDialog.findViewById(R.id.txt_date_cancle);
                btncancle.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        birthday = "";
                        mDateDialog.dismiss();
                    }
                });

                RelativeLayout button = (RelativeLayout) mDateDialog.findViewById(R.id.txt_date_conform);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (!TextUtils.isEmpty(birthday)) {
                            mPresenter.editBirthday(birthday);
                        }

                        mDateDialog.dismiss();
                    }
                });
                break;
            case R.id.btn_user_star:

                if (!TextUtils.isEmpty(mStar)){
                    int positon = Arrays.binarySearch(items, mStar);

                    singleChoice(view,positon);

                }else {
                    singleChoice(view,0);
                }

                break;
        }
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void showUserInfo(UserInfoBo userInfoBo) {
        if (userInfoBo != null) {
            mStar = userInfoBo.getConstellation();
            mName = userInfoBo.getNickName();
            mTvUserBirthday.setText(userInfoBo.getBirthdayFormat());
            mTvUserHeadGender.setText(userInfoBo.isSex() ? "男" : "女");
            mTvUserStar.setText(TextUtils.isEmpty(userInfoBo.getConstellation()) ? "" : userInfoBo.getConstellation());
            mTvUserHeadNickname.setText(userInfoBo.getNickName());

            if (userInfoBo.isSex()) {
                Glide.with(this)
                        .load(userInfoBo.getIcon())
                        .apply(new RequestOptions().clone()
                                .transform(new GlideCircleTransform(this))
                                .error(R.drawable.ic_head_portrait_man)
                                .diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(mIvUserHeadPortrait);

            } else {
                Glide.with(this)
                        .load(userInfoBo.getIcon())
                        .apply(new RequestOptions().clone()
                                .transform(new GlideCircleTransform(this))
                                .error(R.drawable.ic_head_portrait_woman)
                                .diskCacheStrategy(DiskCacheStrategy.ALL))
                        .into(mIvUserHeadPortrait);

            }
        }
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showEditBirthdaySuccess(String msg) {
        T.showShort("修改成功！");
        initData();
        if (mGenderDialog != null && mGenderDialog.isShowing()) {
            mGenderDialog.dismiss();
        }
    }

    @Override
    public void showEditBirthdayErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showUploadSuccess(String msg) {
        T.showShort("上传成功！");
        initData();
    }

    @Override
    public void showUploadError(String msg) {
        T.showShort(msg);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.e("requestCode = " + requestCode + " resultCode " + resultCode + " data = " + data);
        if (mUpLoadDialog != null && mUpLoadDialog.isShowing()) {
            mUpLoadDialog.dismiss();
        }
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调

                    selectList = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < selectList.size(); i++) {
                        uri = selectList.get(i).getCompressPath();
                        Logger.e("uri--》" + uri);
                    }

                    File file = new File(uri);
                    if (file != null) {
                        mPresenter.updateUserIcon(1, file);
                    }
                    break;
            }
        }
    }

    /*单选列表项对话框：builder.setSingleChoiceItems()设置内容，内容参数可以是数组，Cursor，ListAdapter*/
    public void singleChoice(View v,int pos) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择星座");
        builder.setIcon(R.drawable.ic_lanuchar);
        //设置单选列表项，默认选中第二项
        builder.setSingleChoiceItems(items, pos, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                mStar = items[which];
            }

        });
        setPositiveButton(builder);
        builder = setNegativeButton(builder);

        AlertDialog simplechoicedialog = builder.create();
        simplechoicedialog.show();
    }

    //返回对象是原来的Builder对象
    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        // TODO Auto-generated method stub
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!TextUtils.isEmpty(mStar)) {
                    mPresenter.editStar(mStar);
                }
            }

        });
    }

    //返回对象是Builder对象
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        // TODO Auto-generated method stub
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });
    }

}
