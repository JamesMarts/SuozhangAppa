package com.suozhang.rentaluser.feature.user.view;

import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.user.contract.EditPasswordContract;
import com.suozhang.rentaluser.feature.user.dependencies.editpwd.DaggerEditPasswordComponent;
import com.suozhang.rentaluser.feature.user.dependencies.editpwd.EditPasswordPresenterModule;

import javax.inject.Inject;

import butterknife.BindView;

public class ModifyPasswordActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, Toolbar.OnMenuItemClickListener, EditPasswordContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_user_edit_pssword)
    PowerfulEditText mEtUserEditPssword;
    @BindView(R.id.et_user_edit_new_pssword)
    PowerfulEditText mEtUserEditNewPssword;
    @BindView(R.id.et_user_edit_re_new_pssword)
    PowerfulEditText mEtUserEditReNewPssword;
    @BindView(R.id.et_password_forget)
    CheckBox mEtPasswordForget;

    @Inject
    EditPasswordContract.Presenter mPresenter;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected void initInjector() {
        DaggerEditPasswordComponent.builder().editPasswordPresenterModule(new EditPasswordPresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        super.initView();
        mEtPasswordForget.setOnCheckedChangeListener(this);
        mToolbar.setOnMenuItemClickListener(this);
        mToolbar.inflateMenu(R.menu.menu_contact_edit);
        initToolBar(mToolbar, "修改密码", true, true);

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        showPassword(isChecked);

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            mPresenter.editPassword(mEtUserEditPssword.getText().toString(),
                    mEtUserEditNewPssword.getText().toString(),
                    mEtUserEditReNewPssword.getText().toString()
            );
        }
        return false;
    }

    private void showPassword(boolean isShow) {
        if (isShow) {
            //如果选中，显示密码
            mEtUserEditPssword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            mEtUserEditNewPssword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            mEtUserEditReNewPssword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            //否则隐藏密码
            mEtUserEditPssword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            mEtUserEditNewPssword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            mEtUserEditReNewPssword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        }
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void showSuccessMsg(String msg) {
        T.showShort("修改成功！");
        finishActivity();
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }
}

