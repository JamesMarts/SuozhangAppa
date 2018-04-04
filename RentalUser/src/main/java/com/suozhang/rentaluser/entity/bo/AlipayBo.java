/*
 * Copyright (c) 2017. 深圳掌控网络有限公司. All rights reserved.
 */

package com.suozhang.rentaluser.entity.bo;

import com.suozhang.framework.entity.bo.BaseEntity;

/**
 * @author LIJUWEN
 * @email yiyayiyayaoljw@gmail.com
 * @date 2017/4/15 16:06
 */
public class AlipayBo implements BaseEntity{

    /**
     * partner : 2088811714156381
     * seller_id : suozhangsz@163.com
     * out_trade_no : 635dc4cafc904e7795080728c682a58a
     * subject : 01201705030004
     * body : 深圳香格里拉大酒店
     * total_fee : 48.00
     * notify_url : http://localhost:16311/Api/AliPayNotify
     * service : mobile.securitypay.pay
     * payment_type : 1
     * _input_charset : utf-8
     * it_b_pay : 30m
     * return_url : m.alipay.com
     * sign : P%2BgPG8Bvz2yjArmsawkakg7DVkD7Q4iFfeoSV7v5AlzkifIzJcKV1Rte6vmDS0MvB6CmqxkPKmc5xbohK0W4oHOMK6G%2Fc6lEpxwRYzWw4hdW5TBgOGVwFsKxd625JESoi3dlQrXBcxYn%2Brkodv%2FxzAzCgG78DlqbIJbCUQOYLrw%3D
     * sign_type : RSA
     */

    private String partner;
    private String seller_id;
    private String out_trade_no;
    private String subject;
    private String body;
    private String total_fee;
    private String notify_url;
    private String service;
    private String payment_type;
    private String _input_charset;
    private String it_b_pay;
    private String return_url;
    private String sign;
    private String sign_type;

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String get_input_charset() {
        return _input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getIt_b_pay() {
        return it_b_pay;
    }

    public void setIt_b_pay(String it_b_pay) {
        this.it_b_pay = it_b_pay;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    @Override
    public String toString() {
        return "AlipayBo{" +
                "partner='" + partner + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", total_fee='" + total_fee + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", service='" + service + '\'' +
                ", payment_type='" + payment_type + '\'' +
                ", _input_charset='" + _input_charset + '\'' +
                ", it_b_pay='" + it_b_pay + '\'' +
                ", return_url='" + return_url + '\'' +
                ", sign='" + sign + '\'' +
                ", sign_type='" + sign_type + '\'' +
                '}';
    }
}
