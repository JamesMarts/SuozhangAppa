package com.suozhang.rentaluser.feature.user.view;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.framework.widget.PowerfulEditText;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.feature.user.contract.EditNameContract;
import com.suozhang.rentaluser.feature.user.dependencies.editname.DaggerEditNameComponent;
import com.suozhang.rentaluser.feature.user.dependencies.editname.EditNamePresenterModule;

import javax.inject.Inject;

import butterknife.BindView;

public class EditNickNameActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener, EditNameContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_user_nickname)
    PowerfulEditText mEtNickname;
    private String mName;

    @Inject
    EditNameContract.Presenter mPresenter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_edit_nick_name;
    }

    @Override
    protected void initInjector() {
        DaggerEditNameComponent.builder().editNamePresenterModule(new EditNamePresenterModule(this)).build().inject(this);
    }


    @Override
    protected void initView() {
        mToolbar.inflateMenu(R.menu.menu_contact_edit);
        mToolbar.setOnMenuItemClickListener(this);
        initToolBar(mToolbar, "编辑昵称", true, true);
    }

    @Override
    protected void initData() {
        mName = this.getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(mName))
            mEtNickname.setText(mName);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            if (TextUtils.isEmpty(mEtNickname.getText().toString())) {
                T.showShort("请输入用户昵称！");
                return false;
            }

            mPresenter.doEditName(mEtNickname.getText().toString());
        }
        return false;
    }

    @Override
    public void showSuccessMsg(String msg) {
        T.showShort("修改成功!");
        finish();
    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }
}
