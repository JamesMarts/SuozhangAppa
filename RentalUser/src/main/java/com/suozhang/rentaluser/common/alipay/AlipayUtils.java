/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.common.alipay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.suozhang.framework.utils.logger.Logger;
import com.suozhang.rentaluser.entity.bo.AlipayBo;
import com.suozhang.rentaluser.feature.life.view.BillingDetailActivity;


public class AlipayUtils {
    private String mTradeNo = "";
    private Activity mActivity;
    private Handler mHandler;

    public AlipayUtils(Activity activity, Handler handler, String tradeNo) {
        mActivity = activity;
        mHandler = handler;
        mTradeNo = tradeNo;
    }

    /**
     * call alipay sdk pay. 调用SDK支付
     */
    public void pay(AlipayBo ob) {
        if (TextUtils.isEmpty(ob.getPartner()) || TextUtils.isEmpty(ob.getSeller_id()) || TextUtils.isEmpty(ob.getSign())) {
            new AlertDialog.Builder(mActivity).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialoginterface, int i) {
                    mActivity.finish();
                }
            }).show();
            return;
        }

        // 订单
        String orderInfo = getOrderInfo(ob);

        // 完整的符合支付宝参数规范的订单信息
        final String payInfo = orderInfo + "&sign=\"" + ob.getSign() + "\"&" + getSignType();

        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask payTask = new PayTask(mActivity);
                String result = payTask.pay(payInfo, true);
                Message msg = new Message();
                msg.what = BillingDetailActivity.MSG_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * check whether the device has authentication alipay account.
     * 查询终端设备是否存在支付宝认证账户
     */
    public void check() {
        Runnable checkRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask payTask = new PayTask(mActivity);

                // 调用查询接口，获取查询结果
                // boolean isExist = payTask.checkAccountIfExist();

                Message msg = new Message();
                msg.what = BillingDetailActivity.MSG_CHECK_FLAG;
                //  msg.obj = isExist;
                mHandler.sendMessage(msg);
            }
        };

        Thread checkThread = new Thread(checkRunnable);
        checkThread.start();
    }

    /**
     * get the sdk version. 获取SDK版本号
     */
    public void getSDKVersion() {
        PayTask payTask = new PayTask(mActivity);
        String version = payTask.getVersion();
        Toast.makeText(mActivity, version, Toast.LENGTH_SHORT).show();
    }

    /**
     * create the order info. 创建订单信息
     */
    public String getOrderInfo(AlipayBo ob) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + ob.getPartner() + "\"";
        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + ob.getSeller_id() + "\"";
        // 商户网站唯一订单号

        Logger.e("订单号为：----》" + getOutTradeNo());

        orderInfo += "&out_trade_no=" + "\"" + ob.getOut_trade_no() + "\"";
        // 商品名称
        orderInfo += "&subject=" + "\"" + ob.getSubject() + "\"";
        // 商品详情
        orderInfo += "&body=" + "\"" + ob.getBody() + "\"";
        // 商品金额
        orderInfo += "&total_fee=" + "\"" + ob.getTotal_fee() + "\"";
        // 服务器异步通知页面路径
        // orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";
        orderInfo += "&notify_url=" + "\"" + ob.getNotify_url() + "\"";
        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";
        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";
        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    public String getOutTradeNo() {

        return mTradeNo;
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    public String getSignType() {
        return "sign_type=\"RSA\"";
    }

}
