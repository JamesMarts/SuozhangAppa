package com.suozhang.rentaluser.feature.user.view.adapter;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

import com.suozhang.framework.framework.BaseActivity;
import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.R;
import com.suozhang.rentaluser.common.util.DateUtil;
import com.suozhang.rentaluser.entity.bo.MessageBo;
import com.suozhang.rentaluser.feature.user.contract.MessageContract;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.DaggerMessageComponent;
import com.suozhang.rentaluser.feature.user.dependencies.messagetype.MessagePresenterModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MessageViewActivity extends BaseActivity implements MessageContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_message_name)
    TextView mTvMessageName;
    @BindView(R.id.tv_message_date)
    TextView mTvMessageDate;
    @BindView(R.id.tv_message_content)
    TextView mTvMessageContent;
    private String mMsgId;
    @Inject
    MessageContract.Presenter mPresenter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_message_view;
    }

    MessageBo mData = null;

    @Override
    protected void initInjector() {
        DaggerMessageComponent.builder().messagePresenterModule(new MessagePresenterModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        initToolBar(mToolbar,"消息详情",true,true);
        mMsgId = this.getIntent().getStringExtra("msgId");
    }

    @Override
    protected void initData() {
        if (!TextUtils.isEmpty(mMsgId)) {
            mPresenter.doMessageView(mMsgId);
            mPresenter.doUpdateMessageState(mMsgId);
        }
    }


    @Override
    public void showSuccess(List<MessageBo> houseRoomBos) {


    }

    @Override
    public void showMessageViewSuccess(MessageBo houseRoomBo) {
        mData = houseRoomBo;
        initDataView(mData);

    }

    @Override
    public void showErrorMsg(String msg) {
        T.showShort(msg);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showMessageInfoSuccess(List<MessageBo> houseRoomBos) {

    }

    void initDataView(MessageBo data) {
        mTvMessageName.setText(TextUtils.isEmpty(data.getName()) ? "" : data.getName());
        mTvMessageContent.setText(TextUtils.isEmpty(data.getContentInfo()) ? "" : data.getContent());
        mTvMessageName.setText(TextUtils.isEmpty(data.getName()) ? "" : data.getName());

        boolean num = DateUtil.isToday(data.getCreateTime());

        if (num) {
            mTvMessageDate.setText(DateUtil.getHourByDate(data.getCreateTime()));
        } else {
            mTvMessageDate.setText(DateUtil.getTimeStr(data.getCreateTime()));
        }
    }
}
