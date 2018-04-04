package com.suozhang.rentaluser.common.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.suozhang.framework.utils.T;
import com.suozhang.rentaluser.framework.Config;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    public static final String action = "jason.broadcast.action";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, Config.WxPayAppId);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.errCode == BaseResp.ErrCode.ERR_OK) {
            Intent intent = new Intent(action);
            intent.putExtra("data", true);
            sendBroadcast(intent);
        } else if (resp.errCode == BaseResp.ErrCode.ERR_COMM) {
            T.showLong("支付失败！" + resp.errStr);
        } else if (resp.errCode == BaseResp.ErrCode.ERR_USER_CANCEL) {
            T.showLong("取消支付！");
        } else if (resp.errCode == BaseResp.ErrCode.ERR_UNSUPPORT) {
            T.showLong("不支持错误！" + resp.errStr);
        } else if (resp.errCode == BaseResp.ErrCode.ERR_SENT_FAILED) {
            T.showLong("发送失败！" + resp.errStr);
        }
        finish();
    }


}