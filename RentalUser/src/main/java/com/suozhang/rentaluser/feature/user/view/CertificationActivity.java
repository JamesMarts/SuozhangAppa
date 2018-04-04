package com.suozhang.rentaluser.feature.user.view;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.suozhang.framework.framework.AM;
import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.entity.bo.ZMBo;
import com.suozhang.rentaluser.feature.user.contract.CertificationContract;
import com.suozhang.rentaluser.feature.user.dependencies.certification.CertificationPresenterModule;
import com.suozhang.rentaluser.feature.user.dependencies.certification.DaggerCertificationComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class CertificationActivity extends BaseActivity implements CertificationContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.button)
    Button mButton;
    @Inject
    CertificationContract.Presenter mPresenter;
    @BindView(R.id.editText)
    PowerfulEditText mEditText;
    @BindView(R.id.editText2)
    PowerfulEditText mEditText2;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_certification;
    }

    @Override
    protected void initInjector() {
        DaggerCertificationComponent.builder().certificationPresenterModule(new CertificationPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar, "认证", true, true);
    }

    @Override
    protected void initData() {
        if (AM.user().isLogin()) {
            mPresenter.doCheckZhimaScore();
        } else {
            finish();
        }
    }

    @Override
    public void showSuccessMsg(String msg) {
        Intent intent = new Intent(this, AuthWebActivity.class);
        intent.putExtra("url", msg);
        startActivity(intent);
    }

    @Override
    public void showZMSuccessMsg(ZMBo msg) {
       if (msg!=null){
           if (msg.isHasZhimaOpenId()){

           }else {

           }
       }
    }

    @Override
    public void showZMErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }


    @OnClick(R.id.button)
    public void onViewClicked() {
        mPresenter.doEditName(mEditText2.getText().toString(), mEditText.getText().toString());
    }


}
