package com.suozhang.rentaluser.feature.user.view;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.suozhang.framework.component.http.RxDataProcessFactory;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.SuggestionBo;
import com.suozhang.rentaluser.feature.user.dependencies.DaggerUserCenterCommonApiComponent;
import com.suozhang.rentaluser.framework.api.ApiLib;
import com.suozhang.rentaluser.framework.api.UserApi;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import io.reactivex.annotations.NonNull;

/**
 * @author moodd
 * @email 420410175@qq.com
 * @date 2017/9/14 11:17
 */

public class FeedbackActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.edt_feedback)
    EditText mEdtFeedback;
    @BindView(R.id.tv_count)
    TextView mTvCount;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;

    @Inject
    UserApi api;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initInjector() {
        DaggerUserCenterCommonApiComponent.builder().apiComponent(ApiLib.apiComponent()).build().inject(this);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar(mToolbar, R.string.title_feedback, true, true);
    }

    @Override
    protected void initData() {

    }

    @OnTextChanged(R.id.edt_feedback)
    public void textChanged(CharSequence s, int start, int before, int count) {
        mTvCount.setText(s.length() + "/200");
    }

    @OnClick(R.id.btn_submit)
    public void onViewClicked() {
        String content = mEdtFeedback.getText().toString().trim();

        if (TextUtils.isEmpty(content) || content.length() < 10 || content.length() > 200) {
            showErrorMsg("请输入10-200个字符");
            return;
        }
        //请求接口
        api.suggestionSubmit(new SuggestionBo(content))
                .compose(RxDataProcessFactory.<String>dataPrepAndIoToMainTransformer())
                .compose(this.<String>bindToLife())
                .subscribe(new RxDataProcessFactory.AutoLoadObserver<String>(this) {
                    @Override
                    public void onNext(@NonNull String s) {
                        showMsg("提交成功");
                        finish();
                    }
                });
    }

}
